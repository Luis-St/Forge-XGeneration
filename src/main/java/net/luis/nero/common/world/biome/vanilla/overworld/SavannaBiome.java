package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class SavannaBiome extends OverworldBiome {
	
	protected final boolean windswept;
	protected final boolean shattered;
	
	public SavannaBiome(BiomeEffects biomeEffects, float temperature, IBiomeNoise biomeNoise, boolean windswept, boolean shattered) {
		super(biomeEffects, temperature, biomeNoise);
		this.windswept = windswept;
		this.shattered = shattered;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return BiomeSettings.getSavannaSpawns(this.windswept).build();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return BiomeSettings.getSavannaFeatures(this.windswept, this.shattered).build();
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
		return !this.windswept && !this.shattered;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.shattered;
	}
	
	@Override
	public boolean isWindswept() {
		return this.windswept || this.shattered;
	}
	
}
