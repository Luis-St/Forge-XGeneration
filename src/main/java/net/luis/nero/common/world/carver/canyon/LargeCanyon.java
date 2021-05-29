package net.luis.nero.common.world.carver.canyon;

import java.util.Random;

public class LargeCanyon extends ModCanyonWorldCarver {
	
	@Override
	public int getRange() {
		return 5;
	}
	
	@Override
	public int calcRange(int range) {
		return (range * 2 - 1) * 16;
	}
	
	@Override
	public int getCanyonLength(Random rng, int range) {
		return range + rng.nextInt(range) - rng.nextInt(range / 8);
	}

	@Override
	public double getCanyonWidth(Random rng, int canyonLength, int canyonMaxLength, float widthMultiplier) {
		double d = canyonLength * Math.PI / canyonMaxLength;
		double e = 2 + Math.sin(d) * widthMultiplier;
		double f = rng.nextFloat() * 0.25D + 0.75D;
		return e * f;
	}
	
	@Override
	public double getCanyonHeight(Random rng, double canyonWidth, double heightMultiplier) {
		double d = canyonWidth * heightMultiplier;
		double e = rng.nextDouble() * 0.25 + 0.75;
		double f = d * e;
		return f - rng.nextDouble();
	}
	
}
