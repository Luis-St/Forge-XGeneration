package net.luis.nero.common.world.levelgen.newsurfacebuilder;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.nero.common.world.biome.IBiome;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public abstract class OverworldSurfaceBuilder extends SurfaceBuilder<OverworldSurfaceBuilderConfiguration> {
	
	protected static final BlockState SAND = Blocks.SAND.defaultBlockState();
	protected static final BlockState RED_SAND = Blocks.RED_SAND.defaultBlockState();
	protected static final BlockState GRAVEL = Blocks.GRAVEL.defaultBlockState();
	protected static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.defaultBlockState();
	protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
	protected static final BlockState DEEPSLATE = Blocks.DEEPSLATE.defaultBlockState();
	
	protected PerlinSimplexNoise surfaceOffsetNoise;
	protected long seed;
	
	public OverworldSurfaceBuilder() {
		super(OverworldSurfaceBuilderConfiguration.CODEC);
	}
	
	public ConfiguredSurfaceBuilder<OverworldSurfaceBuilderConfiguration> configured() {
		return new ConfiguredSurfaceBuilder<>(this, new OverworldSurfaceBuilderConfiguration());
	}
	
	@Override
	public final void apply(Random rng, ChunkAccess chunkAccess, Biome biome, int x, int z, int maxSurface, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int minSurface, long seed, OverworldSurfaceBuilderConfiguration config) {
		throw new UnsupportedOperationException("Fail to build Surface, report this bug to the Mod author!");
	}
	
	public abstract void apply(Random rng, ChunkAccess chunkAccess, @Nullable IBiome biome, int x, int z, double noise, int minSurface, int maxSurface, int seaLevel, long seed);
	
	@Override
	public void initNoise(long seed) {
		if (this.seed != seed) {
			this.init(seed);
			if (this.surfaceOffsetNoise == null) {
				WorldgenRandom rng = new WorldgenRandom(seed);
				rng.consumeCount(1234);
				this.surfaceOffsetNoise = new PerlinSimplexNoise(rng, Lists.newArrayList(0));
			}
		}
		this.seed = seed;
	}
	
	protected double getSurfaceOffset(int x, int z) {
		return this.surfaceOffsetNoise.getSurfaceNoiseValue(x / 512.0, z / 512.0, 0, 0);
	}
	
	protected void init(long seed) {
		
	}
	
}
