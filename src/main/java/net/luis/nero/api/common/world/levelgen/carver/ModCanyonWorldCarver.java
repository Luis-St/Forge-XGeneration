package net.luis.nero.api.common.world.levelgen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.luis.nero.api.common.world.levelgen.carver.config.ModCanyonCarverConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class ModCanyonWorldCarver extends ModWorldCarver<ModCanyonCarverConfiguration> {

	public ModCanyonWorldCarver(Codec<ModCanyonCarverConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean isStartChunk(ModCanyonCarverConfiguration config, Random rng) {
		return rng.nextFloat() <= config.probability;
	}

	@Override
	public boolean carve(CarvingContext context, ModCanyonCarverConfiguration config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, Random rng, Aquifer aquifer, ChunkPos chunkPos, BitSet bitSet) {
		int range = (config.range * 2 - 1) * 16;
		double posX = chunkPos.getBlockX(rng.nextInt(16));
		double posY = config.y.sample(rng, context);
		double posZ = chunkPos.getBlockZ(rng.nextInt(16));
		float motionHorizontal = rng.nextFloat() * ((float) Math.PI * 2F);
		float verticalRotation = config.verticalRotation.sample(rng);
		double yScale = config.yScale.sample(rng);
		float thickness = config.shape.thickness.sample(rng);
		int length = (int) (range * config.shape.distanceFactor.sample(rng));
		this.doCarve(context, config, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, thickness, motionHorizontal, verticalRotation, 0, length, yScale, bitSet);
		return true;
	}

	protected void doCarve(CarvingContext context, ModCanyonCarverConfiguration config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, Aquifer aquifer, double posX, double posY, double posZ, float thickness, 
			float motionHorizontal, float verticalRotation, int startGen, int length, double yScale, BitSet bitSet) {
		Random rng = new Random(seed);
		float[] widthFactors = this.initWidthFactors(context, config, rng);
		float f = 0.0F;
		float g = 0.0F;
		for (int i = startGen; i < length; ++i) {
			double width = 1.5D + (Mth.sin((float) i * (float) Math.PI / (float) length) * thickness);
			double height = width * yScale;
			width *= config.shape.horizontalFactor.sample(rng);
			height = this.updateVerticalRadius(config, rng, height, (float) length, (float) i);
			float h = Mth.cos(verticalRotation);
			float j = Mth.sin(verticalRotation);
			posX += Mth.cos(motionHorizontal) * h;
			posY += j;
			posZ += Mth.sin(motionHorizontal) * h;
			verticalRotation *= 0.7F;
			verticalRotation += g * 0.05F;
			motionHorizontal += f * 0.05F;
			g *= 0.8F;
			f *= 0.5F;
			g += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			f += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (rng.nextInt(4) != 0) {
				if (!canReach(chunkAccess.getPos(), posX, posZ, i, length, thickness)) {
					return;
				}
				WorldCarver.CarveSkipChecker skipChecker = (carvingContext, xOffset, yOffset, zOffset, y) -> {
					return this.shouldSkip(carvingContext, widthFactors, xOffset, yOffset, zOffset, y);
				};
				this.carveEllipsoid(context, config, chunkAccess, toBiome, seed, aquifer, posX, posY, posZ, width, height, bitSet, skipChecker);
			}
		}

	}

	protected float[] initWidthFactors(CarvingContext context, ModCanyonCarverConfiguration config, Random rng) {
		float[] widthFactors = new float[context.getGenDepth()];
		float f = 1.0F;
		for (int j = 0; j < context.getGenDepth(); ++j) {
			if (j == 0 || rng.nextInt(config.shape.widthSmoothness) == 0) {
				f = 1.0F + rng.nextFloat() * rng.nextFloat();
			}
			widthFactors[j] = f * f;
		}
		return widthFactors;
	}

	protected double updateVerticalRadius(ModCanyonCarverConfiguration config, Random rng, double height, float p_159029_, float p_159030_) {
		float f = 1.0F - Mth.abs(0.5F - p_159030_ / p_159029_) * 2.0F;
		float f1 = config.shape.verticalDefaultFactor + config.shape.verticalCenterFactor * f;
		return (double) f1 * height * (double) Mth.randomBetween(rng, 0.75F, 1.0F);
	}

	protected boolean shouldSkip(CarvingContext context, float[] widthFactors, double xOffset, double yOffset, double zOffset, int yIn) {
		int y = yIn - context.getMinGenY();
		return (xOffset * xOffset + zOffset * zOffset) * (double) widthFactors[y - 1] + yOffset * yOffset / 6.0D >= 1.0D;
	}

}
