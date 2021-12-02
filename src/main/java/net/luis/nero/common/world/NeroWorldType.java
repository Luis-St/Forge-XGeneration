package net.luis.nero.common.world;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.common.world.ForgeWorldPreset.IChunkGeneratorFactory;

// TODO: fix
public class NeroWorldType implements IChunkGeneratorFactory {
	
//	@Override
//	public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<NoiseGeneratorSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
//		return new OverworldChunkGenerator(biomeRegistry);
//	}

	@Override
	public ChunkGenerator createChunkGenerator(RegistryAccess dynamicRegistries, long seed, String generatorSettings) {
		return null;
	}
	
}
