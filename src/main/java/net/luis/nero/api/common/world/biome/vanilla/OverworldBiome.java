package net.luis.nero.api.common.world.biome.vanilla;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.Biome.Precipitation;

public abstract class OverworldBiome extends ModBiome {
	
	protected final float temperature;
	
	public OverworldBiome(BiomeEffects biomeEffects, float temperature) {
		super(biomeEffects == null ? BiomeEffects.OVERWORLD : biomeEffects);
		this.temperature = temperature;
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
	
	public abstract boolean isUnderground();
	
	public abstract boolean isOcean();
	
	public abstract boolean isBeach();
	
	public abstract boolean isIsland();
	
	public abstract boolean isMushroomIsland();
	
	public abstract boolean isHilly();
	
	public abstract boolean isMountain();

	@Override
	public double getBaseNoise() {
		return 0;
	}

	@Override
	public double getNoiseScale() {
		return 0;
	}

	@Override
	public INoiseType getNoiseType() {
		return null;
	}
	
}
