package net.luis.nero.common.enums;

import net.luis.nero.api.item.IRuneType;

public enum RuneType implements IRuneType {
	
	RUNE(0, 0),
	WATER(250, 0),
	// TODO: test and/or modify
	BRIDGE(750, 0),
	WIND(500, 0),
	LAVA(250, 250),
	DEATH(2500, 1000),
	HASTE(250, 250),
	// TODO: test and/or modify
	VOID(750, 0),
	AIR(500, 0),
	ICE(0, 250),
	WARRIOR(500, 0),
	MINING(500, 500),
	SEER(250, 250),
	ELEMENTAL(500, 0),
	HARVEST(250, 250);
	
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
