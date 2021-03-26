package net.luis.industry.api.recipe;

import net.luis.industry.api.recipe.util.RecipeInput;
import net.luis.industry.api.recipe.util.RecipeOutput;
import net.minecraft.item.ItemStack;

public interface IModRecipeHelper<T extends IModRecipe> {
	
	boolean hasRecipe(ItemStack stack);
	
	boolean hasRecipeWith(ItemStack stack);
	
	RecipeInput getRecipeInput(T recipe);
	
	RecipeOutput getRecipeOutput(T recipe);
	
	T getRecipe();
	
}
