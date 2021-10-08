package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum ForestBiomeType implements IBiomeType {
	
	SNOWY_TAIGA(-0.5F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(true), BiomeUtil.getTaigaFeatures(false, false, false), true, false, false),
	SNOWY_TAIGA_HILLS(-0.5F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(true, false, false), true, true, false),
	WINDSWEPT_SNOWY_TAIGA(-0.5F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(false, false, true), false, false, true),
	TAIGA(0.25F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(true), BiomeUtil.getTaigaFeatures(false, true, false), true, false, false),
	TAIGA_HILLS(0.25F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(true, true, false), true, true, false),
	WINDSWEPT_TAIGA(0.25F, 0.0, 0.0, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(false, true, true), true, false, true),
	FOREST(0.7F, 0.0, 0.0, BiomeUtil.getForestSpawns(false), BiomeUtil.getForestFeatures(false), true, false, false),
	WINDSWEPT_FOREST(0.7F, 0.0, 0.0, BiomeUtil.getForestSpawns(false), BiomeUtil.getForestFeatures(false), true, true, false),
	FLOWER_FOREST(0.7F, 0.0, 0.0, BiomeUtil.getForestSpawns(true), BiomeUtil.getForestFeatures(true), true, false, false),
	BIRCH_FOREST(0.6F, 0.0, 0.0, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(false), true, false, false),
	BIRCH_FOREST_HILLS(0.6F, 0.0, 0.0, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(false), true, true, false),
	OLD_GROWTH_BIRCH_FOREST(0.6F, 0.0, 0.0, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(true), false, false, false),
	OLD_GROWTH_BIRCH_FOREST_HILLS(0.6F, 0.0, 0.0, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(true), false, true, false),
	DARK_FOREST(0.7F, 0.0, 0.0, BiomeUtil.getDarkForestSpawns(false), BiomeUtil.getDarkForestFeatures(false), true, false, false),
	DARK_FOREST_HILLS(0.7F, 0.0, 0.0, BiomeUtil.getDarkForestSpawns(true), BiomeUtil.getDarkForestFeatures(true), true, true, false);
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	private final boolean windswept;
	
	private ForestBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly, boolean windswept) {
		this(temperature, baseNoise, noiseScale, mobBuilder.build(), generationBuilder.build(), island, hilly, windswept);
	}
	
	private ForestBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly, boolean windswept) {
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
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
