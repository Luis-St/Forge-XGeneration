package net.luis.nero.common.world.levelgen.surfacebuilder;

import java.util.Random;
import java.util.stream.IntStream;

import net.luis.nero.api.common.world.levelgen.surfacebuilder.ModSurfaceBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class FrozenPeaksSurfaceBuilder extends ModSurfaceBuilder {
	
	protected PerlinSimplexNoise iceNoise;
	protected long seed;
	
	public FrozenPeaksSurfaceBuilder() {
		super();
	}
	
	@Override
	protected SurfaceBuilderBaseConfiguration getConfig() {
		return SurfaceBuilder.CONFIG_GRASS;
	}

	@Override
	public void apply(Random rng, ChunkAccess chunkAccess, Biome biome, int x, int z, int height, double noise, int seaLevel, int minSurfaceLevel, long seed) {
		for (int y = minSurfaceLevel; y <= height; y++) {
			BlockPos pos = new BlockPos(x, y, z);
			Block block = chunkAccess.getBlockState(pos).getBlock();
			double iceValue = this.iceNoise.getSurfaceNoiseValue(x * 0.0625, z * 0.0625, 0.0, 0.0);
			if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT) {
				if (iceValue >= 0.2) {
					chunkAccess.setBlockState(pos, Blocks.PACKED_ICE.defaultBlockState(), false);
				} else {
					chunkAccess.setBlockState(pos, Blocks.SNOW_BLOCK.defaultBlockState(), false);
				}
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
