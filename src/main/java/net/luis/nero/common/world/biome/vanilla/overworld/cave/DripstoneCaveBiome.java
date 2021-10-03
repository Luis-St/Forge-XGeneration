package net.luis.nero.common.world.biome.vanilla.overworld.cave;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DripstoneCaveBiome extends OverworldBiome {
	
	public DripstoneCaveBiome(BiomeEffects biomeEffects, float temperature) {
		super(biomeEffects, temperature, 0.0, 0.0);
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getCaveSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getDripstoneCaveFeatures().build();
	}
	
	@Override
	public boolean isUnderground() {
		return true;
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
	public boolean isMountain() {
		return false;
	}
	
}
