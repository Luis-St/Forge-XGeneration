package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum RiverBiomeType implements IBiomeType {
	
	RIVER(0.5F, BiomeSettings.getRiverSpawns(false), BiomeSettings.getRiverFeatures(false)),
	FROZEN_RIVER(0.0F, BiomeSettings.getRiverSpawns(true), BiomeSettings.getRiverFeatures(true));
	
	private final float temperature;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	
	private RiverBiomeType(float temperature, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder) {
		this(temperature, mobBuilder.build(), generationBuilder.build());
	}
	
	private RiverBiomeType(float temperature, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings) {
		this.temperature = temperature;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return BiomeNoise.of(292, 0.0);
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
		return false;
	}
	
	@Override
	public boolean isBeach() {
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
