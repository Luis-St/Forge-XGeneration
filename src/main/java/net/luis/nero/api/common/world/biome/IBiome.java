package net.luis.nero.api.common.world.biome;

import java.util.function.Supplier;

import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.luis.nero.api.common.world.biome.vanilla.EndBiome;
import net.luis.nero.api.common.world.biome.vanilla.NetherBiome;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public interface IBiome {
	
	public static Supplier<Biome> createBiome(IBiome biome) {
		Biome.BiomeBuilder biomeBuilder = new Biome.BiomeBuilder();
		biomeBuilder.precipitation(biome.getPrecipitation());
		biomeBuilder.biomeCategory(biome.getCategory());
		biomeBuilder.depth(0.0F);
		biomeBuilder.scale(0.0F);
		biomeBuilder.temperature(biome.getTemperature());
		biomeBuilder.downfall(biome.getDownfall());
		biomeBuilder.specialEffects(biome.getBiomeEffects());
		biomeBuilder.mobSpawnSettings(biome.getMobSpawnSettings());
		biomeBuilder.generationSettings(biome.getBiomeGenerationSettings());
		return biomeBuilder::build;
	}
	
	default boolean isOverworld() {
		return this instanceof OverworldBiome;
	}
	
	default boolean isNether() {
		return this instanceof NetherBiome;
	}
	
	default boolean isEnd() {
		return this instanceof EndBiome;
	}
	
	default boolean isDeepslate() {
		return this instanceof DeepslateBiome;
	}
	
	Biome.Precipitation getPrecipitation();
	
	BiomeCategory getCategory();
	
	double getBaseNoise();
	
	double getNoiseScale();
	
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
	
	public static IBiome byId(int id) {
		ResourceLocation location = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES).getValue(id).getRegistryName();
		return ModBiomes.BIOMES.get(location.getPath());
	}
	
	public static IBiome byVanilla(Biome biome) {
		return ModBiomes.BIOMES.get(biome.getRegistryName().getPath());
	}
	
}
