package net.luis.industry.common.inventory;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.luis.industry.api.inventory.InventorySlot;
import net.luis.industry.api.inventory.ItemStackList;
import net.luis.industry.api.inventory.recipe.IRecipeInventory;
import net.luis.industry.api.recipe.IModRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;

public class RecipeInventory implements IRecipeInventory {
	
	private ItemStackList inventory;
	
	public RecipeInventory(int size) {
		this(ItemStackList.withSize(size, ItemStack.EMPTY));
	}
	
	public RecipeInventory(ItemStackList inventory) {
		this.inventory = inventory;
	}

	@Override
	public ItemStackList get() {
		return this.inventory;
	}
	
	protected void setSize(int size) {
		this.inventory = ItemStackList.withSize(size, ItemStack.EMPTY);
	}
	
	@Override
	public boolean hasEmptySlots() {
		boolean hasEmptySlots = false;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.isSlotEmpty(i)) {
				hasEmptySlots = true;
				break;
			}
		}
		return hasEmptySlots;
	}

	@Override
	public boolean isSlotEmpty(int slot) {
		return this.inventory.get(slot).isEmpty();
	}
	
	@Override
	public List<InventorySlot> hasItemsForRecipe(IModRecipe recipe) {
		List<InventorySlot> inventorySlots = new ArrayList<InventorySlot>();
		for (ItemStack itemStack : recipe.getInput()) {
			inventorySlots.add(this.getSlotWithStack(itemStack, false, true));
		}
		if (inventorySlots.size() >= recipe.getInput().size()) {
			return inventorySlots;
		}
		return Lists.newArrayList();
	}
	
	@Override
	public InventorySlot getSlotWithStack(ItemStack itemStack, boolean ignoreCount, boolean ignoreTag) {
		ItemStack slotStack = ItemStack.EMPTY;
		int slot = 0;
		for (int i = 0; i < this.inventory.size(); i++) {
			ItemStack inventoryStack = this.inventory.get(i);
			if (this.equalsStack(itemStack, inventoryStack, ignoreCount, ignoreTag)) {
				slotStack = inventoryStack;
				slot = i;
				break;
			}
		}
		return new InventorySlot(slotStack, slot);
	}
	
	@Override
	public ItemStack insert(int slot, ItemStack itemStack) {
		if (itemStack.isEmpty()) {
			return ItemStack.EMPTY;
		}
		if (slot >= 0) {
			ItemStack inventoryStack = this.inventory.get(slot);
			if (inventoryStack.isEmpty()) {
				this.inventory.set(slot, itemStack);
				return ItemStack.EMPTY;
			} else if (inventoryStack.getItem() == itemStack.getItem()) {
				int count = inventoryStack.getCount() + itemStack.getCount();
				if (inventoryStack.getCount() == inventoryStack.getMaxStackSize()) {
					return itemStack;
				} else {
					if (inventoryStack.getMaxStackSize() >= count) {
						this.inventory.set(slot, new ItemStack(inventoryStack.getItem(), count));
						return ItemStack.EMPTY;
					} else {
						int leftCount = count - inventoryStack.getMaxStackSize();
						Item leftItem = inventoryStack.getItem();
						this.inventory.set(slot, new ItemStack(inventoryStack.getItem(), inventoryStack.getMaxStackSize()));
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
	public ItemStack extract(int slot, ItemStack itemStack, boolean next) {
		if (slot > 0) {
			return this.tryExtract(slot, itemStack, this.inventory);
		} else if (itemStack.isEmpty() && slot < 0 && next) {
			return this.tryExtractNext(this.inventory);
		}
		return this.tryExtractItemStack(itemStack, this.inventory);
	}
	
	@Override
	public void extractRecipe(IModRecipe recipe) {
		for (ItemStack itemStack : recipe.getInput()) {
			this.extract(-1, itemStack, false);
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
			if (!itemStack.isEmpty() && this.equalsStack(itemStack, inventoryStack, false, true)) {
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
	
	private boolean equalsStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreCount, boolean ignoreTag) {
		if (itemStack.getItem() == toCheck.getItem()) {
			if (toCheck.getCount() >= itemStack.getCount() || ignoreCount)
			return toCheck.areShareTagsEqual(itemStack)|| ignoreTag;
		}
		return false;
	}
	
	@Override
	public void clear() {
		this.inventory.clear();
	}

	@Override
	public ItemStackList getAndClear() {
		ItemStackList tempInventory = this.inventory;
		this.clear();
		return tempInventory;
	}

	@Override
	public CompoundNBT serializeNBT(CompoundNBT nbt) {
		ListNBT inputList = new ListNBT();
		for (int i = 0; i < this.inventory.size(); i++) {
			if (!this.inventory.get(i).isEmpty()) {
				CompoundNBT itemTag = new CompoundNBT();
				itemTag.putInt("slot", i);
				this.inventory.get(i).save(itemTag);
				inputList.add(itemTag);
			}
		}
		nbt.put("inventory", inputList);
		nbt.putInt("inventorySize", this.inventory.size());
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.setSize(nbt.getInt("inventorySize"));
		ListNBT inventoryList = nbt.getList("input", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < inventoryList.size(); i++) {
			CompoundNBT itemTags = inventoryList.getCompound(i);
			int slot = itemTags.getInt("slot");
			if (slot >= 0 && slot < this.inventory.size()) {
				this.inventory.set(slot, ItemStack.of(itemTags));
			}
		}
	}

}
