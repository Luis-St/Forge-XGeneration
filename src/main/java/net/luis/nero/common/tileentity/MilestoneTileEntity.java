package net.luis.nero.common.tileentity;

import net.luis.nero.api.tileentity.IAnimatedTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;

public class MilestoneTileEntity implements IAnimatedTileEntity, ITickableTileEntity {
	
	private float previousRotation = 0F;
	private float currentRotation = 0F;
	
	@Override
	public float getCurrent() {
		return this.currentRotation;
	}
	
	@Override
	public float getPrevious() {
		return this.previousRotation;
	}
	
	@SuppressWarnings("unused")
	@Override
	public float getVelocity() {
		return (/*this.isProgressing()*/true ? 10F : 0F) / 100;
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
		this.previousRotation = this.currentRotation;
		this.currentRotation = this.getNext();
	}

}
