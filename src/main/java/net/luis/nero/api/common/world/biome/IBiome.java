package net.luis.nero.api.common.world.biome;

import java.util.function.Supplier;

import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IBiome {
	
	public static Supplier<Biome> createBiome(IBiome biome) {
		Biome.BiomeBuilder biomeBuilder = new Biome.BiomeBuilder();
		biomeBuilder.precipitation(biome.getPrecipitation());
		biomeBuilder.biomeCategory(biome.getCategory());
		biomeBuilder.depth(biome.getDepth());
		biomeBuilder.scale(biome.getScale());
		biomeBuilder.temperature(biome.getTemperature());
		biomeBuilder.downfall(biome.getDownfall());
		biomeBuilder.specialEffects(biome.getBiomeEffects());
		biomeBuilder.mobSpawnSettings(biome.getMobSpawnSettings());
		biomeBuilder.generationSettings(biome.getBiomeGenerationSettings());
		return biomeBuilder::build;
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
	
	ModBiomeFeatures getModFeatures();
	
}
