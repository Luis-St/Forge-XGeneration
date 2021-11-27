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
public enum PlainsBiomeType implements IBiomeType {
	
	PLAINS(0.8F, BiomeNoise.of(312, 1.05), BiomeSettings.getPlainsSpawns(false), BiomeSettings.getPlainsFeatures(false), false, false),
	HILLY_PLAINS(0.8F, BiomeNoise.of(320, 1.1), BiomeSettings.getPlainsSpawns(false), BiomeSettings.getPlainsFeatures(false), false, false),
	SUNFLOWER_PLAINS(0.0F, BiomeNoise.of(312, 1.05), BiomeSettings.getPlainsSpawns(true), BiomeSettings.getPlainsFeatures(true), false, false),
	SNOWY_PLAINS(0.0F, BiomeNoise.of(312, 01.05), BiomeSettings.getTundraSpawns(), BiomeSettings.getTundraFeatures(false, false), false, false),
	ICE_SPIKES_PLAINS(0.0F, BiomeNoise.of(334, 1.45000002), BiomeSettings.getTundraSpawns(), BiomeSettings.getTundraFeatures(true, false), true, false),
	SNOWY_HILLY_PLAINS(0.0F, BiomeNoise.of(320, 1.1), BiomeSettings.getTundraSpawns(), BiomeSettings.getTundraFeatures(false, true), false, true);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	private final boolean windswept;
	
	private PlainsBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly, boolean windswept) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly, windswept);
	}
	
	private PlainsBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly, boolean windswept) {
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
