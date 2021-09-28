package net.luis.nero.api.common.world.levelgen;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.api.common.world.biome.ModBiomeSource;
import net.minecraft.core.Registry;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.StructureSettings;

public abstract class ModChunkGenerator extends ChunkGenerator {

	protected ModChunkGenerator(ModBiomeSource biomeSource, boolean generateStronghold, long seed) {
		super(biomeSource, biomeSource, new StructureSettings(generateStronghold), seed);
		if (this.biomeSource instanceof ModBiomeSource modBiomeSource) {
			modBiomeSource.setChunkGenerator(this);
		}
	}
	
	public Registry<Biome> getRegistry() {
		return ((ModBiomeSource) this.biomeSource).getRegistry();
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, StructureFeatureManager structureManager, ChunkAccess chunkAccess) {
		return CompletableFuture.supplyAsync(() -> chunkAccess, executor);
	}

	@Override
	public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor levelAccessor) {
		return new NoiseColumn(0, new BlockState[0]);
	}
	
	public abstract double getNoiseAt(int x, int z);
	
	public abstract int getHeightAt(IBiome biome, int x, int z);

}
