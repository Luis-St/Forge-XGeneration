package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class MushroomFieldsBiome extends OverworldBiome {
	
	protected final boolean shore;
	
	public MushroomFieldsBiome(BiomeEffects biomeEffects, double baseNoise, double noiseScale, boolean shore) {
		super(biomeEffects, 0.9F, baseNoise, noiseScale);
		this.shore = shore;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getMushroomFieldsSpawns(this.shore).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getMushroomFieldsFeatures().build();
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
		return this.shore;
	}
	
	@Override
	public boolean isIsland() {
		return true;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return true;
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
