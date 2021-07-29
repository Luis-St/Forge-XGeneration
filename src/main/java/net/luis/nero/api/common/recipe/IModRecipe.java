package net.luis.nero.api.common.recipe;

import net.luis.nero.api.common.recipe.item.ResultItemStack;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.NonNullList;

public interface IModRecipe<C extends Container> extends Recipe<C> {
	
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
