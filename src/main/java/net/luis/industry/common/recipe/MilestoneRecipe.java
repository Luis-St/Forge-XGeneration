package net.luis.industry.common.recipe;

import java.util.ArrayList;
import java.util.List;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.minecraft.item.ItemStack;

public class MilestoneRecipe implements IModRecipe {

	private final List<ItemStack> recipeItems;
	private final List<ResultItemStack> resultItems;
	private final int progressTime;
	private final int id;
	private final IModRecipeHelper<MilestoneRecipe> recipeHelper;

	public MilestoneRecipe(ItemStack firstInput, ResultItemStack firstResult, int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput), new VarArgs<ResultItemStack>(firstResult), progressTime, id);
	}

	public MilestoneRecipe(ItemStack firstInput, ItemStack secondInput, ResultItemStack firstResult,int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput, secondInput), new VarArgs<ResultItemStack>(firstResult), progressTime, id);
	}

	public MilestoneRecipe(ItemStack firstInput, ItemStack secondInput, ItemStack thirdInput,ResultItemStack firstResult, int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput, secondInput, thirdInput), new VarArgs<ResultItemStack>(firstResult), progressTime, id);
	}

	public MilestoneRecipe(ItemStack firstInput, ResultItemStack firstResult, ResultItemStack secondResult,int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput), new VarArgs<ResultItemStack>(firstResult, secondResult), progressTime, id);
	}

	public MilestoneRecipe(ItemStack firstInput, ResultItemStack firstResult, ResultItemStack secondResult,ResultItemStack thirdResult, int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput), new VarArgs<ResultItemStack>(firstResult, secondResult, thirdResult), progressTime, id);
	}

	public MilestoneRecipe(ItemStack firstInput, ItemStack secondInput, ResultItemStack firstResult,ResultItemStack secondResult, int progressTime, int id) {
		this(new VarArgs<ItemStack>(firstInput, secondInput), new VarArgs<ResultItemStack>(firstResult, secondResult), progressTime, id);
	}

	protected MilestoneRecipe(VarArgs<ItemStack> recipeItems, VarArgs<ResultItemStack> reslutItems, int progressTime, int id) {
		this.requireSize(recipeItems, this.getRecipeItemMaxCount());
		this.requireSize(reslutItems, this.getResultItemMaxCount());
		this.recipeItems = recipeItems.asList();
		this.resultItems = reslutItems.asList();
		this.progressTime = progressTime;
		this.id = id;
		this.recipeHelper = new MilestoneRecipeHelper();
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public IModRecipeHelper<MilestoneRecipe> getRecipeHelper() {
		return this.recipeHelper;
	}
	
	@Override
	public List<ItemStack> getRecipeItems() {
		return this.recipeItems;
	}

	@Override
	public List<ResultItemStack> getAllResultItems() {
		return this.resultItems;
	}

	@Override
	public List<ItemStack> getResultItems() {

		List<ItemStack> itemsToDrop = new ArrayList<ItemStack>();

		for (ResultItemStack resultItem : this.getAllResultItems()) {

			if (resultItem.isResult()) {

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
	public int getProgressTime() {
		return this.progressTime;
	}
	
	@Override
	public boolean canDrop(ItemStackList inventory) {
		
		int containedItems = 0;
		
		for (ItemStack toCheck : inventory) {
			
			if (this.containsItemStack(toCheck, false)) {
				
				containedItems++;
				
			}
			
		}
		
		return containedItems >= this.getRecipeItems().size();
	}

	@Override
	public boolean containsItemStack(ItemStack toCheck, boolean ignoreTags) {
		
		for (ItemStack itemStack : this.recipeItems) {
			
			if (this.equalsItemStack(itemStack, toCheck, ignoreTags)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	@Override
	public boolean equalsItemStack(ItemStack itemStack, ItemStack toCheck, boolean ignoreTags) {
		
		if (itemStack.getItem() == toCheck.getItem()) {
			
			return toCheck.getCount() >= itemStack.getCount() || ignoreTags;
			
		}
		
		return false;
	}

	@Override
	public boolean equalsResultItemStack(ResultItemStack resultStack, ResultItemStack toCheck, boolean ignoreTags) {
		return resultStack.equals(resultStack, ignoreTags, true);
	}
	
	@Override
	public boolean equalsId(IModRecipe toCheck) {
		return this.equalsId(toCheck.getId());
	}

	@Override
	public boolean equalsId(int id) {
		return this.getId() == id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof MilestoneRecipe)) {
			return false;
		} else {
			
			MilestoneRecipe milestoneRecipe = (MilestoneRecipe) obj;
			int equalRecipeItems = 0;
			int equalResultItems = 0;
			
			if (this.recipeItems.size() == milestoneRecipe.recipeItems.size() && this.resultItems.size() == milestoneRecipe.resultItems.size()) {
				
				for (int i = 0; i < this.recipeItems.size(); i++) {
					
					ItemStack thisStack = this.recipeItems.get(i);
					
					ItemStack milestoneStack = milestoneRecipe.recipeItems.get(i);
					if (this.equalsItemStack(thisStack, milestoneStack, false)) {
						equalRecipeItems++;
					}
					
				}
				
				for (int i = 0; i < this.resultItems.size(); i++) {
					
					ResultItemStack thisStack = this.resultItems.get(i);
					ResultItemStack milestoneStack = milestoneRecipe.resultItems.get(i);
					
					if (this.equalsResultItemStack(thisStack, milestoneStack, false)) {
						equalResultItems++;
					}
					
				}
				
			}
			
			return equalRecipeItems >= this.recipeItems.size() && equalResultItems >= this.resultItems.size();
			
		}
		
	}
	
	private final <T> void requireSize(VarArgs<T> toCheck, int size) {

		if (toCheck.size() > size) {

			throw new IllegalArgumentException("The VarArgs<?> is longer than " + size);

		}

	}

}
