package net.luis.industry.api.recipe;

import net.luis.industry.api.recipe.util.RecipeInput;
import net.luis.industry.api.recipe.util.RecipeOutput;

public interface IModRecipe {
	
	RecipeInput getRecipeInput();
	
	RecipeOutput getRecipeOutput();
	
	default int getRecipeTime() {
		return 0;
	}

}
