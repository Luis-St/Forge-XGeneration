package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.world.biome.util.BiomeUtil;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum JungleBiomeType implements IBiomeType {
	
	JUNGLE(0.0, 0.0, null, BiomeUtil.getJungleSpawns(false, false), BiomeUtil.getJungleFeatures(false, false, false), true, false),
	JUNGLE_HILLS(0.0, 0.0, null, BiomeUtil.getJungleSpawns(true, false), BiomeUtil.getJungleFeatures(false, false, false), false, true),
	MODIFIED_JUNGLE(0.0, 0.0, null, BiomeUtil.getJungleSpawns(false, true), BiomeUtil.getJungleFeatures(false, false, true), false, false),
	JUNGLE_EDGE(0.0, 0.0, null, BiomeUtil.getJungleEdgeSpawns(), BiomeUtil.getJungleFeatures(false, true, false), false, false),
	MODIFIED_JUNGLE_EDGE(0.0, 0.0, null, BiomeUtil.getJungleEdgeSpawns(), BiomeUtil.getJungleFeatures(false, true, true), false, true),
	BAMBOO_JUNGLE(0.0, 0.0, null, BiomeUtil.getBambooJungleSpawns(false), BiomeUtil.getJungleFeatures(true, false, false), false, false),
	BAMBOO_JUNGLE_HILLS(0.0, 0.0, null, BiomeUtil.getBambooJungleSpawns(true), BiomeUtil.getJungleFeatures(true, false, false), false, true);
	
	private final double baseNoise;
	private final double noiseScale;
	private final INoiseType noiseType;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean island;
	private final boolean hilly;
	
	private JungleBiomeType(double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean island, boolean hilly) {
		this(baseNoise, noiseScale, noiseType, mobBuilder.build(), generationBuilder.build(), island, hilly);
	}
	
	private JungleBiomeType(double baseNoise, double noiseScale, INoiseType noiseType, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean island, boolean hilly) {
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.noiseType = noiseType;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.island = island;
		this.hilly = hilly;
	}
	
	@Override
	public float getTemperature() {
		return 0.95F;
	}
	
	@Override
	public double getBaseNoise() {
		return this.baseNoise;
	}
	
	@Override
	public double getNoiseScale() {
		return this.noiseScale;
	}
	
	@Override
	public INoiseType getNoiseType() {
		return this.noiseType;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.mobSettings;
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.generationSettings;
	}
	
	@Override
	public boolean isOcean() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return this.island;
	}
	
	@Override
	public boolean isHilly() {
		return this.hilly;
	}

	@Override
	public boolean isMountain() {
		return false;
	}
	
}
