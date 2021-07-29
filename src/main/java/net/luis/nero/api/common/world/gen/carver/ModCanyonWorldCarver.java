package net.luis.nero.api.common.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class ModCanyonWorldCarver extends ModWorldCarver<CanyonCarverConfiguration> {
	
	public ModCanyonWorldCarver() {
		super(CanyonCarverConfiguration.CODEC);
	}
	
	public int getCanyonYMin(CarvingContext context) {
		return 25;
	}
	
	public int getCanyonYMax(CarvingContext context) {
		return 200;
	}
	
	public int getCanyonY(CarvingContext context, Random rng) {
		return Mth.nextInt(rng, this.getCanyonYMin(context), this.getCanyonYMax(context));
	}
	
	@Override
	public int getRange() {
		return 4;
	}
	
	public int calcRange(int range) {
		return (range * 2 - 1) * 16;
	}
	
	public int getCanyonLength(CanyonCarverConfiguration canyonConfig, Random rng, int range) {
		return range - rng.nextInt(range / 4);
	}
	
	public double getCanyonWidth(CanyonCarverConfiguration canyonConfig, Random rng, int length, int maxLength, float thickness) {
		double d = length * Math.PI / maxLength;
		double e = 1.5D + Math.sin(d) * thickness;
		double f = rng.nextFloat() * 0.25D + 0.75D;
		return e * f;
	}
	
	public double getCanyonHeight(CanyonCarverConfiguration canyonConfig, Random rng, double width, double yScale) {
		double d = width * yScale;
		double e = rng.nextFloat() * 0.25 + 0.75;
		return d * e;
	}
	
	public double getNextXPos(Random rng, double oldPosX, float multiplier, float verticalRotation, float verticalModifier) {
		return oldPosX + (Math.cos(multiplier) * verticalModifier);
	}
	
	public double getNextYPos(Random rng, double oldPosY, float multiplier, float verticalRotation, float horizontalModifier) {
		return oldPosY + horizontalModifier;
	}
	
	public double getNextZPos(Random rng, double oldPosZ, float multiplier, float verticalRotation, float verticalModifier) {
		return oldPosZ + (Math.sin(multiplier) * verticalModifier);
	}
	
	@Override
	public boolean carve(CarvingContext context, CanyonCarverConfiguration canyonConfig, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, Random rng,
			Aquifer aquifer, ChunkPos chunkPos, BitSet bitSet) {
		int range = this.calcRange(this.getRange());
		double posX = (double) chunkPos.getBlockX(rng.nextInt(16));
		int posY = this.getCanyonY(context, rng);
		double posZ = (double) chunkPos.getBlockZ(rng.nextInt(16));
		float multiplier = rng.nextFloat() * ((float) Math.PI * 2F);
		float verticalRotation = canyonConfig.verticalRotation.sample(rng);
		double yScale = (double) canyonConfig.yScale.sample(rng); 
		float thickness = canyonConfig.shape.thickness.sample(rng);
		int length = this.getCanyonLength(canyonConfig, rng, range);
		this.doCarve(context, canyonConfig, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, (double) posY, posZ, thickness, multiplier, verticalRotation, length, yScale, bitSet);
		return true;
	}

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
			}
		}
	}
	
	protected float[] initWidthFactors(CarvingContext context, CanyonCarverConfiguration canyonConfig, Random rng) {
		int genDepth = context.getGenDepth();
		float[] widthFactors = new float[genDepth];
		float widthFactor = 1.0F;
		for (int j = 0; j < genDepth; ++j) {
			if (j == 0 || rng.nextInt(canyonConfig.shape.widthSmoothness) == 0) {
				widthFactor = 1.0F + rng.nextFloat() * rng.nextFloat();
			}
			widthFactors[j] = widthFactor * widthFactor;
		}
		return widthFactors;
	}

	protected double updateVerticalRadius(CanyonCarverConfiguration canyonConfig, Random rng, double height, float maxLength, float length) {
		float lengthScale = 1.0F - Mth.abs(0.5F - length / maxLength) * 2.0F;
		float verticalRadius = canyonConfig.shape.verticalRadiusDefaultFactor + canyonConfig.shape.verticalRadiusCenterFactor * lengthScale;
		return verticalRadius * height * Mth.randomBetween(rng, 0.75F, 1.0F);
	}

	protected boolean shouldSkip(CarvingContext context, float[] widthFactors, double xOffset, double yOffset, double zOffset, int y) {
		int genY = y - context.getMinGenY();
		return (xOffset * xOffset + zOffset * zOffset) * (double) widthFactors[genY - 1] + yOffset * yOffset / 6.0D >= 1.0D;
	}
	
}
