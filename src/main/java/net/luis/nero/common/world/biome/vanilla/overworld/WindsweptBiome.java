package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class WindsweptBiome extends OverworldBiome {
	
	protected final boolean edge;
	protected final boolean wooded;
	protected final boolean gravelly;
	
	public WindsweptBiome(BiomeEffects biomeEffects, float temperature, IBiomeNoise biomeNoise, boolean edge, boolean wooded, boolean gravelly) {
		super(biomeEffects, temperature, biomeNoise);
		this.edge = edge;
		this.wooded = wooded;
		this.gravelly = gravelly;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getWindsweptSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getWindsweptFeatures(this.edge, this.wooded, this.gravelly).build();
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
		return this.edge && !this.wooded;
	}
	
	@Override
	public boolean isWindswept() {
		return true;
	}
	
}
