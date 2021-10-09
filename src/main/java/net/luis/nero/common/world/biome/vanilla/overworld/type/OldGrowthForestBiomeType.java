package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum OldGrowthForestBiomeType implements IBiomeType {
	
	OLD_GROWTH_PINE_TAIGA(0.3F, IBiomeNoise.NULL, BiomeSettings.getOldGrowthTaigaSpawns(false), BiomeSettings.getOldGrowthTaigaFeatures(false), false),
	OLD_GROWTH_PINE_TAIGA_HILLS(0.3F, IBiomeNoise.NULL, BiomeSettings.getOldGrowthTaigaSpawns(false), BiomeSettings.getOldGrowthTaigaFeatures(false), true),	
	OLD_GROWTH_SPRUCE_TAIGA(0.25F, IBiomeNoise.NULL, BiomeSettings.getOldGrowthTaigaSpawns(true), BiomeSettings.getOldGrowthTaigaFeatures(true), false),
	OLD_GROWTH_SPRUCE_TAIGA_HILLS(0.25F, IBiomeNoise.NULL, BiomeSettings.getOldGrowthTaigaSpawns(true), BiomeSettings.getOldGrowthTaigaFeatures(true), true);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private OldGrowthForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly);
	}
	
	private OldGrowthForestBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly) {
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
		return false;
	}
	
}
