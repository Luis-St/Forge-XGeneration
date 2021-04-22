package net.luis.industry.api.util;

public class Chance {
	
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
		
		return chance >= (int) Math.random() * 100;
		
	}
	
	public boolean equals(Chance chance) {
		return chance.getValue() == this.getValue();
	}
	
}
