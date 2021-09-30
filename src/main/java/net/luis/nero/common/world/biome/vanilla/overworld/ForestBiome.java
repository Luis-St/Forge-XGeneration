package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.IForestType;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ForestBiome extends OverworldBiome {
	
	protected final IForestType forestType;
	
	public ForestBiome(BiomeEffects biomeEffects, IForestType forestType) {
		super(biomeEffects, forestType.getTemperature(), forestType.getBaseNoise(), forestType.getNoiseScale(), forestType.getNoiseType());
		this.forestType = forestType;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.forestType.getMobSpawnSettings();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.forestType.getBiomeGenerationSettings();
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
		return this.forestType.isIsland();
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.forestType.isHilly();
	}
	
	@Override
	public boolean isMountain() {
		return this.forestType.isMountain();
	}
	
}
