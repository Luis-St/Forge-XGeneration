package net.luis.nero.api.recipe;

import java.util.List;
import java.util.UUID;

import net.luis.nero.api.inventory.ItemStackList;
import net.luis.nero.api.recipe.item.ResultItemStack;
import net.minecraft.item.ItemStack;

public interface IModRecipe {
	
	UUID getId();
	
	IModRecipeHelper<?> getRecipeHelper();
	
	List<ItemStack> getInput();
	
	List<ResultItemStack> getResultItems();
	
	List<ItemStack> getResult();
	
	int getMaxInput();
	
	int getMaxResult();
	
	int getProgressTime();
	
	boolean containsAll(ItemStackList inventory);
	
	boolean containsItemStack(ItemStack toCheck, boolean ignoreTags);
	
	boolean equalsId(IModRecipe toCheck);
	
	boolean equalsItemStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags);
	
	boolean equalsResultItemStack(ResultItemStack resultStack, ResultItemStack toCheck, boolean ignoreTags);
	
}
