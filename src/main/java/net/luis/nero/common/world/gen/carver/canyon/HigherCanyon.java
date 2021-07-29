package net.luis.nero.common.world.gen.carver.canyon;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.luis.nero.api.common.world.gen.carver.ModCanyonWorldCarver;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class HigherCanyon extends ModCanyonWorldCarver {
	
	@Override
	public int getCanyonY(CarvingContext context, Random rng) {
		return Mth.nextInt(rng, 128 - rng.nextInt(16), 128 + rng.nextInt(16));
	}
	
	// TODO: add on compile
//	@Override
//	public boolean isStartChunk(CanyonCarverConfiguration config, Random rng) {
//		return super.isStartChunk(config, rng) /*&& rng.nextInt(4) == 0*/;
//	}
	
	public int getUpperCanyonY(CanyonCarverConfiguration canyonConfig, Random rng, double posY, double height) {
		return (int) (posY + height + rng.nextInt((int) (height / 1.5)));
	}
	
	@Override
	protected void doCarve(CarvingContext context, CanyonCarverConfiguration canyonConfig, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, 
			Aquifer aquifer, double posX, double posY, double posZ, float thickness, float multiplier, float verticalRotation, int maxLength, double yScale, BitSet bitSet) {
		Random rng = new Random(seed);
		float[] widthFactors = this.initWidthFactors(context, canyonConfig, rng);
		float[] motionModifiers = new float[] { 0.0F, 0.0F };
		for (int length = 0; length < maxLength; ++length) {
			double width = this.getCanyonWidth(canyonConfig, rng, length, maxLength, thickness);
			double height = this.getCanyonHeight(canyonConfig, rng, width, yScale);
			width = width * (double) canyonConfig.shape.horizontalRadiusFactor.sample(rng);
			height = this.updateVerticalRadius(canyonConfig, rng, height, (float) maxLength, (float) length);
			float verticalModifier = Mth.cos(verticalRotation);
			float horizontalModifier = Mth.sin(verticalRotation);
			posX = this.getNextXPos(rng, posX, multiplier, verticalRotation, verticalModifier);
			posY = this.getNextYPos(rng, posY, multiplier, verticalRotation, horizontalModifier);
			posZ = this.getNextZPos(rng, posZ, multiplier, verticalRotation, verticalModifier);
			verticalRotation *= 0.7F;
			verticalRotation += motionModifiers[1] * 0.05F;
			multiplier += motionModifiers[0] * 0.05F;
			motionModifiers[1] *= 0.8F;
			motionModifiers[0] *= 0.5F;
			motionModifiers[1] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			motionModifiers[0] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (rng.nextInt(4) != 0) {
				if (!canReach(chunkAccess.getPos(), posX, posZ, length, maxLength, thickness)) {
					return;
				}
				WorldCarver.CarveSkipChecker skipChecker = (carvingContext, xOffset, yOffset, zOffset, y) -> {
					return this.shouldSkip(carvingContext, widthFactors, xOffset, yOffset, zOffset, y);
				};
				this.carveEllipsoid(context, canyonConfig, chunkAccess, toBiome, seed, aquifer, posX, posY, posZ, width, height, bitSet, skipChecker);
				this.carveEllipsoid(context, canyonConfig, chunkAccess, toBiome, seed, aquifer, posX, this.getUpperCanyonY(canyonConfig, rng, posY, height), posZ, 
						width, height, bitSet, skipChecker);
			}
		}
	}

}
