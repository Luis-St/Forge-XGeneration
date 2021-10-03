package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class TundraBiome extends OverworldBiome {
	
	protected final boolean iceSpikes;
	protected final boolean mountain;
	
	public TundraBiome(BiomeEffects biomeEffects, double baseNoise, double noiseScale, INoiseType noiseType, boolean iceSpikes, boolean mountain) {
		super(biomeEffects, 0.0F, baseNoise, noiseScale, noiseType);
		this.iceSpikes = iceSpikes;
		this.mountain = mountain;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeUtil.getTundraSpawns().build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeUtil.getTundraFeatures(this.iceSpikes, this.mountain).build();
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
		return !this.iceSpikes && !this.mountain;
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
		return this.iceSpikes;
	}
	
	@Override
	public boolean isMountain() {
		return this.mountain;
	}
	
}
