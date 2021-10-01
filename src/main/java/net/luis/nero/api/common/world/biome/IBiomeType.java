package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IBiomeType {
	
	// Default: (0.0F, 0.0, 0.0, null, null, null, false, false, false)
	
	float getTemperature();
	
	double getBaseNoise();
	
	double getNoiseScale();
	
	INoiseType getNoiseType();
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();
	
	boolean isOcean();
	
	boolean isIsland();
	
	boolean isHilly();
	
	boolean isMountain();
	
}
