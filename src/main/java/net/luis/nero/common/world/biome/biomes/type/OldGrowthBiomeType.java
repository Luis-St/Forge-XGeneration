package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum OldGrowthBiomeType implements IBiomeType {
	
	OLD_GROWTH_PINE_TAIGA(0.3F, BiomeNoise.of(318, 1.2), BiomeSettings.getOldGrowthTaigaSpawns(false), BiomeSettings.getOldGrowthTaigaFeatures(false), false),
	OLD_GROWTH_PINE_TAIGA_HILLS(0.3F, BiomeNoise.of(336, 1.3), BiomeSettings.getOldGrowthTaigaSpawns(false), BiomeSettings.getOldGrowthTaigaFeatures(false), true),	
	OLD_GROWTH_SPRUCE_TAIGA(0.25F, BiomeNoise.of(318, 1.2), BiomeSettings.getOldGrowthTaigaSpawns(true), BiomeSettings.getOldGrowthTaigaFeatures(true), false),
	OLD_GROWTH_SPRUCE_TAIGA_HILLS(0.25F, BiomeNoise.of(336, 1.2), BiomeSettings.getOldGrowthTaigaSpawns(true), BiomeSettings.getOldGrowthTaigaFeatures(true), true);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private OldGrowthBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly);
	}
	
	private OldGrowthBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly) {
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
		return false;
	}
	
}
