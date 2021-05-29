package net.luis.nero.api.recipe;

import java.util.List;
import java.util.UUID;

import net.luis.nero.api.inventory.ItemStackList;
import net.luis.nero.api.util.exception.AlreadyRegisteredException;
import net.luis.nero.common.enums.ModRecipeType;
import net.minecraft.item.ItemStack;

public interface IModRecipeHelper<T extends IModRecipe> {
	
	void createRecipeList();
	
	void registerRecipe(T recipe) throws AlreadyRegisteredException;
	
	boolean isRecipeRegistered(T recipe);
	
	ModRecipeType getRecipeType();
	
	List<T> getRecipes();
	
	boolean hasRecipe(ItemStack stack);
	
	List<ItemStack> getItemsForRecipe(T recipe);
	
	T getNextRecipe(ItemStackList inventory);
	
	T getRandomRecipe(ItemStackList inventory);
	
	T getRecipeFromId(UUID id);
	
}
