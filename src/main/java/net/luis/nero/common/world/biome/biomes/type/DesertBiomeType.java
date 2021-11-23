package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum DesertBiomeType implements IBiomeType {
	
	DESERT(BiomeNoise.of(312, 1.05), BiomeSettings.getDesertFeatures(false, false), false),
	DESERT_HILLS(BiomeNoise.of(336, 1.3), BiomeSettings.getDesertFeatures(true, false), true),
	DESERT_LAKES(BiomeNoise.of(312, 1.025), BiomeSettings.getDesertFeatures(false, true), false);
	
	private final IBiomeNoise biomeNoise;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private DesertBiomeType(IBiomeNoise biomeNoise, BiomeGenerationBuilder generationBuilder,  boolean hilly) {
		this(biomeNoise, generationBuilder.build(), hilly);
	}
	
	private DesertBiomeType(IBiomeNoise biomeNoise, BiomeGenerationSettings generationSettings, boolean hilly) {
		this.biomeNoise = biomeNoise;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
	}
	
	@Override
	public float getTemperature() {
		return 2.0F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getDesertSpawns().build();
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
