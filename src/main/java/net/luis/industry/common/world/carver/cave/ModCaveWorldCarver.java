package net.luis.industry.common.world.carver.cave;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.luis.industry.common.world.carver.ModWorldCarver;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ModCaveWorldCarver extends ModWorldCarver {

	public ModCaveWorldCarver(int lavaHeigth) {
		super(lavaHeigth);
	}

	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return rng.nextFloat() <= config.probability;
	}
	
	@Override
	public int getRange() {
		throw new UnsupportedOperationException();
	}
	
	public int getRange(Random rng, int range, int chunkX, int chunkZ) {
		return (range * 2 - 1) * 16;
	}
	
	protected int getCaveBound(Random rng) {
		return 15;
	}

	protected float getThickness(Random rng) {
		float f = rng.nextFloat() * 2.0F + rng.nextFloat();
		if (rng.nextInt(10) == 0) {
			f *= rng.nextFloat() * rng.nextFloat() * 3.0F + 1.0F;
		}
		return f;
	}

	protected double getYScale(Random rng, int chunkX, int chunkZ) {
		return 1.0D;
	}

	protected int getCaveY(Random rng) {
		return rng.nextInt(rng.nextInt(120) + 8);
	}
	
	public int getRoomChance(Random rng, int chunkX, int chunkZ) {
		return rng.nextInt(4);
	}
	
	public double getRoomWidth(Random rng, int chunkX, int chunkZ) {
		return 1.0 + rng.nextFloat() * 0.6F;
	}
	
	public double calcRoomWidth(Random rng, double width) {
		return 1.5D + Math.sin(Math.PI / 2F) * width;
	}
	
	public double getRoomHeight(Random rng, double width, int chunkX, int chunkZ) {
		return 0.5;
	}
	
	public double calcRoomHeight(Random rng, double roomWidth, double heigth) {
		return roomWidth * heigth;
	}
	
	@Override
	public boolean carve(IChunk chunk, Function<BlockPos, Biome> toBiome, Random rng, int seaLevel,
			int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet bitSet, ProbabilityConfig config) {
		int range = this.getRange(rng, 4, chunkX, chunkZ);
		int rngBound = rng.nextInt(rng.nextInt(rng.nextInt(this.getCaveBound(rng)) + 1) + 1);
		for (int caveBound = 0; caveBound < rngBound; ++caveBound) {
			double posX = (double) (chunkXOffset * 16 + rng.nextInt(16));
			double posY = (double) this.getCaveY(rng);
			double posZ = (double) (chunkZOffset * 16 + rng.nextInt(16));
			int l = 1;
			int roomChance = this.getRoomChance(rng, chunkX, chunkZ);
			if (roomChance > 0) {
				if (roomChance == 0) {
					double width = this.getRoomWidth(rng, chunkX, chunkZ);
					double height = this.getRoomHeight(rng, width, chunkX, chunkZ);
					this.genRoom(chunk, toBiome, rng.nextLong(), seaLevel, chunkX, chunkZ, posX, posY, posZ, width, height, bitSet);
					l += rng.nextInt(4);
				}
			}
			for (int k1 = 0; k1 < l; ++k1) {
				float f = rng.nextFloat() * ((float) Math.PI * 2F);
				float f3 = (rng.nextFloat() - 0.5F) / 4.0F;
				float thickness = this.getThickness(rng);
				int caveLength = range - rng.nextInt(range / 4);
				double yScale = this.getYScale(rng, chunkX, chunkZ);
				this.genTunnel(chunk, toBiome, rng.nextLong(), seaLevel, chunkX, chunkZ, posX, posY, posZ, thickness, f, f3, 0, caveLength, yScale, bitSet);
			}
		}
		return true;
	}
	
	protected void genRoom(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, 
			double posX, double posY, double posZ, double width, double heigth, BitSet bitSet) {
		double roomWidth = this.calcRoomWidth(new Random(seed), width);
		double roomHeight = this.calcRoomHeight(new Random(seed), roomWidth, heigth);
		this.carveSphere(chunk, toBiome, seed, seaLevel, chunkX, chunkZ, posX + 1.0D, posY, posZ, roomWidth, roomHeight, bitSet);
	}

	protected void genTunnel(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, double posX, double posY,
			double posZ, float thickness, float axisMultiplier0, float axisMultiplier1, int startLength, int caveLength, double yScale, BitSet bitSet) {
		Random rng = new Random(seed);
		int i = rng.nextInt(caveLength / 2) + caveLength / 4;
		boolean flag = rng.nextInt(6) == 0;
		float[] motionModifiers = new float[3];
		motionModifiers[0] = 0.0F;
		motionModifiers[1] = 0.0F;
		for (int j = startLength; j < caveLength; ++j) {
			double width = 1.5D + Math.sin(Math.PI * j / caveLength) * thickness;
			double height = width * yScale;
			motionModifiers[2] = MathHelper.cos(axisMultiplier1);
			posX += Math.cos(axisMultiplier0) * motionModifiers[2];
			posY += Math.sin(axisMultiplier1);
			posZ += Math.sin(axisMultiplier0) * motionModifiers[2];
			axisMultiplier1 *= (flag ? 0.92F : 0.7F);
			axisMultiplier1 += motionModifiers[1] * 0.1F;
			axisMultiplier0 += motionModifiers[0] * 0.1F;
			motionModifiers[1] *= 0.9F;
			motionModifiers[0] *= 0.75F;
			motionModifiers[1] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			motionModifiers[0] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (j == i && thickness > 1.0F) {
				float nextThickness = rng.nextFloat() * 0.5F + 0.5F;
				float nextAxisMultiplier0 = (float) (axisMultiplier0 - (Math.PI / 2F));
				float nextAxisMultiplier1 = axisMultiplier1 / 3.0F;
				for (int k = 0; k < 2; k++) {
					this.genTunnel(chunk, toBiome, rng.nextLong(), seaLevel, chunkX, chunkZ, posX, posY, posZ,
							nextThickness, nextAxisMultiplier0, nextAxisMultiplier1, j, caveLength, 1.0D, bitSet);
				}
				return;
			}
			if (rng.nextInt(4) != 0) {
				if (!this.canReach(chunkX, chunkZ, posX, posZ, j, caveLength, thickness)) {
					return;
				}
				this.carveSphere(chunk, toBiome, seed, chunkX, chunkX, chunkZ, posX, posY, posZ, width, height, bitSet);
			}
		}

	}
	
	@Override
	protected boolean skip(double d0, double d1, double d2, int i) {
		return d1 <= -0.7D || d0 * d0 + d1 * d1 + d2 * d2 >= 1.0D;
	}

}
