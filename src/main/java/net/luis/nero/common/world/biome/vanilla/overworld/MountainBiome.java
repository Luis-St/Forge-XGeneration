package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class MountainBiome extends OverworldBiome {
	
	protected final boolean edge;
	protected final boolean wooded;
	protected final boolean gravelly;
	
	public MountainBiome(BiomeEffects biomeEffects, float temperature, double baseNoise, double noiseScale, INoiseType noiseType, boolean edge, boolean wooded, boolean gravelly) {
		super(biomeEffects, temperature, baseNoise, noiseScale, noiseType);
		this.edge = edge;
		this.wooded = wooded;
		this.gravelly = gravelly;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getMountainSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getMountainFeatures(this.edge, this.wooded, this.gravelly).build();
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
	public boolean isMountain() {
		return true;
	}
	
}
