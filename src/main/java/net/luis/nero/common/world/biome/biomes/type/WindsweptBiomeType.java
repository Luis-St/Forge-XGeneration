package net.luis.nero.common.world.biome.biomes.type;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.BiomeSettings;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum WindsweptBiomeType implements IBiomeType {
	
	WINDSWEPT_HILLS(0.2F, BiomeNoise.of(378, 1.5), BiomeSettings.getWindsweptFeatures(false, false, false), false),
	WINDSWEPT_EDGE_HILLS(0.2F, BiomeNoise.of(378, 1.3), BiomeSettings.getWindsweptFeatures(true, false, false), true),
	WINDSWEPT_GRAVELLY_HILLS(0.2F, BiomeNoise.of(378, 01.5), BiomeSettings.getWindsweptFeatures(false, false, true), false),
	MODIFIED_WINDSWEPT_GRAVELLY_HILLS(0.2F, BiomeNoise.of(378, 1.5), BiomeSettings.getWindsweptFeatures(false, false, true), false),
	WOODED_WINDSWEPT_HILLS(0.2F, BiomeNoise.of(378, 1.5), BiomeSettings.getWindsweptFeatures(false, true, false), false),
	SNOWY_WINDSWEPT_HILLS(-0.5F, BiomeNoise.of(378, 1.5), BiomeSettings.getWindsweptFeatures(false, false, false), false);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	
	private WindsweptBiomeType(float temperature, IBiomeNoise biomeNoise, BiomeGenerationBuilder generationBuilder, boolean hilly) {
		this(temperature, biomeNoise, generationBuilder.build(), hilly);
	}
	
	private WindsweptBiomeType(float temperature, IBiomeNoise biomeNoise, BiomeGenerationSettings generationSettings, boolean hilly) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
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
		return BiomeSettings.getWindsweptSpawns().build();
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
