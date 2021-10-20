package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.noise.OverworldBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum DesertBiomeType implements IBiomeType {
	
	DESERT(OverworldBiomeNoise.of(0.125, 0.05), BiomeSettings.getDesertFeatures(false, false), false),
	DESERT_HILLS(OverworldBiomeNoise.of(0.45, 0.3), BiomeSettings.getDesertFeatures(true, false), true),
	DESERT_LAKES(OverworldBiomeNoise.of(0.225, 0.25), BiomeSettings.getDesertFeatures(false, true), false);
	
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
