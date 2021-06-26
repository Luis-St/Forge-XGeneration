package net.luis.nero.api.common.recipe;

import net.luis.nero.api.common.recipe.item.ResultItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

public interface IModRecipe<C extends IInventory> extends IRecipe<C> {
	
	// TODO: finish 
	
	@Override
	default ItemStack assemble(C inventory) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	default ItemStack getResultItem() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	default NonNullList<Ingredient> getIngredients() {
		throw new UnsupportedOperationException();
	}
	
	NonNullList<ItemStack> getInput();
	
	NonNullList<ResultItemStack> getResult();
	
}
