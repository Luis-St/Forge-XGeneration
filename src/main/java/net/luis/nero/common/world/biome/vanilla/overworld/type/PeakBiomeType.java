package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.BiomeNoise;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum PeakBiomeType implements IBiomeType {
	
	MEADOW(0.0F, BiomeNoise.of(1.25, 0.25), BiomeSettings.getMeadowSpawns(), BiomeSettings.getMeadowFeatures(), false),
	GROVE(0.5F, BiomeNoise.of(1.0, 0.5), BiomeSettings.getGroveSpawns(), BiomeSettings.getGroveFeatures(false), false),
	SNOWY_GROVE(0.0F, BiomeNoise.of(1.0, 0.5), BiomeSettings.getGroveSpawns(), BiomeSettings.getGroveFeatures(true), false),
	SNOWY_SLOPES(0.0F, BiomeNoise.of(2.0, 0.5), BiomeSettings.getSnowySlopesSpawns(), BiomeSettings.getSnowySlopesFeatures(), false),
	JAGGED_PEAKS(0.0F, BiomeNoise.of(2.25, 2.0), BiomeSettings.getJaggedPeaksSpawns(), BiomeSettings.getJaggedPeaksFeatures(), false),
	FROZEN_PEAKS(0.0F, BiomeNoise.of(2.25, 0.25), BiomeSettings.getPeaksSpawns(true), BiomeSettings.getFrozenPeaksFeatures(), false),
	STONY_PEAKS(0.0F, BiomeNoise.of(2.0, 0.6), BiomeSettings.getPeaksSpawns(false), BiomeSettings.getStonyPeaksFeatures(), false);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private PeakBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly);
	}
	
	private PeakBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
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
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.hilly;
	}

	@Override
	public boolean isWindswept() {
		return true;
	}
	
}
