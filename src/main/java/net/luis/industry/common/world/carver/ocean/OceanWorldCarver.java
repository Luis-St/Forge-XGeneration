package net.luis.industry.common.world.carver.ocean;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.luis.industry.common.world.carver.ModWorldCarver;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class OceanWorldCarver extends ModWorldCarver {
	
	@Override
	protected int getFluidFillHeight(Random rng, int chunkX, int y, int chunkZ) {
		return 96;
	}
	
	@Override
	protected FluidState getFluidFillState(Random rng, int chunkX, int y, int chunkZ) {
		return Fluids.WATER.defaultFluidState();
	}
	
	@Override
	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return super.isStartChunk(rng, chunkX, chunkZ, config) /*&& rng.nextInt(4) == 0*/;
	}

	@Override
	public boolean carve(IChunk chunk, Function<BlockPos, Biome> toBiome, Random rng, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, 
			BitSet bitSet, ProbabilityConfig config) {
		boolean flag = false;
		int length = rng.nextInt(50);
		for (int posX = 0; posX < length; posX++) {
			for (int posZ = 0; posZ < length; posZ++) {
				int x = chunkXOffset * 16 + rng.nextInt(16) + posX;
				int y = MathHelper.nextInt(rng, 96 - 1, 96 + 1);
				int z = chunkZOffset * 16 + rng.nextInt(16) + posZ;
				double width = (7.5 + rng.nextDouble() * 0.6) * 3;
				double height = Math.sin(Math.PI / 2F) * (width / 2);
				flag = this.carveOcean(chunk, toBiome, rng.nextLong(), seaLevel, chunkX, chunkZ, x, y, z, width, height, bitSet);
			}
		}
		return flag;
	}
	
	public boolean carveOcean(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, 
			double x, double y, double z,double width, double height, BitSet bitSet) {
		return this.carveSphere(chunk, toBiome, seed, seaLevel, chunkX, chunkZ, x, y, z, width, height, bitSet);
	}

	@Override
	protected boolean skip(double d0, double d1, double d2, int i) {
		return d1 <= -0.7D || d0 * d0 + d1 * d1 + d2 * d2 >= 1.0D;
	}

}
