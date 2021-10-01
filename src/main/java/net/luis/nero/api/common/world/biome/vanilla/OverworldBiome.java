package net.luis.nero.api.common.world.biome.vanilla;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.Biome.Precipitation;

public abstract class OverworldBiome extends ModBiome {
	
	protected final float temperature;
	protected final double baseNoise;
	protected final double noiseScale;
	protected final INoiseType noiseType;
	
	public OverworldBiome(BiomeEffects biomeEffects, float temperature, double baseNoise, double noiseScale, INoiseType noiseType) {
		super(biomeEffects == null ? BiomeEffects.OVERWORLD : biomeEffects);
		this.temperature = temperature;
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.noiseType = noiseType;
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
		return this.temperature > 2.0F ? 0.0F : 1.0F;
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
	
	public abstract boolean isUnderground();
	
	public abstract boolean isOcean();
	
	public abstract boolean isBeach();
	
	public abstract boolean isIsland();
	
	public abstract boolean isMushroomIsland();
	
	public abstract boolean isHilly();
	
	public abstract boolean isMountain();
	
	public boolean isCliffsBeach() {
		return this.isBeach() && this.isMountain();
	}
	
}
  