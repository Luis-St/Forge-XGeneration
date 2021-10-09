package net.luis.nero.common.world.biome.vanilla.overworld.cave;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DeepdarkOceanBiome extends OverworldBiome {
	
	public DeepdarkOceanBiome(BiomeEffects biomeEffects, float temperature) {
		super(biomeEffects, temperature, IBiomeNoise.NULL);
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getDeepdarkOceanSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getDeepdarkOceanFeatures().build();
	}
	
	@Override
	public boolean isUnderground() {
		return true;
	}
	
	@Override
	public boolean isOcean() {
		return true;
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return false;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return false;
	}
	
	@Override
	public boolean isWindswept() {
		return false;
	}
	
}
