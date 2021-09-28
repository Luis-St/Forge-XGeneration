package net.luis.nero.api.common.world.levelgen;

import net.luis.nero.api.common.world.biome.ModBiomeSource;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public interface INoiseType {
	
	public int getNoiseHeight(ChunkAccess chunkAccess, WorldGenRegion genRegion, ModBiomeSource biomeSource, PerlinSimplexNoise perlinNoise, int x, int z, int seaLevel);
	
}
