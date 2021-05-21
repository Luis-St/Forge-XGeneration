package net.luis.industry.api.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.luis.industry.api.inventory.ItemStackList;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.minecraft.item.ItemStack;

public abstract class AbstractRecipe<T extends IModRecipe> implements IModRecipe {
	
	protected final List<ItemStack> recipeItems;
	protected final List<ResultItemStack> resultItems;
	protected final int progressTime;
	protected final UUID id;
	
	public AbstractRecipe(VarArgs<ItemStack> recipeItems, VarArgs<ResultItemStack> reslutItems, int progressTime, UUID id) {
		this.requireSize(recipeItems, this.getMaxInput());
		this.requireSize(reslutItems, this.getMaxResult());
		this.recipeItems = recipeItems.asList();
		this.resultItems = reslutItems.asList();
		this.progressTime = progressTime;
		this.id = id;
	}
	
	@Override
	public UUID getId() {
		return this.id;
	}
	
	@Override
	public List<ItemStack> getInput() {
		return this.recipeItems;
	}

	@Override
	public List<ResultItemStack> getResultItems() {
		return this.resultItems;
	}

	@Override
	public List<ItemStack> getResult() {
		List<ItemStack> itemsToDrop = new ArrayList<ItemStack>();
		for (ResultItemStack resultItem : this.getResultItems()) {
			if (resultItem.isResult()) {
				itemsToDrop.add(resultItem.getItemStack());
			}
		}
		return itemsToDrop;
	}
	
	@Override
	public int getProgressTime() {
		return this.progressTime;
	}
	
	@Override
	public boolean containsAll(ItemStackList inventory) {
		int containedItems = 0;
		for (ItemStack toCheck : inventory) {
			if (this.containsItemStack(toCheck, false)) {
				containedItems++;
			}
		}
		return containedItems >= this.getInput().size();
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
		return resultStack.equals(toCheck, ignoreTags, true);
	}
	
	@Override
	public boolean equalsId(IModRecipe toCheck) {
		return this.getId() == toCheck.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IModRecipe)) {
			return false;
		} else {
			IModRecipe recipe = (IModRecipe) obj;
			int equalRecipeItems = 0;
			int equalResultItems = 0;
			if (this.recipeItems.size() == recipe.getInput().size() && this.resultItems.size() == recipe.getResultItems().size()) {
				for (int i = 0; i < this.recipeItems.size(); i++) {
					ItemStack thisStack = this.recipeItems.get(i);
					ItemStack milestoneStack = recipe.getInput().get(i);
					if (this.equalsItemStack(thisStack, milestoneStack, false)) {
						equalRecipeItems++;
					}
				}
				for (int i = 0; i < this.resultItems.size(); i++) {
					ResultItemStack thisStack = this.resultItems.get(i);
					ResultItemStack recipeRecultStack = recipe.getResultItems().get(i);
					if (this.equalsResultItemStack(thisStack, recipeRecultStack, false)) {
						equalResultItems++;
					}
				}
			}
			return equalRecipeItems >= this.recipeItems.size() && equalResultItems >= this.resultItems.size();
		}
	}
	
	private final void requireSize(VarArgs<?> toCheck, int size) {
		if (toCheck.size() > size) {
			throw new IllegalArgumentException("The VarArgs<?> is longer than " + size);
		}
	}
	
}
