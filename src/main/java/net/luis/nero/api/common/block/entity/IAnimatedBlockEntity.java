package net.luis.nero.api.common.block.entity;

public interface IAnimatedBlockEntity {
	
	float getCurrent();
	
	float getPrevious();
	
	default float getVelocity() {
		return 0.0F;
	}
	
	default float getNext() {
		return 0.0F;
	}
	
}
