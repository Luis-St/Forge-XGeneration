package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum GiantTaigaBiomeType implements IBiomeType {
	
	GIANT_TREE_TAIGA(0.3F, 0.0, 0.0, null, BiomeUtil.getGiantTreeTaigaSpawns(false), BiomeUtil.getGiantTreeTaigaFeatures(false), false, false, false),
	GIANT_TREE_TAIGA_HILLS(0.3F, 0.0, 0.0, null, BiomeUtil.getGiantTreeTaigaSpawns(false), BiomeUtil.getGiantTreeTaigaFeatures(false), false, true, false),	
	GIANT_SPRUCE_TAIGA(0.25F, 0.0, 0.0, null, BiomeUtil.getGiantTreeTaigaSpawns(true), BiomeUtil.getGiantTreeTaigaFeatures(true), false, false, false),
	GIANT_SPRUCE_TAIGA_HILLS(0.25F, 0.0, 0.0, null, BiomeUtil.getGiantTreeTaigaSpawns(true), BiomeUtil.getGiantTreeTaigaFeatures(true), false, true, false);
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final INoiseType noiseType;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	private final boolean mountain;
	
	private GiantTaigaBiomeType(float temperature, double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly, boolean mountain) {
		this(temperature, baseNoise, noiseScale, noiseType, mobBuilder.build(), generationBuilder.build(), island, hilly, mountain);
	}
	
	private GiantTaigaBiomeType(float temperature, double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly, boolean mountain) {
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
