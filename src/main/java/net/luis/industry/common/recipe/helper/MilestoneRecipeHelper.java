package net.luis.industry.common.recipe.helper;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

// TODO : id (int) -> id (uuid|String) && min/max ResultItemStack -> every get new calc
public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	@Override
	public void createRecipeList() {
		super.createRecipeList();
		this.registerRecipe(this.creatStoneRecipe(20, 0));
	}

	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}
	
	protected MilestoneRecipe creatStoneRecipe(int progressTime, int id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.STONE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.COAL, 80));
		result.add(new ResultItemStack(Items.IRON_ORE, 50));
		result.add(new ResultItemStack(Items.GOLD_ORE, 30));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 30));
		result.add(new ResultItemStack(Items.REDSTONE, 2, 3, 10));
		result.add(new ResultItemStack(Items.DIAMOND, 5));
		result.add(new ResultItemStack(Items.EMERALD, 2));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
}
