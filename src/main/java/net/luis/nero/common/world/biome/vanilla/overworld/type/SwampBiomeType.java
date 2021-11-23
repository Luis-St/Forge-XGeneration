package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum SwampBiomeType implements IBiomeType {
	
	SWAMP(BiomeNoise.of(292, 1.1), BiomeSettings.getSwampFeatures(false), false),
	SWAMP_HILLS(BiomeNoise.of(297, 1.3), BiomeSettings.getSwampFeatures(true), true);
	
	private final IBiomeNoise biomeNoise;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private SwampBiomeType(IBiomeNoise biomeNoise, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(biomeNoise, generationBuilder.build(), hilly);
	}
	
	private SwampBiomeType(IBiomeNoise biomeNoise, BiomeGenerationSettings generationSettings, boolean hilly) {
		this.biomeNoise = biomeNoise;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
	}
	
	@Override
	public float getTemperature() {
		return 0.8F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getSwampSpawns().build();
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
