package net.luis.nero.common.world.biome.biomes.vanilla.overworld;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.ModBiome;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class TempBiome extends ModBiome {
	
	public TempBiome(BiomeEffects biomeEffects) {
		super(biomeEffects);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public float getTemperature() {
		return 0.5F;
	}
	
	@Override
	public float getDownfall() {
		return 0.0F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return IBiomeNoise.NULL;
	}

	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return new MobSpawnBuilder().build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return new BiomeGenerationBuilder().surfaceBuilder(() -> SurfaceBuilders.GRASS).build();
	}

}
