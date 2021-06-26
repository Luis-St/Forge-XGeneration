package net.luis.nero.common.enums;

import net.luis.nero.api.common.item.IOrbType;

public class OrbType implements IOrbType {
	
	// TODO: use config values here
	
	public static final OrbType APPRENTICE = new OrbType(10000);
	public static final OrbType MAGICIAN = new OrbType(25000);
	public static final OrbType MASTER = new OrbType(50000);
	public static final OrbType MAGICIAN_MASTER = new OrbType(100000);
	
	private final int bloodCapability;
	
	private OrbType(int bloodCapability) {
		this.bloodCapability = bloodCapability;
	}
	
	@Override
	public int getBloodCapability() {
		return this.bloodCapability;
	}

}
