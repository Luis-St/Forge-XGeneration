package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.minecraft.item.ItemStack;

public interface IModRecipe {
	
	List<ItemStack> getRecipeItems();
	
	List<ResultItemStack> getAllResultItems();
	
	List<ItemStack> getResultItemsWithChance();
	
	int getRecipeItemMaxCount();
	
	int getResultItemMaxCount();
	
	default int getRecipeProgressTime() {
		return 0;
	}
	
	default boolean containsRecipeItem(ItemStack itemStack) {
		
		boolean contains = false;
		
		for (ItemStack recipeStack : this.getRecipeItems()) {
			contains = IModRecipe.equals(recipeStack, itemStack);
		}
		
		return contains;
		
	}
	
	boolean allItemsAvailable(List<ItemStack> itemStacks);
	
	static boolean equals(ItemStack recipeStack, ItemStack toCheck) {
		
		if (recipeStack.getItem() == toCheck.getItem()) {
			
			if (recipeStack.getCount() == toCheck.getCount()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

}
