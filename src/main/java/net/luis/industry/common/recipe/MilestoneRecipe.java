package net.luis.industry.common.recipe;

import java.util.List;

import net.luis.industry.api.item.ItemStackHolder;
import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.minecraft.item.ItemStack;

public class MilestoneRecipe implements IModRecipe {
	
	private final List<ItemStack> recipeItems;
	private final List<ResultItemStack> reslutItems;
	private final int recipeProgressTime;
	
	public MilestoneRecipe(VarArgs<ItemStack> recipeItems, VarArgs<ResultItemStack> reslutItems, int recipeProgressTime) {
		this.recipeItems = recipeItems.asList();
		this.reslutItems = reslutItems.asList();
		this.recipeProgressTime = recipeProgressTime;
	}

	@Override
	public List<ItemStack> getRecipeItems() {
		return this.recipeItems;
	}

	@Override
	public List<ResultItemStack> getResultItems() {
		return this.reslutItems;
	}
	
	@Override
	public int getRecipeProgressTime() {
		return this.recipeProgressTime;
	}

	@Override
	public boolean allItemsAvailable(List<ItemStack> itemStacks) {
		
		List<ItemStackHolder> stackHolders = ItemStackHolder.fromItemStackList(itemStacks);
		int containedItems = 0;
		
		for (ItemStack itemStack : this.getRecipeItems()) {
			
			ItemStackHolder itemStackHolder = new ItemStackHolder(itemStack);
			
			if (stackHolders.contains(itemStackHolder)) {
				
				containedItems++;
				
			}
			
		}
		
		return containedItems >= this.getRecipeItems().size();
		
	}

}
