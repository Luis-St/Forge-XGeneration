package net.luis.industry.api.inventory.recipe;

import java.util.List;

import net.luis.industry.api.inventory.InventorySlot;
import net.luis.industry.api.inventory.ItemStackList;
import net.luis.industry.api.recipe.IModRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface IRecipeInventory {
	
	ItemStackList getInput();
	
	ItemStackList getOutput();
	
	boolean hasEmptySlots(ItemStackList inventory);
	
	boolean isSlotEmpty(ItemStackList inventory, int slot);
	
	List<InventorySlot> hasItemsForRecipe(ItemStackList inventory, IModRecipe recipe);
	
	InventorySlot getSlotWithStack(ItemStackList inventory, ItemStack itemStack);
	
	ItemStack insert(int slot, ItemStack itemStack, ItemStackList inventory);
	
	ItemStack extract(int slot, ItemStack itemStack, ItemStackList inventory, boolean next);
	
	void extractRecipe(IModRecipe recipe, ItemStackList inventory);
	
	void clear(ItemStackList inventory);
	
	void clearAll();
	
	ItemStackList getAndClear(ItemStackList inventory);
	
	CompoundNBT serializeNBT(CompoundNBT nbt);
	
	void deserializeNBT(CompoundNBT nbt);
	
}
