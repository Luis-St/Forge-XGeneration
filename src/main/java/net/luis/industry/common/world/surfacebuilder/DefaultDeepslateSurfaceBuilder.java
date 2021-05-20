package net.luis.industry.common.world.surfacebuilder;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DefaultDeepslateSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public DefaultDeepslateSurfaceBuilder() {
		super(SurfaceBuilderConfig.CODEC);
	}

	@Override
	public void apply(Random rng, IChunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, 
			int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		System.out.println("x: " + x);
		System.out.println("z: " + z);
		System.out.println("height: " + height);
		System.out.println("noise: " + noise);
		
	}

}
