package net.luis.industry.api.recipe;

import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.minecraft.item.ItemStack;

public interface IModRecipe {
	
	int getId();
	
	List<ItemStack> getRecipeItems();
	
	List<ResultItemStack> getAllResultItems();
	
	List<ItemStack> getResultItems();
	
	int getRecipeItemMaxCount();
	
	int getResultItemMaxCount();
	
	int getRecipeProgressTime();
	
	boolean canDrop(ItemStackList inventory);
	
	boolean containsItemStack(ItemStack toCheck, boolean ignoreTags);
	
	boolean equalsId(IModRecipe toCheck);
	
	boolean equalsId(int id);
	
	boolean equalsItemStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags);
	
	boolean equalsResultItemStack(ResultItemStack resultStack, ResultItemStack toCheck, boolean ignoreTags);
	
}
