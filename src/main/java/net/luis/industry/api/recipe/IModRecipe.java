package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.ItemStack;

public interface IModRecipe {
	
	int getId();
	
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
	
	boolean equalsId(int id);
	
	boolean equalsItemStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags);
	
	boolean equalsResultItemStack(ResultItemStack resultStack, ResultItemStack toCheck, boolean ignoreTags);
	
}
