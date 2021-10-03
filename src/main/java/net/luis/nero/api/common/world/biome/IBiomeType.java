package net.luis.nero.api.common.world.biome;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IBiomeType {
	
	float getTemperature();
	
	double getBaseNoise();
	
	double getNoiseScale();
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();
	
	boolean isOcean();
	
	boolean isIsland();
	
	boolean isHilly();
	
	boolean isMountain();
	
}
