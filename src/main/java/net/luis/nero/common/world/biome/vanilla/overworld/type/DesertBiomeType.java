package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.BiomeNoise;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum DesertBiomeType implements IBiomeType {
	
	DESERT(BiomeNoise.of(0.125, 0.05), BiomeSettings.getDesertFeatures(false, false), true, false),
	DESERT_HILLS(BiomeNoise.of(0.45, 0.3), BiomeSettings.getDesertFeatures(true, false), false, true),
	DESERT_LAKES(BiomeNoise.of(0.225, 0.25), BiomeSettings.getDesertFeatures(false, true), false, false);
	
	private final IBiomeNoise biomeNoise;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	
	private DesertBiomeType(IBiomeNoise biomeNoise, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly) {
		this(biomeNoise, generationBuilder.build(), island, hilly);
	}
	
	private DesertBiomeType(IBiomeNoise biomeNoise, BiomeGenerationSettings generationSettings, boolean island, boolean hilly) {
		this.biomeNoise = biomeNoise;
		this.generationSettings = generationSettings;
		this.island = island;
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
	public boolean isIsland() {
		return this.island;
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
