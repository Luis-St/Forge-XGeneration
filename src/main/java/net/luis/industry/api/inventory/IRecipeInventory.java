package net.luis.industry.api.inventory;

import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface IRecipeInventory {
	
	ItemStackList getInput();
	
	ItemStackList getOutput();
	
	int sizeInput();
	
	int sizeOutput();
	
	boolean hasEmptySlots(ItemStackList inventory);
	
	boolean isSlotEmpty(ItemStackList inventory, int slot);
	
	ItemStack insert(int slot, ItemStack itemStack, ItemStackList inventory);
	
	ItemStack extract(int slot, ItemStack itemStack, ItemStackList inventory);
	
	void clearInput();
	
	void clearOutput();
	
	ItemStackList clearAndGetInput();
	
	ItemStackList clearAndGetOutput();
	
	CompoundNBT serializeNBT(CompoundNBT nbt);
	
	void deserializeNBT(CompoundNBT nbt);
	
}
