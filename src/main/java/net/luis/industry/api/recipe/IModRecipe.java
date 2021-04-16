package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.minecraft.item.ItemStack;

public interface IModRecipe {
	
	List<ItemStack> getRecipeItems();
	
	List<ResultItemStack> getResultItems();
	
	default int getProgressTime() {
		return 0;
	}
	
	boolean isRecipeItem(ItemStack itemStack);
	
	boolean isResultItem(ItemStack itemStack);
	
	boolean isItemRequired(ItemStack itemStack);

}
