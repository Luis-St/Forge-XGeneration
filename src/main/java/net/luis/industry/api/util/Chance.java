package net.luis.industry.api.util;

import java.util.Random;

public class Chance {
	
	private final int chance;
	
	public static final Chance DUMMY = new Chance(-1);
	
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
		return chance >= 100;
	}
	
	public boolean isAlwaysFalse() {
		return chance == 0;
	}
	
	protected final boolean isDummy() {
		return this.chance == -1;
	}
	
	public boolean getChance() {
		if (this.isAlwaysTrue()) {
			return true;
		} else if (this.isAlwaysFalse()) {
			return false;
		} else if (this.isDummy()) {
			return false;
		}
		return chance >= new Random().nextInt(100);
	}
	
	public boolean equals(Chance chance) {
		return chance.getValue() == this.getValue();
	}
	
}
