package net.luis.nero.common.world.surfacebuilder;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DeepslateSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	protected final BlockState water = Fluids.WATER.defaultFluidState().createLegacyBlock();
	protected final BlockState lava = Fluids.LAVA.defaultFluidState().createLegacyBlock();
	
	protected final BlockState caveAir = Blocks.CAVE_AIR.defaultBlockState();
	protected final BlockState deepslate = ModBlocks.DEEPSLATE.get().defaultBlockState();
	
	protected final int minHeight = 64;
	protected final int baseHeight = 128;
	protected final int maxHeight = 192;
	
	protected final int waterOceanLevel = 96;
	protected final int lavaOceanLevel = 64;
	
	public DeepslateSurfaceBuilder() {
		super(SurfaceBuilderConfig.CODEC);
	}

	@Override
	public void apply(Random rng, IChunk chunk, Biome biome, int worldX, int worldZ, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, 
			int seaLevel, long seed, SurfaceBuilderConfig config) {
	}
	
}
