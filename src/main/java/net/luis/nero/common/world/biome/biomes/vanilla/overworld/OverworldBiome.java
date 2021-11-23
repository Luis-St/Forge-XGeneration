package net.luis.nero.common.world.biome.biomes.vanilla.overworld;

import java.util.Optional;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.IBiomeType;
import net.luis.nero.common.world.biome.ModBiome;
import net.luis.nero.common.world.biome.biomes.type.ForestBiomeType;
import net.luis.nero.common.world.biome.biomes.type.PeakBiomeType;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeSpecialEffects.GrassColorModifier;

public abstract class OverworldBiome extends ModBiome {
	
	protected final float temperature;
	protected final IBiomeNoise biomeNoise;
	
	protected OverworldBiome(BiomeEffects biomeEffects, float temperature, IBiomeNoise biomeNoise) {
		super(biomeEffects == null ? BiomeEffects.OVERWORLD : biomeEffects);
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
	}
	
	public abstract IBiomeType getBiomeType();
	
	@Override
	public Precipitation getPrecipitation() {
		if (this.temperature >= 2.0F) {
			return Precipitation.NONE;
		}
		return this.temperature > 0.05F ? Precipitation.RAIN : Precipitation.SNOW;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public float getDownfall() {
		return getDownfall(this);
	}
	
	@Override
	protected final Optional<GrassColorModifier> getGrassColorModifier() {
		return this.biomeEffects == BiomeEffects.SWAMP ? Optional.of(GrassColorModifier.SWAMP) : super.getGrassColorModifier();
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	public abstract boolean isUnderground();
	
	public abstract boolean isOcean();
	
	public abstract boolean isBeach();
	
	public boolean isCliffsBeach() {
		return this.isBeach() && this.isWindswept();
	}
	
	public abstract boolean isMushroomIsland();
	
	public abstract boolean isHilly();
	
	public abstract boolean isWindswept();
	
	public abstract boolean isBiomeType(IBiomeType biomeType);
	
	protected static float getDownfall(OverworldBiome overworldBiome) {
		if (overworldBiome instanceof BadlandsBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof BeachBiome) {
			return 0.3F;
		} else if (overworldBiome instanceof DesertBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof ForestBiome forestBiome) {
			switch ((ForestBiomeType) forestBiome.getBiomeType()) {
			case BIRCH_FOREST, BIRCH_FOREST_HILLS, OLD_GROWTH_BIRCH_FOREST, OLD_GROWTH_BIRCH_FOREST_HILLS:
				return 0.6F;
			default:
				return 0.8F;
			}
		} else if (overworldBiome instanceof JungleBiome) {
			return 0.9F;
		} else if (overworldBiome instanceof JungleBiome) {
			return 1.0F;
		} else if (overworldBiome instanceof OldGrowthBiome) {
			return 0.8F;
		} else if (overworldBiome instanceof PeakBiome peakBiome) {
			switch ((PeakBiomeType) peakBiome.getBiomeType()) {
			case STONY_PEAKS:
				return 0.3F;
			case MEADOW, GROVE, SNOWY_GROVE:
				return 0.8F;
			case SNOWY_SLOPES, JAGGED_PEAKS, FROZEN_PEAKS:
				return 0.9F;
			}
		}  else if (overworldBiome instanceof SavannaBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof SwampBiome) {
			return 0.9F;
		} else if (overworldBiome instanceof WindsweptBiome) {
			return 0.3F;
		} else if (overworldBiome instanceof LushCavesBiome) {
			return 0.7F;
		} 
		return 0.5F;
	}
	
}
  