package net.luis.nero.common.enums;

import net.luis.nero.api.common.item.IRuneType;
import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;

public class RuneType implements IRuneType {
	
	public static final RuneType RUNE = new RuneType(0, 0);
	public static final RuneType WATER = new RuneType(RuneTypeValues.WATER_RUNE_USE_COST, 0);
	public static final RuneType BRIDGE = new RuneType(RuneTypeValues.BRIDGE_RUNE_USE_COST, 0);
	public static final RuneType WIND = new RuneType(RuneTypeValues.WIND_RUNE_USE_COST, 0);
	public static final RuneType LAVA = new RuneType(RuneTypeValues.LAVA_RUNE_USE_COST, RuneTypeValues.LAVA_RUNE_HIT_COST);
	public static final RuneType DEATH = new RuneType(RuneTypeValues.DEATH_RUNE_USE_COST, RuneTypeValues.DEATH_RUNE_HIT_COST);
	public static final RuneType HASTE = new RuneType(RuneTypeValues.HASTE_RUNE_USE_COST, RuneTypeValues.HASTE_RUNE_HIT_COST);
	public static final RuneType VOID = new RuneType(750, 0); // TODO: ideas? or remove
	public static final RuneType AIR = new RuneType(RuneTypeValues.AIR_RUNE_USE_COST, 0);
	public static final RuneType ICE = new RuneType(0, RuneTypeValues.ICE_RUNE_HIT_COST);
	public static final RuneType WARRIOR = new RuneType(RuneTypeValues.WARRIOR_RUNE_USE_COST, 0);
	public static final RuneType MINING = new RuneType(RuneTypeValues.MINING_RUNE_USE_COST, RuneTypeValues.MINING_RUNE_HIT_COST);
	public static final RuneType SEER = new RuneType(RuneTypeValues.SEER_RUNE_USE_COST, RuneTypeValues.SEER_RUNE_HIT_COST);
	public static final RuneType ELEMENTAL = new RuneType(RuneTypeValues.ELEMENTAL_RUNE_USE_COST, 0);
	public static final RuneType HARVEST = new RuneType(RuneTypeValues.HARVEST_RUNE_USE_COST, RuneTypeValues.HARVEST_RUNE_HIT_COST);
	
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
	
	@Config
	static class RuneTypeValues {
		
		@ConfigValue public static Integer WATER_RUNE_USE_COST = 250;
		@ConfigValue public static Integer BRIDGE_RUNE_USE_COST = 750;
		@ConfigValue public static Integer WIND_RUNE_USE_COST = 550;
		@ConfigValue public static Integer LAVA_RUNE_USE_COST = 250;
		@ConfigValue public static Integer LAVA_RUNE_HIT_COST = 250;
		@ConfigValue public static Integer DEATH_RUNE_USE_COST = 2500;
		@ConfigValue public static Integer DEATH_RUNE_HIT_COST = 1500;
		@ConfigValue public static Integer HASTE_RUNE_USE_COST = 250;
		@ConfigValue public static Integer HASTE_RUNE_HIT_COST = 250;
		@ConfigValue public static Integer AIR_RUNE_USE_COST = 500;
		@ConfigValue public static Integer ICE_RUNE_HIT_COST = 250;
		@ConfigValue public static Integer WARRIOR_RUNE_USE_COST = 500;
		@ConfigValue public static Integer MINING_RUNE_USE_COST = 500;
		@ConfigValue public static Integer MINING_RUNE_HIT_COST = 500;
		@ConfigValue public static Integer SEER_RUNE_USE_COST = 250;
		@ConfigValue public static Integer SEER_RUNE_HIT_COST = 250;
		@ConfigValue public static Integer ELEMENTAL_RUNE_USE_COST = 500;
		@ConfigValue public static Integer HARVEST_RUNE_USE_COST = 250;
		@ConfigValue public static Integer HARVEST_RUNE_HIT_COST = 250;
		
	}
	
}
