package net.luis.industry.common.recipe.helper;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	@Override
	public void createRecipeList() {
		this.recipes.clear();
		this.registerRecipe(new MilestoneRecipe(this.creatStack(Items.STONE), this.creatResult(Items.COBBLESTONE, 100), 10, 0));
	}

}
