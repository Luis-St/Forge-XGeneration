package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DesertBiome extends OverworldBiome {
	
	protected final boolean hilly;
	protected final boolean lakey;
	
	public DesertBiome(BiomeEffects biomeEffects, IBiomeNoise biomeNoise, boolean hilly, boolean lakey) {
		super(biomeEffects, 2.0F, biomeNoise);
		this.hilly = hilly;
		this.lakey = lakey;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getDesertSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getDesertFeatures(this.hilly, this.lakey).build();
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
	
//	@Override
//	public boolean isHilly() {
//		return this.hilly;
//	}
	
	@Override
	public boolean isWindswept() {
		return false;
	}
	
}
