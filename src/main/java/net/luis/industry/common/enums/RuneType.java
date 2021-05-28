package net.luis.industry.common.enums;

import net.luis.industry.api.item.IRuneType;

public enum RuneType implements IRuneType {
	
	// Default: 50, 100
	
	WATER(50, 0),
	;
	
	private final int useCost;
	private final int hitCost;
	
	private RuneType(int useCost, int hitCost) {
		this.useCost = useCost;
		this.hitCost = hitCost;
	}

	@Override
	public int getUseCost() {
		return this.useCost;
	}

	@Override
	public int getHitCost() {
		return this.hitCost;
	}
	
}
