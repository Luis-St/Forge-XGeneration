package net.luis.industry.common.tileentity;

import net.luis.industry.api.tileentity.AbstractRecipeTileEntity;
import net.luis.industry.api.tileentity.IMechanicalTileEntity;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.inventory.RecipeInventory;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.luis.industry.init.block.util.ModTileEntityTypes;

public class MilestoneTileEntity extends AbstractRecipeTileEntity<MilestoneRecipe> implements IMechanicalTileEntity {
	
	private float currentSpeed = 0F;
	private float previousSpeed = 0F;
	
	public MilestoneTileEntity() {
		super(ModTileEntityTypes.MILESTONE.get(), ModRecipeType.MILESTONE, new MilestoneRecipeHelper(), new RecipeInventory(10, 4));
	}
	
	@Override
	public float getCurrent() {
		return this.currentSpeed;
	}

	@Override
	public float getPrevious() {
		return this.previousSpeed;
	}

	@Override
	public float calc() {
		return this.isProgressing() ? 10F : 0F;
	}
	
	@Override
	public void tick() {
		super.tick();
		this.previousSpeed = this.currentSpeed;
		this.currentSpeed = this.calc();
	}
	
	@Override
	public double getViewDistance() {
		return 512D;
	}

}
