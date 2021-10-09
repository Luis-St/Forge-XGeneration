package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BeachBiome extends OverworldBiome {
	
	protected final boolean shore;
	protected final boolean snowy;
	
	public BeachBiome(BiomeEffects biomeEffects, IBiomeNoise biomeNoise, boolean shore, boolean snowy) {
		super(biomeEffects, BiomeSettings.getBeachTemperature(shore, snowy), biomeNoise);
		this.shore = shore;
		this.snowy = snowy;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getBeachSpawns(!this.snowy && !this.shore).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getBeachFeatures(this.shore).build();
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
		return true;
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
		return this.shore;
	}
	
}
