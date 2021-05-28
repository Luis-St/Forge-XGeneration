package net.luis.industry.common.item;

import net.luis.industry.api.item.IOrbType;
import net.minecraft.item.Item;

public class OrbItem extends Item {
	
	private final IOrbType orbType;
	
	public OrbItem(IOrbType orbType, Properties properties) {
		super(properties);
		this.orbType = orbType;
	}
	
	public IOrbType getOrbType() {
		return this.orbType;
	}

}
