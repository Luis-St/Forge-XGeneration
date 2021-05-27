package net.luis.industry.api.item;

import net.minecraft.item.Item;

public class OrbItem extends Item {
	
	private final int bloodCapability;
	
	public OrbItem(Properties properties, int bloodCapability) {
		super(properties);
		this.bloodCapability = bloodCapability;
	}

	public int getBloodCapability() {
		return this.bloodCapability;
	}

}
