package net.luis.nero.api.common.inventory;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public interface IModInventory {
	
	ModItemStackHandler get();
	
	boolean hasEmptySlots();
	
	boolean isSlotEmpty(int slot);
	
	InventorySlot getSlotWithStack(ItemStack itemStack, boolean ignoreCount, boolean ignoreTag);
	
	ItemStack insert(int slot, ItemStack itemStack);
	
	ItemStack extract(int slot, ItemStack itemStack, boolean next);
	
	void clear();
	
	ModItemStackHandler getAndClear();
	
	CompoundTag serializeNBT(CompoundTag tag);
	
	void deserializeNBT(CompoundTag tag);
	
}
