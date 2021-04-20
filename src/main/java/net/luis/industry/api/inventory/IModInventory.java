package net.luis.industry.api.inventory;

import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.ItemStack;

public interface IModInventory {
	
	ItemStackList get();
	
	void set(ItemStackList inventory);
	
	int size();
	
	int getNextEmptySlot();
	
	int getNextSlotWith(ItemStack itemStack);
	
	ItemStack insertItemStack(ItemStack itemStack);
	
	ItemStack extractNextItemStack();
	
	ItemStack extractItemStack(ItemStack itemStack);
	
	ItemStack extractItemStack(int slot);
	
	void clear();
	
	ItemStackList clearAndGet();
	
}
