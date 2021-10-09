package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class MushroomFieldsBiome extends OverworldBiome {
	
	protected final boolean shore;
	
	public MushroomFieldsBiome(BiomeEffects biomeEffects, IBiomeNoise biomeNoise, boolean shore) {
		super(biomeEffects, 0.9F, biomeNoise);
		this.shore = shore;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getMushroomFieldsSpawns(this.shore).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getMushroomFieldsFeatures().build();
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
	public boolean isWindswept() {
		return false;
	}
	
}
