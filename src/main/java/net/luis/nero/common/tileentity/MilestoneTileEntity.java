package net.luis.nero.common.tileentity;

import net.luis.nero.api.tileentity.AbstractRecipeTileEntity;
import net.luis.nero.api.tileentity.IAnimatedTileEntity;
import net.luis.nero.common.enums.ModRecipeType;
import net.luis.nero.common.inventory.RecipeInventory;
import net.luis.nero.common.recipe.MilestoneRecipe;
import net.luis.nero.common.recipe.helper.MilestoneRecipeHelper;
import net.luis.nero.init.block.util.ModTileEntityTypes;

public class MilestoneTileEntity extends AbstractRecipeTileEntity<MilestoneRecipe> implements IAnimatedTileEntity {
	
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
