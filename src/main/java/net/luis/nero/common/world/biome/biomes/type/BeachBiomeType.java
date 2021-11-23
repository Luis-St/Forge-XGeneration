package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum BeachBiomeType implements IBiomeType {
	
	BEACH(0.8F, BiomeNoise.of(302, 1.025), BiomeSettings.getBeachSpawns(true), BiomeSettings.getBeachFeatures(false), false),
	SNOWY_BEACH(0.05F, BiomeNoise.of(302, 1.025), BiomeSettings.getBeachSpawns(false), BiomeSettings.getBeachFeatures(false), false),
	STONY_SHORE(0.2F, BiomeNoise.of(310, 1.8), BiomeSettings.getBeachSpawns(false), BiomeSettings.getBeachFeatures(true), true);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean windswept;
	
	private BeachBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean windswept) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), windswept);
	}
	
	private BeachBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean windswept) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.windswept = windswept;
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
		return false;
	}
	
	@Override
	public boolean isBeach() {
		return true;
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
		return this.windswept;
	}
	
}
