package net.luis.industry.api.tileentity;

public interface IAnimatedTileEntity {
	
	float getCurrent();
	
	float getPrevious();
	
	default float getVelocity() {
		return 0.0F;
	}
	
	default float getNext() {
		return 0.0F;
	}
	
}
