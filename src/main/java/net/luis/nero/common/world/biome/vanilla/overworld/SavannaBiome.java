package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class SavannaBiome extends OverworldBiome {
	
	protected final boolean plateau;
	protected final boolean windswept;
	
	public SavannaBiome(BiomeEffects biomeEffects, float temperature, IBiomeNoise biomeNoise, boolean plateau, boolean windswept) {
		super(biomeEffects, temperature, biomeNoise);
		this.plateau = plateau;
		this.windswept = windswept;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getSavannaSpawns(this.plateau).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getSavannaFeatures(this.plateau, this.windswept).build();
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
		return this.windswept;
	}
	
	@Override
	public boolean isWindswept() {
		return this.plateau || this.windswept;
	}
	
}
