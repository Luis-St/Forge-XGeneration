package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class SavannaBiome extends OverworldBiome {
	
	protected final boolean plateau;
	protected final boolean shattered;
	
	public SavannaBiome(BiomeEffects biomeEffects, float temperature, double baseNoise, double noiseScale, boolean plateau, boolean shattered) {
		super(biomeEffects, temperature, baseNoise, noiseScale);
		this.plateau = plateau;
		this.shattered = shattered;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getSavannaSpawns(this.plateau).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getSavannaFeatures(this.plateau, this.shattered).build();
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
		return !this.plateau;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.shattered;
	}
	
	@Override
	public boolean isMountain() {
		return this.plateau || this.shattered;
	}
	
}
