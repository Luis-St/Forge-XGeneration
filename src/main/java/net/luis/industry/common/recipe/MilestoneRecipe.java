package net.luis.industry.common.recipe;

import net.luis.industry.api.recipe.AbstractRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.minecraft.item.ItemStack;

public class MilestoneRecipe extends AbstractRecipe<MilestoneRecipe> {
	
	public MilestoneRecipe(VarArgs<ItemStack> input, VarArgs<ResultItemStack> reslut, int progressTime, int id) {
		super(input, reslut, progressTime, id);
	}
	
	@Override
	public IModRecipeHelper<MilestoneRecipe> getRecipeHelper() {
		return new MilestoneRecipeHelper();
	}
	
	@Override
	public int getMaxInput() {
		return 4;
	}

	@Override
	public int getMaxResult() {
		return 8;
	}

}
