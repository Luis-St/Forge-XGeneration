package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum ForestBiomeType implements IBiomeType {
	
	SNOWY_TAIGA(-0.5F, BiomeNoise.of(318, 1.2), BiomeSettings.getTaigaSpawns(true), BiomeSettings.getTaigaFeatures(false, false, false), false, false),
	SNOWY_TAIGA_HILLS(-0.5F, BiomeNoise.of(336, 1.3), BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(true, false, false), true, false),
	SNOWY_WINDSWEPT_TAIGA_HILLS(-0.5F, BiomeNoise.of(324, 1.4), BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(false, false, true), false, true),
	TAIGA(0.25F, BiomeNoise.of(318, 1.2), BiomeSettings.getTaigaSpawns(true), BiomeSettings.getTaigaFeatures(false, true, false), false, false),
	TAIGA_HILLS(0.25F, BiomeNoise.of(336, 1.3), BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(true, true, false), true, false),
	WINDSWEPT_TAIGA_HILLS(0.25F, BiomeNoise.of(324, 1.4), BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(false, true, true), false, true),
	FOREST(0.7F, BiomeNoise.of(310, 0.2), BiomeSettings.getForestSpawns(false), BiomeSettings.getForestFeatures(false), false, false),
	HILLY_FOREST(0.7F, BiomeNoise.of(336, 1.3), BiomeSettings.getForestSpawns(false), BiomeSettings.getForestFeatures(false), true, false),
	FLOWER_FOREST(0.7F, BiomeNoise.of(310, 1.4), BiomeSettings.getForestSpawns(true), BiomeSettings.getForestFeatures(true), false, false),
	BIRCH_FOREST(0.6F, BiomeNoise.of(310, 1.2), BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(false), false, false),
	BIRCH_FOREST_HILLS(0.6F, BiomeNoise.of(336, 1.3), BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(false), true, false),
	OLD_GROWTH_BIRCH_FOREST(0.6F, BiomeNoise.of(318, 1.4), BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(true), false, false),
	OLD_GROWTH_BIRCH_FOREST_HILLS(0.6F, BiomeNoise.of(344, 1.5), BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(true), true, false),
	DARK_FOREST(0.7F, BiomeNoise.of(310, 1.2), BiomeSettings.getDarkForestSpawns(false), BiomeSettings.getDarkForestFeatures(false), false, false),
	DARK_FOREST_HILLS(0.7F, BiomeNoise.of(318, 1.4), BiomeSettings.getDarkForestSpawns(true), BiomeSettings.getDarkForestFeatures(true), true, false);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	private final boolean windswept;
	
	private ForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly, boolean windswept) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly, windswept);
	}
	
	private ForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly, boolean windswept) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
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
		return false;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.hilly;
	}

	@Override
	public boolean isWindswept() {
		return this.windswept;
	}
	
}
