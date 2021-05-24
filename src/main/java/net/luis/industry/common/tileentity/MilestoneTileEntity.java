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
		super(ModTileEntityTypes.MILESTONE.get(), ModRecipeType.MILESTONE, new MilestoneRecipeHelper(), new RecipeInventory(10));
	}
	
	@Override
	public float getCurrent() {
		return this.currentRotation;
	}
	
	@Override
	public float getPrevious() {
		return this.previousRotation;
	}
	
	@Override
	public float getVelocity() {
		return (this.isProgressing() ? 10F : 0F) / 100;
	}

	@Override
	public float getNext() {
		float newRotation = 0F;
		if (this.currentRotation + this.getVelocity() > 360) {
			newRotation = (this.currentRotation + this.getVelocity()) - 360;
		} else {
			newRotation = this.currentRotation + this.getVelocity();
		}
		return newRotation;
	}
	
	@Override
	public void tick() {
		super.tick();
		this.previousRotation = this.currentRotation;
		this.currentRotation = this.getNext();
	}

}
