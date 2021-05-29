package net.luis.nero.common.recipe;

import java.util.UUID;

import net.luis.nero.api.recipe.AbstractRecipe;
import net.luis.nero.api.recipe.IModRecipeHelper;
import net.luis.nero.api.recipe.item.ResultItemStack;
import net.luis.nero.api.util.VarArgs;
import net.luis.nero.common.recipe.helper.MilestoneRecipeHelper;
import net.minecraft.item.ItemStack;

public class MilestoneRecipe extends AbstractRecipe<MilestoneRecipe> {
	
	public MilestoneRecipe(VarArgs<ItemStack> input, VarArgs<ResultItemStack> reslut, int progressTime, UUID id) {
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
		return 10;
	}

}
