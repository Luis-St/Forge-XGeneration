package net.luis.nero.common.world.gen.carver.canyon;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.luis.nero.api.common.world.gen.carver.ModCanyonWorldCarver;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class HigherCanyon extends ModCanyonWorldCarver {
	
	@Override
	public int getCanyonY(Random rng) {
		return MathHelper.nextInt(rng, 128 - rng.nextInt(16), 128 + rng.nextInt(16));
	}
	
	@Override
	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return super.isStartChunk(rng, chunkX, chunkZ, config) /*&& rng.nextInt(4) == 0*/;
	}
	
	public int getUpperCanyonY(Random rng, int canyonY, double canyonHeight) {
		return (int) (canyonY + canyonHeight + rng.nextInt((int) (canyonHeight / 1.5)));
	}
	
	@Override
	protected void genCanyon(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, double posX, double posY, 
			double posZ, float widthMultiplier, float axisMultiplier0, float axisMultiplier1, int canyonMaxLength, double heightMultiplier, BitSet bitSet) {
		Random rng = new Random(seed);
		float f = 1.0F;
		for (int i = 0; i < 256; ++i) {
			if (i == 0 || rng.nextInt(3) == 0) {
				f = 1.0F + rng.nextFloat() * rng.nextFloat();
			}
			this.rs[i] = f * f;
		}
		float[] motionModifiers = new float[4];
		motionModifiers[0] = 0.0F;
		motionModifiers[1] = 0.0F;		
		for (int canyonLength = 0; canyonLength < canyonMaxLength; ++canyonLength) {
			double canyonWidth = this.getCanyonWidth(rng, canyonLength, canyonMaxLength, widthMultiplier);
			double canyonHeight = this.getCanyonHeight(rng, canyonWidth, heightMultiplier);
			motionModifiers[2] = MathHelper.cos(axisMultiplier1);
			motionModifiers[3] = MathHelper.sin(axisMultiplier1);
			posX = this.getNextXPos(rng, posX, axisMultiplier0, axisMultiplier1, motionModifiers);
			posY = this.getNextYPos(rng, posY, axisMultiplier0, axisMultiplier1, motionModifiers);
			posZ = this.getNextZPos(rng, posZ, axisMultiplier0, axisMultiplier1, motionModifiers);
			axisMultiplier0 += motionModifiers[0] * 0.05F;
			motionModifiers[1] *= 0.8F;
			motionModifiers[0] *= 0.5F;
			motionModifiers[1] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			motionModifiers[0] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (rng.nextInt(4) != 0) {
				if (!this.canReach(chunkX, chunkZ, posX, posZ, canyonLength, canyonMaxLength, widthMultiplier)) {
					return;
				}
				this.carveSphere(chunk, toBiome, seed, seaLevel, chunkX, chunkZ, posX, posY, posZ, canyonWidth, canyonHeight, bitSet);
				this.carveSphere(chunk, toBiome, seed, seaLevel, chunkX, chunkZ, posX, this.getUpperCanyonY(rng, (int) posY, canyonHeight), posZ, 
						canyonWidth, canyonHeight - rng.nextDouble(), bitSet); 	// TODO: test and modify
			}
		}
	}

}
