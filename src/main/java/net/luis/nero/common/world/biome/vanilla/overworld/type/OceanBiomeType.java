package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.BiomeNoise;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum OceanBiomeType implements IBiomeType {
	
	WARM_OCEAN(0.95F, BiomeNoise.of(-1.0, 0.1), BiomeSettings.getWarmOceanSpawns(false), BiomeSettings.getWarmOceanFeatures(false)),
	DEEP_WARM_OCEAN(0.95F, BiomeNoise.of(-1.8, 0.1), BiomeSettings.getWarmOceanSpawns(true), BiomeSettings.getWarmOceanFeatures(true)),
	LUKEWARM_OCEAN(0.75F, BiomeNoise.of(-1.0, 0.1), BiomeSettings.getLukewarmOceanSpawns(false), BiomeSettings.getLukewarmOceanFeatures(false)),
	DEEP_LUKEWARM_OCEAN(0.75F, BiomeNoise.of(-1.8, 0.1), BiomeSettings.getLukewarmOceanSpawns(true), BiomeSettings.getLukewarmOceanFeatures(true)),
	OCEAN(0.5F, BiomeNoise.of(-1.0, 0.1), BiomeSettings.getOceanSpawns(), BiomeSettings.getOceanFeatures(false)),
	DEEP_OCEAN(0.5F, BiomeNoise.of(-1.8, 0.1), BiomeSettings.getOceanSpawns(), BiomeSettings.getOceanFeatures(true)),
	COLD_OCEAN(0.06F, BiomeNoise.of(-1.0, 0.1), BiomeSettings.getColdOceanSpawns(), BiomeSettings.getColdOceanFeatures(false)),
	DEEP_COLD_OCEAN(0.06F, BiomeNoise.of(-1.8, 0.1), BiomeSettings.getColdOceanSpawns(), BiomeSettings.getColdOceanFeatures(true)),
	FROZEN_OCEAN(-0.5F, BiomeNoise.of(-1.0, 0.1), BiomeSettings.getFrozenOceanSpawns(), BiomeSettings.getFrozenOceanFeatures(false)),
	DEEP_FROZEN_OCEAN(-0.5F, BiomeNoise.of(-1.8, 0.1), BiomeSettings.getFrozenOceanSpawns(), BiomeSettings.getFrozenOceanFeatures(true)),
	LEGACY_FORZEN_OCEAN(-0.5F, BiomeNoise.of(-1.2, 0.1), BiomeSettings.getLegacyFrozenOceanSpawns(), BiomeSettings.getLegacyFrozenOceanFeatures());
	
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
	public boolean isUnderground() {
		return false;
	}
	
	@Override
	public boolean isOcean() {
		return true;
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return false;
	}
	
	@Override
	public boolean isMushroomIsland() {
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
