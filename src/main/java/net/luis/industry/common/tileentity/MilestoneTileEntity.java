package net.luis.industry.common.tileentity;

import net.luis.industry.api.tileentity.AbstractRecipeTileEntity;
import net.luis.industry.api.tileentity.IMechanicalTileEntity;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.inventory.RecipeInventory;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;
import net.luis.industry.init.block.util.ModTileEntityTypes;

public class MilestoneTileEntity extends AbstractRecipeTileEntity<MilestoneRecipe> implements IMechanicalTileEntity {
	
	private float previousRotation = 0F;
	private float currentRotation = 0F;
	
	public MilestoneTileEntity() {
		super(ModTileEntityTypes.MILESTONE.get(), ModRecipeType.MILESTONE, new MilestoneRecipeHelper(), new RecipeInventory(10, 4));
	}
	
	public float getCurrentRotation() {
		return this.currentRotation;
	}
	
	public float getPreviousRotation() {
		return this.previousRotation;
	}
	
	@Override
	public float getSpeed() {
		return (this.isProgressing() ? 10F : 0F) / 100;
	}

	@Override
	public float calc() {
		float newRotation = 0F;
		if (this.currentRotation + this.getSpeed() > 360) {
			newRotation = (this.currentRotation + this.getSpeed()) - 360;
		} else {
			newRotation = this.currentRotation + this.getSpeed();
		}
		return newRotation;
	}
	
	@Override
	public void tick() {
		super.tick();
		this.previousRotation = this.currentRotation;
		this.currentRotation = this.calc();
	}
	
	@Override
	public double getViewDistance() {
		return 512D;
	}

}
