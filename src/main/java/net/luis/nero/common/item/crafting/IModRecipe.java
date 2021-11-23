package net.luis.nero.common.item.crafting;

import net.luis.nero.common.inventory.ModItemStackHandler;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public interface IModRecipe extends Recipe<ModItemStackHandler> {
	
	@Override
	default ItemStack assemble(ModItemStackHandler inventory) {
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
	
	@Override
	default boolean canCraftInDimensions(int width, int height) {
		return true;
	}
	
	NonNullList<ItemStack> getInput();
	
	NonNullList<ResultItem> getResult();
	
}
