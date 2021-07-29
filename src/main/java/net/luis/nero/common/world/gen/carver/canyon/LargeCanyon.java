package net.luis.nero.common.world.gen.carver.canyon;

import java.util.Random;

import net.luis.nero.api.common.world.gen.carver.ModCanyonWorldCarver;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;

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
	public int getCanyonLength(CanyonCarverConfiguration canyonConfig, Random rng, int range) {
		return range - rng.nextInt(range / 8);
	}

	@Override
	public double getCanyonWidth(CanyonCarverConfiguration canyonConfig, Random rng, int length, int maxLength, float thickness) {
		return super.getCanyonWidth(canyonConfig, rng, length, maxLength, thickness) + rng.nextDouble();
	}
	
	@Override
	public double getCanyonHeight(CanyonCarverConfiguration canyonConfig, Random rng, double width, double yScale) {
		return super.getCanyonHeight(canyonConfig, rng, width - rng.nextDouble(), yScale);
	}
	
	// TODO: add on compile
/*	@Override
	public boolean isStartChunk(CanyonCarverConfiguration config, Random rng) {
		return super.isStartChunk(config, rng) && rng.nextInt(4) == 0;
	}*/
	
}
