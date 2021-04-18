package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.api.util.exception.AlreadyRegisteredException;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.item.ItemStack;

public interface IModRecipeHelper<T extends IModRecipe> {
	
	void createRecipeList();
	
	void registerRecipe(T recipe) throws AlreadyRegisteredException;
	
	boolean isRecipeRegistered(T recipe);
	
	ModRecipeType getRecipeType();
	
	List<T> getRecipes();
	
	boolean hasRecipe(ItemStack stack);
	
	List<ItemStack> getItemsForRecipe(T recipe);
	
	T getRecipeForItems(ItemStack... itemStacks);
	
}
