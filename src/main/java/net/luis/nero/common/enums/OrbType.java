package net.luis.nero.common.enums;

import net.luis.nero.api.item.IOrbType;

public enum OrbType implements IOrbType {
	
	APPRENTICE(10000),
	MAGICIAN(25000),
	MASTER(50000),
	MAGICIAN_MASTER(100000);
	
	private final int bloodCapability;
	
	private OrbType(int bloodCapability) {
		this.bloodCapability = bloodCapability;
	}
	
	@Override
	public int getBloodCapability() {
		return this.bloodCapability;
	}

}
