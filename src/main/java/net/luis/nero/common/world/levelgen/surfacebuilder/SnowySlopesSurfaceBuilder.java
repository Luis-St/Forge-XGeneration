package net.luis.nero.common.world.levelgen.surfacebuilder;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

@SuppressWarnings("deprecation")
public class SnowySlopesSurfaceBuilder extends ModSurfaceBuilder {
	
	public SnowySlopesSurfaceBuilder() {
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
			if (block == Blocks.DIRT || block == Blocks.GRASS_BLOCK) {
				chunkAccess.setBlockState(pos, Blocks.SNOW_BLOCK.defaultBlockState(), false);
			}
		}
	}
	
}
