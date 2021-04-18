package net.luis.industry.api.util;

import java.util.Random;

public class Chance {
	
	private final int chance;
	private static final Random RNG = new Random();
	
	public Chance(int chance) {
		this.chance = chance;
	}
	
	public boolean isAlways() {
		return this.isAlwaysTrue() || this.isAlwaysFalse();
	}
	
	public boolean isAlwaysTrue() {
		return chance == 100;
	}
	
	public boolean isAlwaysFalse() {
		return chance == 0;
	}
	
	public boolean getChance() {
		if (this.isAlwaysTrue()) {
			return true;
		} else if (this.isAlwaysFalse()) {
			return false;
		}
		return chance >= RNG.nextInt(101);
	}
	
}
