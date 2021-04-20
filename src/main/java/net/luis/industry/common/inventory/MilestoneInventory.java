package net.luis.industry.common.inventory;

import net.luis.industry.api.inventory.IRecipeInventory;
import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;

public class MilestoneInventory implements IRecipeInventory {
	
	private ItemStackList input;
	private ItemStackList output;
	
	public MilestoneInventory(int sizeInput, int sizeOutput) {
		this.input = ItemStackList.withSize(sizeInput, ItemStack.EMPTY);
		this.output = ItemStackList.withSize(sizeOutput, ItemStack.EMPTY);
	}
	
	public MilestoneInventory(ItemStackList input, ItemStackList output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public ItemStackList getInput() {
		return this.input;
	}

	@Override
	public ItemStackList getOutput() {
		return this.output;
	}

	@Override
	public int sizeInput() {
		return this.input.size();
	}

	@Override
	public int sizeOutput() {
		return this.output.size();
	}
	
	public void setInputSize(int size) {
		this.input = ItemStackList.withSize(size, ItemStack.EMPTY);
	}
	
	public void setOutputSize(int size) {
		this.output = ItemStackList.withSize(size, ItemStack.EMPTY);
	}
	
	@Override
	public boolean hasEmptySlots(ItemStackList inventory) {
		
		boolean hasEmptySlots = false;
		
		for (int i = 0; i < inventory.size(); i++) {
			
			if (this.isSlotEmpty(inventory, i)) {
				
				hasEmptySlots = true;
				break;
				
			}
			
		}
		
		return hasEmptySlots;
		
	}

	@Override
	public boolean isSlotEmpty(ItemStackList inventory, int slot) {
		return inventory.get(slot).isEmpty();
	}
	
	@Override
	public ItemStack insert(int slot, ItemStack itemStack, ItemStackList inventory) {
		
		if (itemStack.isEmpty()) {
			return ItemStack.EMPTY;
		}
		
		if (slot >= 0) {
			
			ItemStack inventoryStack = this.input.get(slot);
			
			if (inventoryStack.isEmpty()) {
				
				inventory.set(slot, itemStack);
				return ItemStack.EMPTY;
				
			} else if (inventoryStack.getItem() == itemStack.getItem()) {
				
				int count = inventoryStack.getCount() + itemStack.getCount();
				
				if (inventoryStack.getCount() == inventoryStack.getMaxStackSize()) {
					
					return itemStack;
					
				} else {
					
					if (inventoryStack.getMaxStackSize() >= count) {
						
						inventory.set(slot, new ItemStack(inventoryStack.getItem(), count));
						return ItemStack.EMPTY;
						
					} else {
						
						int leftCount = count - inventoryStack.getMaxStackSize();
						Item leftItem = inventoryStack.getItem();
						inventory.set(slot, new ItemStack(inventoryStack.getItem(), inventoryStack.getMaxStackSize()));
						return new ItemStack(leftItem, leftCount);
						
					}
					
				}
				
			}
			
		} else {
			
			return this.tryInsert(itemStack, inventory);
			
		}
		
		return ItemStack.EMPTY;
		
	}

	@Override
	public ItemStack extract(int slot, ItemStack itemStack, ItemStackList inventory) {
		return this.tryExtract(slot, slot, inventory);
	}
	
	protected ItemStack tryInsert(ItemStack itemStack, ItemStackList inventory) {
		
		ItemStack inventoryStack = ItemStack.EMPTY;
		
		for (int i = 0; i < inventory.size(); i++) {
			
			inventoryStack = inventory.get(i);
			
			if (inventoryStack.isEmpty()) {
				
				inventory.set(i, itemStack);
				return ItemStack.EMPTY;
				
			} else if (inventoryStack.getItem() == itemStack.getItem()) {
				
				int count = inventoryStack.getCount() + itemStack.getCount();
				
				if (inventoryStack.getCount() == inventoryStack.getMaxStackSize()) {
					
					continue;
					
				} else {
					
					if (inventoryStack.getMaxStackSize() >= count) {
						
						inventory.set(i, new ItemStack(inventoryStack.getItem(), count));
						return ItemStack.EMPTY;
						
					} else {
						
						Item leftItem = inventoryStack.getItem();
						int leftCount = count - inventoryStack.getMaxStackSize();
						inventory.set(i, new ItemStack(inventoryStack.getItem(), inventoryStack.getMaxStackSize()));
						itemStack = new ItemStack(leftItem, leftCount);
						
					}
					
				}
				
			}
			
		}
		
		return itemStack;
		
	}

	protected ItemStack tryExtract(int slot, int count, ItemStackList inventory) {
		
		for (int i = 0; i < inventory.size(); i++) {
			
			ItemStack inventoryStack = inventory.get(i);
			
			if (!inventoryStack.isEmpty()) {
				
				if (i == slot) {
					
					if (count >= inventoryStack.getCount()) {
						
						inventory.setDefault(slot);
						
					} else {
						
						Item item = inventoryStack.getItem();
						int leftCount = inventoryStack.getCount() - count;
						inventory.set(i, new ItemStack(item, leftCount));
						return new ItemStack(item, count);
						
					}
					
				}
				
			}
			
		}
		
		return this.tryExtract(inventory);
		
	}
	
	protected ItemStack tryExtract(ItemStackList inventory) {
		
		for (int i = 0; i < inventory.size(); i++) {
			
			ItemStack inventoryStack = inventory.get(i);
			
			if (!inventoryStack.isEmpty()) {
				
				inventory.setDefault(i);
				return inventoryStack;
				
			}
			
		}
		
		return ItemStack.EMPTY;
		
	}
	
	@Override
	public void clearInput() {
		this.input.clear();
	}

	@Override
	public void clearOutput() {
		this.output.clear();
	}

	@Override
	public ItemStackList clearAndGetInput() {
		ItemStackList tempList = this.getInput();
		this.clearInput();
		return tempList;
	}

	@Override
	public ItemStackList clearAndGetOutput() {
		ItemStackList tempList = this.getOutput();
		this.clearOutput();
		return tempList;
	}

	@Override
	public CompoundNBT serializeNBT(CompoundNBT nbt) {
		
		ListNBT inputList = new ListNBT();
		ListNBT outputList = new ListNBT();
		
		for (int i = 0; i < this.input.size(); i++) {
			
			if (!this.input.get(i).isEmpty()) {
				
				CompoundNBT itemTag = new CompoundNBT();
				itemTag.putInt("slot", i);
				input.get(i).save(itemTag);
				inputList.add(itemTag);
				
			}
			
		}
		
		for (int i = 0; i < this.output.size(); i++) {
			
			if (!this.output.get(i).isEmpty()) {
				
				CompoundNBT itemTag = new CompoundNBT();
				itemTag.putInt("slot", i);
				output.get(i).save(itemTag);
				outputList.add(itemTag);
				
			}
			
		}
		
		nbt.put("input", inputList);
		nbt.putInt("inputSize", input.size());
		nbt.put("output", outputList);
		nbt.putInt("outputSize", output.size());
		
		return nbt;
		
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
		this.setInputSize(nbt.getInt("inputSize"));
		this.setOutputSize(nbt.getInt("outputSize"));
		ListNBT inputList = nbt.getList("input", Constants.NBT.TAG_COMPOUND);
		ListNBT outputList = nbt.getList("input", Constants.NBT.TAG_COMPOUND);
		
		for (int i = 0; i < inputList.size(); i++) {
			
			CompoundNBT itemTags = inputList.getCompound(i);
			int slot = itemTags.getInt("slot");

			if (slot >= 0 && slot < this.input.size()) {
				
				this.input.set(slot, ItemStack.of(itemTags));
				
			}
			
		}
		
		for (int i = 0; i < outputList.size(); i++) {
			
			CompoundNBT itemTags = outputList.getCompound(i);
			int slot = itemTags.getInt("slot");

			if (slot >= 0 && slot < this.output.size()) {
				
				this.output.set(slot, ItemStack.of(itemTags));
				
			}
			
		}
		
	}

}
