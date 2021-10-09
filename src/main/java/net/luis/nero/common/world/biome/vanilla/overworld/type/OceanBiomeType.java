package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum OceanBiomeType implements IBiomeType {
	
	WARM_OCEAN(0.95F, IBiomeNoise.NULL, BiomeSettings.getWarmOceanSpawns(false), BiomeSettings.getWarmOceanFeatures(false)),
	DEEP_WARM_OCEAN(0.95F, IBiomeNoise.NULL, BiomeSettings.getWarmOceanSpawns(true), BiomeSettings.getWarmOceanFeatures(true)),
	LUKEWARM_OCEAN(0.75F, IBiomeNoise.NULL, BiomeSettings.getLukewarmOceanSpawns(false), BiomeSettings.getLukewarmOceanFeatures(false)),
	DEEP_LUKEWARM_OCEAN(0.75F, IBiomeNoise.NULL, BiomeSettings.getLukewarmOceanSpawns(true), BiomeSettings.getLukewarmOceanFeatures(true)),
	OCEAN(0.5F, IBiomeNoise.NULL, BiomeSettings.getOceanSpawns(), BiomeSettings.getOceanFeatures(false)),
	DEEP_OCEAN(0.5F, IBiomeNoise.NULL, BiomeSettings.getOceanSpawns(), BiomeSettings.getOceanFeatures(true)),
	COLD_OCEAN(0.06F, IBiomeNoise.NULL, BiomeSettings.getColdOceanSpawns(), BiomeSettings.getColdOceanFeatures(false)),
	DEEP_COLD_OCEAN(0.06F, IBiomeNoise.NULL, BiomeSettings.getColdOceanSpawns(), BiomeSettings.getColdOceanFeatures(true)),
	FROZEN_OCEAN(-0.5F, IBiomeNoise.NULL, BiomeSettings.getFrozenOceanSpawns(), BiomeSettings.getFrozenOceanFeatures(false)),
	DEEP_FORZEN_OCEAN(-0.5F, IBiomeNoise.NULL, BiomeSettings.getFrozenOceanSpawns(), BiomeSettings.getFrozenOceanFeatures(true)),
  /*LEGACY_FORZEN_OCEAN(-0.5F, IBiomeNoise.NULL, null, null)*/;
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	
	private OceanBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build());
	}
	
	private OceanBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.mobSettings;
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.generationSettings;
	}
	
	@Override
	public boolean isOcean() {
		return true;
	}
	
	@Override
	public boolean isIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return false;
	}

	@Override
	public boolean isWindswept() {
		return false;
	}
	
}
