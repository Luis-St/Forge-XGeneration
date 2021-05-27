package net.luis.industry.common.enums;

import net.luis.industry.api.item.IRuneType;

public enum RuneType implements IRuneType {
	
	// Default: 50
	
	WATER(50),
	;
	
	private final int bloodCost;
	
	private RuneType(int bloodCost) {
		this.bloodCost = bloodCost;
	}

	@Override
	public int getBloodCost() {
		return this.bloodCost;
	}
	
	
}
