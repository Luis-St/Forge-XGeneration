package net.luis.nero.api.common.world.biome;

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
	
	public abstract boolean isIsland();
	
	public abstract boolean hasForest();
	
	public abstract boolean isHilly();
	
	public abstract int hillHeight();
	
}
