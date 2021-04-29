package net.luis.industry.common.recipe.helper;

import java.util.UUID;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	@Override
	public void createRecipeList() {
		super.createRecipeList();
		this.registerRecipe(this.creatStoneRecipe(20, UUID.fromString("f9e17662-bdb7-4735-8e9a-ca256b60b0ac")));
	}

	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}
	
	protected MilestoneRecipe creatStoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.STONE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.COAL, 50));
		result.add(new ResultItemStack(Items.IRON_ORE, 40));
		result.add(new ResultItemStack(Items.GOLD_ORE, 30));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 20));
		result.add(new ResultItemStack(Items.REDSTONE, 2, 3, 15));
		result.add(new ResultItemStack(Items.DIAMOND, 5));
		result.add(new ResultItemStack(Items.EMERALD, 2));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
}
