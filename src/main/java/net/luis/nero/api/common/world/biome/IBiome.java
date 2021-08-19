package net.luis.nero.api.common.world.biome;

import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IBiome {
	
	default Biome createBiome() {
		Biome.BiomeBuilder biomeBuilder = new Biome.BiomeBuilder();
		biomeBuilder.precipitation(this.getPrecipitation());
		biomeBuilder.biomeCategory(this.getCategory());
		biomeBuilder.depth(this.getDepth());
		biomeBuilder.scale(this.getScale());
		biomeBuilder.temperature(this.getTemperature());
		biomeBuilder.downfall(this.getDownfall());
		biomeBuilder.specialEffects(this.getBiomeEffects());
		biomeBuilder.mobSpawnSettings(this.getMobSpawnSettings());
		biomeBuilder.generationSettings(this.getBiomeGenerationSettings());
		return biomeBuilder.build();
	}
	
	Biome.Precipitation getPrecipitation();
	
	BiomeCategory getCategory();
	
	float getDepth();
	
	float getScale();
	
	float getTemperature();
	
	float getDownfall();
	
	BiomeSpecialEffects getBiomeEffects();
	
	default int calculateSkyColor(float f) {
		float g = f / 3.0F;
		g = Mth.clamp(g, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
	}
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();

}
