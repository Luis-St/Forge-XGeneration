package net.luis.nero.api.common.world.biome.vanilla;

import java.util.Optional;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.enums.BiomeEffects;
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
	
	public abstract boolean isIsland();
	
	public abstract boolean isMushroomIsland();
	
	public abstract boolean isHilly();
	
	public abstract boolean isWindswept();
	
}
  