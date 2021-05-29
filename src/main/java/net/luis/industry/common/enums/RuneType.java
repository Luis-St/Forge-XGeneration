package net.luis.industry.common.enums;

import net.luis.industry.api.item.IRuneType;

public enum RuneType implements IRuneType {
	
	SLATE(0, 0),
	REINFORCED_SLATE(0, 0),
	INFUSED_SLATE(0, 0),
	DEMON_SLATE(0, 0),
	
	WATER_RUNE(250, 0),
	BRIDGE_RUNE(750, 0),
	WIND_RUNE(500, 0),
	LAVA_RUNE(250, 0),
	DEATH_RUNE(2000, 0),
	GROWTH_RUNE(250, 0),
	HAST_RUNE(250, 0),
	VOID_RUNE(750, 0),
	AIR_RUNE(1000, 0),
	ICE_RUNE(500, 0),
	WARRIOR_RUNE(500, 0),
	MINING_RUNE(500, 0),
	NIGHT_RUNE(250, 0),
	ELEMENTAL_RUNE(750, 0),
	HARVEST_RUNE(250, 0), 
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
