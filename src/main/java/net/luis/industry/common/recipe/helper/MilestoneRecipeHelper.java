package net.luis.industry.common.recipe.helper;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {

	// TODO : add recipes
	@Override
	public void createRecipeList() {
		this.recipes.clear();
		this.registerRecipe(new MilestoneRecipe(this.creatStack(Items.STONE), this.creatResult(Items.COBBLESTONE, 100), 10, 0));
		this.registerRecipe(new MilestoneRecipe(this.creatStack(Items.STONE), this.creatStack(Items.REDSTONE), this.creatResult(Items.REDSTONE_ORE, 100), 10, 1));
	}

	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}

}
