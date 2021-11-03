package net.luis.nero.common.world;

import net.luis.nero.common.world.levelgen.OverworldChunkGenerator;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.common.world.ForgeWorldType.IChunkGeneratorFactory;

public class NeroWorldType implements IChunkGeneratorFactory {
	
	@Override
	public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<NoiseGeneratorSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
		return new OverworldChunkGenerator(biomeRegistry);
	}
	
}
