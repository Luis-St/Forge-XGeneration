package net.luis.industry.api.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface IModInventory {
	
	ItemStackList get();
	
	boolean hasEmptySlots();
	
	boolean isSlotEmpty(int slot);
	
	InventorySlot getSlotWithStack(ItemStack itemStack, boolean ignoreCount, boolean ignoreTag);
	
	ItemStack insert(int slot, ItemStack itemStack);
	
	ItemStack extract(int slot, ItemStack itemStack, boolean next);
	
	void clear();
	
	ItemStackList getAndClear();
	
	CompoundNBT serializeNBT(CompoundNBT nbt);
	
	void deserializeNBT(CompoundNBT nbt);
	
}
