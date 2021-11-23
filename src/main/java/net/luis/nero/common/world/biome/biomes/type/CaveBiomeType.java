package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum CaveBiomeType implements IBiomeType {
	
	DRIPSTONE_CAVE(0.4F, IBiomeNoise.NULL, BiomeSettings.getCaveSpawns(), BiomeSettings.getDripstoneCaveFeatures()),
	LUSH_CAVES(0.8F, IBiomeNoise.NULL, BiomeSettings.getCaveSpawns(), BiomeSettings.getLushCavesFeatures());
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	
	private CaveBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build());
	}
	
	private CaveBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings) {
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
		return true;
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
