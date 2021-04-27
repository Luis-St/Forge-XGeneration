package net.luis.industry.common.inventory;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.luis.industry.api.inventory.InventorySlot;
import net.luis.industry.api.inventory.recipe.IRecipeInventory;
import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;

public class RecipeInventory implements IRecipeInventory {
	
	private ItemStackList input;
	private ItemStackList output;
	
	public RecipeInventory(int sizeInput, int sizeOutput) {
		this.input = ItemStackList.withSize(sizeInput, ItemStack.EMPTY);
		this.output = ItemStackList.withSize(sizeOutput, ItemStack.EMPTY);
	}
	
	public RecipeInventory(ItemStackList input, ItemStackList output) {
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
	
	protected void setInputSize(int size) {
		this.input = ItemStackList.withSize(size, ItemStack.EMPTY);
	}
	
	protected void setOutputSize(int size) {
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
	public List<InventorySlot> hasItemsForRecipe(ItemStackList inventory, IModRecipe recipe) {
		List<InventorySlot> inventorySlots = new ArrayList<InventorySlot>();
		for (ItemStack itemStack : recipe.getInput()) {
			inventorySlots.add(this.getSlotWithStack(inventory, itemStack));
		}
		if (inventorySlots.size() >= recipe.getInput().size()) {
			return inventorySlots;
		}
		return Lists.newArrayList();
	}
	
	@Override
	public InventorySlot getSlotWithStack(ItemStackList inventory, ItemStack itemStack) {
		ItemStack slotStack = ItemStack.EMPTY;
		int slot = 0;
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack inventoryStack = inventory.get(i);
			if (this.equalsStack(itemStack, inventoryStack, false)) {
				slotStack = inventoryStack;
				slot = i;
				break;
			}
		}
		return new InventorySlot(slotStack, slot);
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
	public ItemStack extract(int slot, ItemStack itemStack, ItemStackList inventory, boolean next) {
		if (slot > 0) {
			return this.tryExtract(slot, itemStack, inventory);
		} else if (itemStack.isEmpty() && slot < 0 && next) {
			return this.tryExtractNext(inventory);
		}
		return this.tryExtractItemStack(itemStack, inventory);
	}
	
	@Override
	public void extractRecipe(IModRecipe recipe, ItemStackList inventory) {
		for (ItemStack itemStack : recipe.getInput()) {
			this.extract(-1, itemStack, inventory, false);
		}
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
	
	protected ItemStack tryExtract(int slot, ItemStack itemStack, ItemStackList inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack inventoryStack = inventory.get(i);
			if (!inventoryStack.isEmpty()) {
				if (i == slot) {
					if (itemStack.isEmpty()) {
						inventory.setDefault(slot);
						return inventoryStack;
					} else {
						if (itemStack.getItem() == inventoryStack.getItem()) {
							if (itemStack.getCount() >= inventoryStack.getCount()) {	
								inventory.setDefault(slot);
								return inventoryStack;
							} else {
								Item item = inventoryStack.getItem();
								int leftCount = inventoryStack.getCount() - itemStack.getCount();
								inventory.set(i, new ItemStack(item, leftCount));
								return new ItemStack(item, itemStack.getCount());
							}
						}
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	protected ItemStack tryExtractItemStack(ItemStack itemStack, ItemStackList inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack inventoryStack = inventory.get(i);
			if (!itemStack.isEmpty() && this.equalsStack(itemStack, inventoryStack, true)) {
				if (itemStack.getCount() >= inventoryStack.getCount()) {
					inventory.setDefault(i);
					return inventoryStack;
				} else {
					Item item = inventoryStack.getItem();
					int leftCount = inventoryStack.getCount() - itemStack.getCount();
					inventory.set(i, new ItemStack(item, leftCount));
					return new ItemStack(item, itemStack.getCount());
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	protected ItemStack tryExtractNext(ItemStackList inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack inventoryStack = inventory.get(i);
			if (inventoryStack.isEmpty()) {
				continue;
			} else {
				inventory.setDefault(i);
				return inventoryStack;
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean equalsStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags) {
		if (itemStack.getItem() == toCheck.getItem()) {
			return toCheck.getCount() >= itemStack.getCount() || ignoreTags;
		}
		return false;
	}
	
	@Override
	public void clear(ItemStackList inventory) {
		inventory.clear();
	}
	
	@Override
	public void clearAll() {
		this.clear(this.input);
		this.clear(this.output);
	}

	@Override
	public ItemStackList getAndClear(ItemStackList inventory) {
		ItemStackList tempList = inventory;
		this.clear(inventory);
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
