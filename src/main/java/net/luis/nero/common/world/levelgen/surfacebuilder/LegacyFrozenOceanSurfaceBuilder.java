package net.luis.nero.common.world.levelgen.surfacebuilder;

import java.util.Random;
import java.util.stream.IntStream;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

@SuppressWarnings("deprecation")
public class LegacyFrozenOceanSurfaceBuilder extends ModSurfaceBuilder {
	
	protected PerlinSimplexNoise iceNoise;
	protected long seed;
	
	public LegacyFrozenOceanSurfaceBuilder() {
		super();
	}
	
	@Override
	protected SurfaceBuilderBaseConfiguration getConfig() {
		return SurfaceBuilder.CONFIG_GRASS;
	}

	@Override
	public void apply(Random rng, ChunkAccess chunkAccess, Biome biome, int x, int z, int height, double noise, int seaLevel, int minSurfaceLevel, long seed) {
		double iceNoise = this.iceNoise.getSurfaceNoiseValue(x * 0.0625, z  * 0.0625, 0.0, 0.0) - 1;
		for (int y = (int) (seaLevel + iceNoise); y <= seaLevel; y++) {
			BlockPos pos = new BlockPos(x, y, z);
			if (seaLevel >= y && chunkAccess.getBlockState(pos).getBlock() == Blocks.WATER && 0.05 >= biome.getBaseTemperature()) {
				chunkAccess.setBlockState(pos, Blocks.ICE.defaultBlockState(), false);
			}
		}
	}
	
	@Override
	public void initNoise(long seed) {
		if (this.seed != seed && this.iceNoise == null) {
			WorldgenRandom rng = new WorldgenRandom(seed);
			this.iceNoise = new PerlinSimplexNoise(rng, IntStream.rangeClosed(-3, 0));
		}
		this.seed = seed;
	}
	
}
