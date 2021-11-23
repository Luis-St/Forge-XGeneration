package net.luis.nero.common.world.biome.biomes.vanilla.nether;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.ModBiome;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public abstract class NetherBiome extends ModBiome {
	
	protected NetherBiome() {
		super(BiomeEffects.NETHER);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}

	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		return mobBuilder.build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.NETHER);
		return generationBuilder.build();
	}
	
}
