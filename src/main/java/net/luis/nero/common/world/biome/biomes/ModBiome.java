package net.luis.nero.common.world.biome.biomes;

import java.util.function.Supplier;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.util.Creator;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.world.biome.noise.IBiomeNoiseModifier;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.Biome.TemperatureModifier;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class ModBiome implements Creator<Supplier<Biome>> {
	
	protected final Biome.ClimateSettings climateSettings;
	protected final IBiomeNoise biomeNoise;
	protected final IBiomeNoiseModifier biomeNoiseModifier;
	protected final BiomeEffects biomeEffects;
	protected final BiomeGenerationSettings generationSettings;
	protected final MobSpawnSettings spawnSettings;	
	
	public ModBiome(Biome.ClimateSettings climateSettings, IBiomeNoise biomeNoise, IBiomeNoiseModifier biomeNoiseModifier, BiomeEffects biomeEffects, BiomeGenerationSettings generationSettings, MobSpawnSettings spawnSettings) {
		this.climateSettings = climateSettings;
		this.biomeNoise = biomeNoise;
		this.biomeNoiseModifier = biomeNoiseModifier;
		this.biomeEffects = biomeEffects;
		this.generationSettings = generationSettings;
		this.spawnSettings = spawnSettings;
	}
	
	public Precipitation getPrecipitation() {
		return this.climateSettings.precipitation;
	}
	
	public float getTemperature() {
		return this.climateSettings.temperature;
	}
	
	public TemperatureModifier getTemperatureModifier() {
		return this.climateSettings.temperatureModifier;
	}
	
	public float getDownfall() {
		return this.climateSettings.downfall;
	}
	
	public int getBaseNoise() {
		return this.biomeNoise.getBaseNoise();
	}
	
	public double getNoiseScale() {
		return this.biomeNoise.getNoiseScale();
	}
	
	public double getNoise(double simpleNoise) {
		return simpleNoise * this.getNoiseScale() + this.getBaseNoise();
	}
	
	public double getWorldNoise(ChunkAccess chunkAccess, double simpleNoise, int x, int y, int z, StructureFeatureManager structureManager) {
		return this.biomeNoiseModifier.modifyNoise(chunkAccess, this.getNoise(simpleNoise), x, y, z, structureManager);
	}
	
	public BiomeEffects getBiomeEffects() {
		return this.biomeEffects;
	}
	
	public BiomeGenerationSettings getGenerationSettings() {
		return this.generationSettings;
	}
	
	public MobSpawnSettings getSpawnSettings() {
		return this.spawnSettings;
	}

	@Override
	public Supplier<Biome> create() {
		Biome.BiomeBuilder biomeBuilder = new Biome.BiomeBuilder();
		biomeBuilder.precipitation(this.getPrecipitation());
		biomeBuilder.temperature(this.getTemperature());
		biomeBuilder.temperatureAdjustment(this.getTemperatureModifier());
		biomeBuilder.downfall(this.getDownfall());
		biomeBuilder.biomeCategory(Biome.BiomeCategory.NONE);
		biomeBuilder.specialEffects(this.getBiomeEffects().toBiomeSpecialEffects());
		biomeBuilder.generationSettings(this.getGenerationSettings());
		biomeBuilder.mobSpawnSettings(this.getSpawnSettings());
		return biomeBuilder::build;
	}
	
	private static ForgeRegistry<Biome> getForgeRegistry() {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
	}
	
	public Biome vanilla() {
		return ModBiomes.REGISTRY_BIOMES.get(this).get();
	}
	
	public int id() {
		return getForgeRegistry().getID(this.vanilla());
	}
	
	public ResourceLocation location() {
		return this.vanilla().getRegistryName();
	}
	
	public static ModBiome byVanilla(Biome biome) {
		return ModBiomes.BIOME_IDS.get(biome.getRegistryName());
	}
	
}
