package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class RiverBiome extends OverworldBiome {
	
	protected final boolean frozen;
	
	public RiverBiome(BiomeEffects biomeEffects, float temperature, IBiomeNoise biomeNoise, boolean frozen) {
		super(biomeEffects, frozen ? 0.0F : 0.5F, biomeNoise);
		this.frozen = frozen;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getRiverSpawns(this.frozen).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getRiverFeatures(this.frozen).build();
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
		return false;
	}
	
}