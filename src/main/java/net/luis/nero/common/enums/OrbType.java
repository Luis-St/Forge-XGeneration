package net.luis.nero.common.enums;

import net.luis.nero.common.item.IOrbType;

public class OrbType implements IOrbType {
	
	public static final OrbType APPRENTICE = new OrbType(10000);
	public static final OrbType MAGICIAN = new OrbType(25000);
	public static final OrbType MASTER = new OrbType(50000);
	public static final OrbType MAGICIAN_MASTER = new OrbType(100000);
	
	private final int bloodCapacity;
	
	private OrbType(int bloodCapacity) {
		this.bloodCapacity = bloodCapacity;
	}
	
	@Override
	public int getBloodCapacity() {
		return this.bloodCapacity;
	}

}
