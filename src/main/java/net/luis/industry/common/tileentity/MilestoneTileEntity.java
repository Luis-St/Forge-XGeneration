package net.luis.industry.common.tileentity;

import net.luis.industry.api.tileentity.RecipeTileEntity;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.inventory.MilestoneInventory;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.luis.industry.init.block.util.ModTileEntityTypes;

public class MilestoneTileEntity extends RecipeTileEntity<MilestoneRecipe> {

	public MilestoneTileEntity() {
		
		super(ModTileEntityTypes.MILESTONE.get(), ModRecipeType.MILESTONE, new MilestoneRecipeHelper(), new MilestoneInventory(10, 4));
		
	}

}
