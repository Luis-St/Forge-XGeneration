package net.luis.nero.api.common.world.biome.vanilla;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.Biome.Precipitation;

public abstract class OverworldBiome extends ModBiome {
	
	protected final float temperature;
	protected final double baseNoise;
	protected final double noiseScale;
	
	protected OverworldBiome(BiomeEffects biomeEffects, float temperature, double baseNoise, double noiseScale) {
		super(biomeEffects == null ? BiomeEffects.OVERWORLD : biomeEffects);
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
	}
	
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
		return this.temperature >= 2.0F ? 0.0F : 1.0F;
	}
	
	@Override
	public double getBaseNoise() {
		return this.baseNoise;
	}

	@Override
	public double getNoiseScale() {
		return this.noiseScale;
	}
	
	public abstract boolean isUnderground();
	
	public abstract boolean isOcean();
	
	public abstract boolean isBeach();
	
	public boolean isCliffsBeach() {
		return this.isBeach() && this.isMountain();
	}
	
	public abstract boolean isIsland();
	
	public abstract boolean isMushroomIsland();
	
	public abstract boolean isHilly();
	
	public abstract boolean isMountain();
	
}
  