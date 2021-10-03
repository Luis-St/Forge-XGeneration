package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum GiantTaigaBiomeType implements IBiomeType {
	
	GIANT_TREE_TAIGA(0.3F, 0.0, 0.0, BiomeUtil.getGiantTreeTaigaSpawns(false), BiomeUtil.getGiantTreeTaigaFeatures(false), false),
	GIANT_TREE_TAIGA_HILLS(0.3F, 0.0, 0.0, BiomeUtil.getGiantTreeTaigaSpawns(false), BiomeUtil.getGiantTreeTaigaFeatures(false), true),	
	GIANT_SPRUCE_TAIGA(0.25F, 0.0, 0.0, BiomeUtil.getGiantTreeTaigaSpawns(true), BiomeUtil.getGiantTreeTaigaFeatures(true), false),
	GIANT_SPRUCE_TAIGA_HILLS(0.25F, 0.0, 0.0, BiomeUtil.getGiantTreeTaigaSpawns(true), BiomeUtil.getGiantTreeTaigaFeatures(true), true);
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private GiantTaigaBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(temperature, baseNoise, noiseScale, mobBuilder.build(), generationBuilder.build(), hilly);
	}
	
	private GiantTaigaBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly) {
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
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
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.hilly;
	}

	@Override
	public boolean isMountain() {
		return false;
	}
	
}
