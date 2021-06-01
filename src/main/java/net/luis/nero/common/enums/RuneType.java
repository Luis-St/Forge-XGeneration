package net.luis.nero.common.enums;

import net.luis.nero.api.item.IRuneType;

public enum RuneType implements IRuneType {
	
	RUNE(0, 0),
	WATER(250, 0),
	BRIDGEE(750, 0),
	WIND(500, 0),
	LAVA(250, 0),
	DEATH(2000, 0),
	GROWTHE(250, 0),
	HAST(250, 0),
	VOID(750, 0),
	AIR(500, 0),
	ICE(500, 0),
	WARRIOR(500, 0),
	MINING(500, 0),
	NIGHT(250, 0),
	ELEMENTAL(750, 0),
	HARVEST(250, 0), 
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
