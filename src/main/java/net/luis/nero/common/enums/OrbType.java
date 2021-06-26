package net.luis.nero.common.enums;

import net.luis.nero.api.common.item.IOrbType;
import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;

public class OrbType implements IOrbType {
	
	public static final OrbType APPRENTICE = new OrbType(OrbTypeValues.APPRENTICE_ORB_BLOOD_CAPACITY);
	public static final OrbType MAGICIAN = new OrbType(OrbTypeValues.MAGICIAN_ORB_BLOOD_CAPACITY);
	public static final OrbType MASTER = new OrbType(OrbTypeValues.MASTER_ORB_BLOOD_CAPACITY);
	public static final OrbType MAGICIAN_MASTER = new OrbType(OrbTypeValues.MAGICIAN_MASTER_BLOOD_CAPACITY);
	
	private final int bloodCapacity;
	
	private OrbType(int bloodCapacity) {
		this.bloodCapacity = bloodCapacity;
	}
	
	@Override
	public int getBloodCapacity() {
		return this.bloodCapacity;
	}
	
	@Config
	static class OrbTypeValues {
		
		@ConfigValue
		public static Integer APPRENTICE_ORB_BLOOD_CAPACITY = 10000;
		@ConfigValue
		public static Integer MAGICIAN_ORB_BLOOD_CAPACITY = 25000;
		@ConfigValue
		public static Integer MASTER_ORB_BLOOD_CAPACITY = 50000;
		@ConfigValue
		public static Integer MAGICIAN_MASTER_BLOOD_CAPACITY = 100000;
		
	}

}
