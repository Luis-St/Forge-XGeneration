package net.luis.nero.common.world.gen.surfacebuilder;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class DeepslateSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	
	public DeepslateSurfaceBuilder() {
		super(SurfaceBuilderBaseConfiguration.CODEC);
	}

	@Override
	public void apply(Random rng, ChunkAccess chunk, Biome biome, int worldX, int worldZ, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, 
			int seaLevel, int minSurfaceLevel, long seed, SurfaceBuilderBaseConfiguration config) {
		
	}
	
}
