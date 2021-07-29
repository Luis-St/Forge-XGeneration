package net.luis.nero.api.common.util;

import java.util.Random;

public class Chance {
	
	public static final Chance NULL = new Chance(-1);
	
	private static final Random RNG = new Random();
	private final int chance;
	

	
	public Chance(int chance) {
		this.chance = chance;
	}
	
	public int getValue() {
		return this.chance;
	}
	
	public boolean isAlways() {
		return this.isAlwaysTrue() || this.isAlwaysFalse();
	}
	
	public boolean isAlwaysTrue() {
		return this.chance >= 100;
	}
	
	public boolean isAlwaysFalse() {
		return this.chance == 0;
	}
	
	protected final boolean isNull() {
		return this.chance == -1;
	}
	
	public boolean getChance() {
		if (this.isAlwaysTrue()) {
			return true;
		} else if (this.isAlwaysFalse()) {
			return false;
		} else if (this.isNull()) {
			return false;
		}
		return this.chance >= RNG.nextInt(100);
	}
	
	public boolean equals(Chance chance) {
		return chance.getValue() == this.getValue();
	}
	
	public static void setSeed(long seed) {
		RNG.setSeed(seed);
	}
	
}
