package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum ForestBiomeType implements IBiomeType {
	
	SNOWY_TAIGA(-0.5F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(true), BiomeSettings.getTaigaFeatures(false, false, false), true, false, false),
	SNOWY_TAIGA_HILLS(-0.5F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(true, false, false), true, true, false),
	WINDSWEPT_SNOWY_TAIGA(-0.5F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(false, false, true), false, false, true),
	TAIGA(0.25F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(true), BiomeSettings.getTaigaFeatures(false, true, false), true, false, false),
	TAIGA_HILLS(0.25F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(true, true, false), true, true, false),
	WINDSWEPT_TAIGA(0.25F, IBiomeNoise.NULL, BiomeSettings.getTaigaSpawns(false), BiomeSettings.getTaigaFeatures(false, true, true), true, false, true),
	FOREST(0.7F, IBiomeNoise.NULL, BiomeSettings.getForestSpawns(false), BiomeSettings.getForestFeatures(false), true, false, false),
	WINDSWEPT_FOREST(0.7F, IBiomeNoise.NULL, BiomeSettings.getForestSpawns(false), BiomeSettings.getForestFeatures(false), true, true, false),
	FLOWER_FOREST(0.7F, IBiomeNoise.NULL, BiomeSettings.getForestSpawns(true), BiomeSettings.getForestFeatures(true), true, false, false),
	BIRCH_FOREST(0.6F, IBiomeNoise.NULL, BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(false), true, false, false),
	BIRCH_FOREST_HILLS(0.6F, IBiomeNoise.NULL, BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(false), true, true, false),
	OLD_GROWTH_BIRCH_FOREST(0.6F, IBiomeNoise.NULL, BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(true), false, false, false),
	OLD_GROWTH_BIRCH_FOREST_HILLS(0.6F, IBiomeNoise.NULL, BiomeSettings.getBirchForestSpawns(), BiomeSettings.getBirchForestFeatures(true), false, true, false),
	DARK_FOREST(0.7F, IBiomeNoise.NULL, BiomeSettings.getDarkForestSpawns(false), BiomeSettings.getDarkForestFeatures(false), true, false, false),
	DARK_FOREST_HILLS(0.7F, IBiomeNoise.NULL, BiomeSettings.getDarkForestSpawns(true), BiomeSettings.getDarkForestFeatures(true), true, true, false);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	private final boolean windswept;
	
	private ForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly, boolean windswept) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), island, hilly, windswept);
	}
	
	private ForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly, boolean windswept) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.island = island;
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
	public boolean isOcean() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return this.island;
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
