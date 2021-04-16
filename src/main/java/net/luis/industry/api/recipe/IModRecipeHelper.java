package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.item.ItemStack;

public interface IModRecipeHelper<T extends IModRecipe> {
	
	ModRecipeType getRecipeType();
	
	List<T> getRecipes();
	
	boolean hasRecipe(ItemStack stack);
	
	List<ItemStack> getItemsForRecipe(T recipe);
	
}
