package net.luis.industry.common.recipe;

import net.luis.industry.api.recipe.AbstractRecipe;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.minecraft.item.ItemStack;

public class MilestoneRecipe extends AbstractRecipe<MilestoneRecipe> {
	
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
		super(recipeItems, reslutItems, progressTime, new MilestoneRecipeHelper(), id);
	}

	@Override
	public int getMaxInput() {
		return 10;
	}

	@Override
	public int getMaxResult() {
		return 4;
	}
	
}
