package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum PlainBiomeType implements IBiomeType {
	
	PLAINS(0.0F, 0.0, 0.0, BiomeUtil.getPlainsSpawns(false), BiomeUtil.getPlainsFeatures(false), true, false, false),
	FLOWER_PLAINS(0.0F, 0.0, 0.0, BiomeUtil.getPlainsSpawns(true), BiomeUtil.getPlainsFeatures(true), true, false, false),
	SNOWY_PLAINS(0.0F, 0.0, 0.0, BiomeUtil.getTundraSpawns(), BiomeUtil.getTundraFeatures(false, false), true, false, false),
	ICE_SPIKES_PLAINS(0.0F, 0.0, 0.0, BiomeUtil.getTundraSpawns(), BiomeUtil.getTundraFeatures(true, false), false, true, false),
	WINDSWEPT_PLAINS(0.0F, 0.0, 0.0, BiomeUtil.getTundraSpawns(), BiomeUtil.getTundraFeatures(false, true), false, false, true);
	
	private final float temperature;
	private final double baseNoise;
	private final double noiseScale;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	private final boolean windswept;
	
	private PlainBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly, boolean windswept) {
		this(temperature, baseNoise, noiseScale, mobBuilder.build(), generationBuilder.build(), island, hilly, windswept);
	}
	
	private PlainBiomeType(float temperature, double baseNoise, double noiseScale, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly, boolean windswept) {
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
