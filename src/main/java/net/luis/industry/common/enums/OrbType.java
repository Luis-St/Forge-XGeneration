package net.luis.industry.common.enums;

import net.luis.industry.api.item.IOrbType;

public enum OrbType implements IOrbType {
	
	APPRENTICE(10000),
	MAGICIAN(25000),
	MASTER(50000);
	
	private final int bloodCapability;
	
	private OrbType(int bloodCapability) {
		this.bloodCapability = bloodCapability;
	}
	
	@Override
	public int getBloodCapability() {
		return this.bloodCapability;
	}

}
