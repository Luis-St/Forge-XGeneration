package net.luis.industry.api.tileentities;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.util.RecipeList;

public interface IRecipeProvider<T extends IModRecipe> {
	
	RecipeList<T> getRecipeList();
	
	IModRecipeHelper<T> getRecipeHelper();
	
}
