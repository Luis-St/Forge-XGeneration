package net.luis.industry.common.recipe;

import java.util.ArrayList;
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
		this.requireSize(recipeItems, this.getRecipeItemMaxCount());
		this.requireSize(reslutItems, this.getResultItemMaxCount());
		this.recipeItems = recipeItems.asList();
		this.reslutItems = reslutItems.asList();
		this.recipeProgressTime = recipeProgressTime;
	}	

	@Override
	public List<ItemStack> getRecipeItems() {
		return this.recipeItems;
	}

	@Override
	public List<ResultItemStack> getAllResultItems() {
		return this.reslutItems;
	}
	
	@Override
	public List<ItemStack> getResultItemsWithChance() {
		
		List<ItemStack> itemsToDrop = new ArrayList<ItemStack>();
		
		for (ResultItemStack resultItem : this.getAllResultItems()) {
			
			if (resultItem.getChance()) {
				
				itemsToDrop.add(resultItem.getItemStack());
				
			}
			
		}
		
		return itemsToDrop;
		
	}
	
	@Override
	public int getRecipeItemMaxCount() {
		return 10;
	}

	@Override
	public int getResultItemMaxCount() {
		return 4;
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
	
	private final <T> void requireSize(VarArgs<T> toCheck, int size) {
		if (toCheck.size() > size) {
			throw new IllegalArgumentException("The VarArgs<?> is longer than " + size);
		}
	}

}
