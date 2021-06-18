package net.luis.nero.common.world.gen.surfacebuilder;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DeepslateSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public DeepslateSurfaceBuilder() {
		super(SurfaceBuilderConfig.CODEC);
	}

	@Override
	public void apply(Random rng, IChunk chunk, Biome biome, int worldX, int worldZ, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, 
			int seaLevel, long seed, SurfaceBuilderConfig config) {
	}
	
}
