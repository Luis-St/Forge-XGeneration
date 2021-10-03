package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum OceanBiomeType implements IBiomeType {
	
	WARM_OCEAN(0.95F, 0.0, 0.0, BiomeUtil.getWarmOceanSpawns(false), BiomeUtil.getWarmOceanFeatures(false)),
	DEEP_WARM_OCEAN(0.95F, 0.0, 0.0, BiomeUtil.getWarmOceanSpawns(true), BiomeUtil.getWarmOceanFeatures(true)),
	LUKEWARM_OCEAN(0.75F, 0.0, 0.0, BiomeUtil.getLukewarmOceanSpawns(false), BiomeUtil.getLukewarmOceanFeatures(false)),
	DEEP_LUKEWARM_OCEAN(0.75F, 0.0, 0.0, BiomeUtil.getLukewarmOceanSpawns(true), BiomeUtil.getLukewarmOceanFeatures(true)),
	OCEAN(0.5F, 0.0, 0.0, BiomeUtil.getOceanSpawns(), BiomeUtil.getOceanFeatures(false)),
	DEEP_OCEAN(0.5F, 0.0, 0.0, BiomeUtil.getOceanSpawns(), BiomeUtil.getOceanFeatures(true)),
	COLD_OCEAN(0.06F, 0.0, 0.0, BiomeUtil.getColdOceanSpawns(), BiomeUtil.getColdOceanFeatures(false)),
	DEEP_COLD_OCEAN(0.06F, 0.0, 0.0, BiomeUtil.getColdOceanSpawns(), BiomeUtil.getColdOceanFeatures(true)),
	FROZEN_OCEAN(-0.5F, 0.0, 0.0, BiomeUtil.getFrozenOceanSpawns(), BiomeUtil.getFrozenOceanFeatures(false)),
	DEEP_FORZEN_OCEAN(-0.5F, 0.0, 0.0, BiomeUtil.getFrozenOceanSpawns(), BiomeUtil.getFrozenOceanFeatures(true)),
  /*LEGACY_FORZEN_OCEAN(-0.5F, 0.0, 0.0, null, null)*/;
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	
	private OceanBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder) {
		this(temperature, baseNoise, noiseScale, mobBuilder.build(), generationBuilder.build());
	}
	
	private OceanBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings) {
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public double getBaseNoise() {
		return this.baseNoise;
	}
	
	@Override
	public double getNoiseScale() {
		return this.noiseScale;
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
	public boolean isMountain() {
		return false;
	}
	
}
