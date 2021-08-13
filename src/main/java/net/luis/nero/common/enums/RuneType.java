package net.luis.nero.common.enums;

import net.luis.nero.api.common.item.IRuneType;

public class RuneType implements IRuneType {
	
	public static final RuneType RUNE = new RuneType(0, 0);
	public static final RuneType WATER = new RuneType(250, 0);
	public static final RuneType BRIDGE = new RuneType(750, 0);
	public static final RuneType WIND = new RuneType(550, 0);
	public static final RuneType LAVA = new RuneType(250, 250);
	public static final RuneType DEATH = new RuneType(2500, 1500);
	public static final RuneType HASTE = new RuneType(250, 250);
	public static final RuneType AIR = new RuneType(500, 0);
	public static final RuneType ICE = new RuneType(0, 250);
	public static final RuneType WARRIOR = new RuneType(500, 0);
	public static final RuneType MINING = new RuneType(500, 500);
	public static final RuneType SEER = new RuneType(250, 250);
	public static final RuneType ELEMENTAL = new RuneType(500, 0);
	public static final RuneType HARVEST = new RuneType(250, 250);
	
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
