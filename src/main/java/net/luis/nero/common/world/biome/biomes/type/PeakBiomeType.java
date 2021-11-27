package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

@Deprecated(forRemoval = true)
public enum PeakBiomeType implements IBiomeType {
	
	MEADOW(0.0F, BiomeNoise.of(396, 1.25), BiomeSettings.getMeadowSpawns(), BiomeSettings.getMeadowFeatures(), false),
	GROVE(0.5F, BiomeNoise.of(378, 1.5), BiomeSettings.getGroveSpawns(), BiomeSettings.getGroveFeatures(false), false),
	SNOWY_GROVE(0.0F, BiomeNoise.of(378, 1.5), BiomeSettings.getGroveSpawns(), BiomeSettings.getGroveFeatures(true), false),
	SNOWY_SLOPES(0.0F, BiomeNoise.of(454, 1.5), BiomeSettings.getSnowySlopesSpawns(), BiomeSettings.getSnowySlopesFeatures(), false),
	JAGGED_PEAKS(0.0F, BiomeNoise.of(472, 2.0), BiomeSettings.getJaggedPeaksSpawns(), BiomeSettings.getJaggedPeaksFeatures(), false),
	FROZEN_PEAKS(0.0F, BiomeNoise.of(472, 1.25), BiomeSettings.getPeaksSpawns(true), BiomeSettings.getFrozenPeaksFeatures(), false),
	STONY_PEAKS(0.0F, BiomeNoise.of(454, 1.6), BiomeSettings.getPeaksSpawns(false), BiomeSettings.getStonyPeaksFeatures(), false);
	
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
		return true;
	}
	
}
