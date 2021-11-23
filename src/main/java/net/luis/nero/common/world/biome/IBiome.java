package net.luis.nero.common.world.biome;

import java.util.function.Supplier;

import net.luis.nero.common.world.biome.biomes.deepslate.DeepslateBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.end.EndBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.nether.NetherBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.OverworldBiome;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
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
		biomeBuilder.depth((float) biome.getBiomeNoise().getBaseNoise());
		biomeBuilder.scale((float) biome.getBiomeNoise().getNoiseScale());
		biomeBuilder.temperature(biome.getTemperature());
		biomeBuilder.downfall(biome.getDownfall());
		biomeBuilder.specialEffects(biome.getBiomeSpecialEffects());
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
	
	IBiomeNoise getBiomeNoise();
	
	float getTemperature();
	
	float getDownfall();
	
	BiomeSpecialEffects getBiomeSpecialEffects();
	
	default int calculateSkyColor(float f) {
		float g = f / 3.0F;
		g = Mth.clamp(g, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
	}
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();
	
	ModBiomeFeatures getModFeatures();
	
	private static ForgeRegistry<Biome> getForgeRegistry() {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
	}
	
	default Biome vanilla() {
		return ModBiomes.REGISTRY_BIOMES.get(this).get();
	}
	
	default int id() {
		return getForgeRegistry().getID(this.vanilla());
	}
	
	default ResourceLocation location() {
		return this.vanilla().getRegistryName();
	}
	
	public static IBiome byVanilla(Biome biome) {
		return ModBiomes.BIOME_IDS.get(biome.getRegistryName());
	}
	
}
