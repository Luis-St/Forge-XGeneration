package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IBiomeType {
	
	float getTemperature();
	
	IBiomeNoise getBiomeNoise();
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();
	
	public boolean isUnderground();
	
	public boolean isOcean();
	
	public boolean isBeach();
	
	public boolean isMushroomIsland();
	
	public boolean isHilly();
	
	public boolean isWindswept();
	
}
