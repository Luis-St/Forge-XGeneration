package net.luis.nero.common.world.gen.carver.canyon;

import java.util.Random;

import net.minecraft.world.gen.feature.ProbabilityConfig;

public class LargeCanyon extends ModCanyonWorldCarver {
	
	@Override
	public int getRange() {
		return 4;
	}
	
	@Override
	public int calcRange(int range) {
		return (range * 2) * 18;
	}
	
	@Override
	public int getCanyonLength(Random rng, int range) {
		return range - rng.nextInt(range / 8);
	}

	@Override
	public double getCanyonWidth(Random rng, int canyonLength, int canyonMaxLength, float widthMultiplier) {
		return super.getCanyonWidth(rng, canyonLength, canyonMaxLength, widthMultiplier) + rng.nextDouble();
	}
	
	@Override
	public double getCanyonHeight(Random rng, double canyonWidth, double heightMultiplier) {
		return super.getCanyonHeight(rng, canyonWidth - rng.nextDouble(), heightMultiplier);
	}
	
	@Override
	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return super.isStartChunk(rng, chunkX, chunkZ, config) && rng.nextInt(4) == 0;
	}
	
}
