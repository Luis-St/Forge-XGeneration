package net.luis.nero.common.enums;

import net.luis.nero.api.common.item.IOrbType;

public enum OrbType implements IOrbType {
	
	// TODO: test if possible to use config values here
	
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
