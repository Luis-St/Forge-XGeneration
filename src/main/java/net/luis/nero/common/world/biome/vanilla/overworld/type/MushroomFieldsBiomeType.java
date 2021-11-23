package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.noise.BiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum MushroomFieldsBiomeType implements IBiomeType {
	
	MUSHROOM_FIELDS(BiomeNoise.of(318, 1.3), BiomeSettings.getMushroomFieldsSpawns(false), false),
	MUSHROOM_FIELD_SHORE(BiomeNoise.of(302, 1.025), BiomeSettings.getMushroomFieldsSpawns(true), true);
	
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final boolean beach;
	
	private MushroomFieldsBiomeType(IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, boolean beach) {
		this( biomeNoise, mobBuilder.build(), beach);
	}
	
	private MushroomFieldsBiomeType(IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, boolean beach) {
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.beach = beach;
	}
	
	@Override
	public float getTemperature() {
		return 0.9F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.mobSettings;
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
		return this.beach;
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
