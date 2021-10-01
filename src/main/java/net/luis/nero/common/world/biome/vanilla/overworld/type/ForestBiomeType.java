package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum ForestBiomeType implements IBiomeType {
	
	SNOWY_TAIGA(-0.5F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(true), BiomeUtil.getTaigaFeatures(false, false, false), true, false, false),
	SNOWY_TAIGA_HILLS(-0.5F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(true, false, false), true, true, false),
	SNOWY_TAIGA_MOUNTAINS(-0.5F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(false, false, true), false, false, true),
	TAIGA(0.25F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(true), BiomeUtil.getTaigaFeatures(false, true, false), true, false, false),
	TAIGA_HILLS(0.25F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(true, true, false), true, true, false),
	TAIGA_MOUNTAINS(0.25F, 0.0, 0.0, null, BiomeUtil.getTaigaSpawns(false), BiomeUtil.getTaigaFeatures(false, true, true), true, false, true),
	FOREST(0.7F, 0.0, 0.0, null, BiomeUtil.getForestSpawns(false), BiomeUtil.getForestFeatures(false), true, false, false),
	WOODEN_HILLS(0.7F, 0.0, 0.0, null, BiomeUtil.getForestSpawns(false), BiomeUtil.getForestFeatures(false), true, true, false),
	FLOWER_FOREST(0.7F, 0.0, 0.0, null, BiomeUtil.getForestSpawns(true), BiomeUtil.getForestFeatures(true), true, false, false),
	BIRCH_FOREST(0.6F, 0.0, 0.0, null, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(false), true, false, false),
	BIRCH_FOREST_HILLS(0.6F, 0.0, 0.0, null, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(false), true, true, false),
	TALL_BIRCH_FOREST(0.6F, 0.0, 0.0, null, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(true), false, false, false),
	TALL_BIRCH_FOREST_HILLS(0.6F, 0.0, 0.0, null, BiomeUtil.getBirchForestSpawns(), BiomeUtil.getBirchForestFeatures(true), false, true, false),
	DARK_FOREST(0.7F, 0.0, 0.0, null, BiomeUtil.getDarkForestSpawns(), BiomeUtil.getDarkForestFeatures(false), true, false, false),
	DARK_FOREST_HILLS(0.7F, 0.0, 0.0, null, BiomeUtil.getDarkForestSpawns(), BiomeUtil.getDarkForestFeatures(true), true, true, false);
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final INoiseType noiseType;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	private final boolean mountain;
	
	private ForestBiomeType(float temperature, double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly, boolean mountain) {
		this(temperature, baseNoise, noiseScale, noiseType, mobBuilder.build(), generationBuilder.build(), island, hilly, mountain);
	}
	
	private ForestBiomeType(float temperature, double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly, boolean mountain) {
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.noiseType = noiseType;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.island = island;
		this.hilly = hilly;
		this.mountain = mountain;
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
	public INoiseType getNoiseType() {
		return this.noiseType;
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
	public boolean isMountain() {
		return this.mountain;
	}
	
}
