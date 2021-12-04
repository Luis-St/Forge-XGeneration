package net.luis.nero.event.fml;

import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.source.OverworldBiomeSource;
import net.luis.nero.common.world.levelgen.OverworldChunkGenerator;
import net.luis.nero.network.NetworkHandler;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		registerNetwork(event);
		registerBiome(event);
		registerStructure(event);
		registerUtil(event);
	}
	
	protected static void registerNetwork(FMLCommonSetupEvent event) {
		NetworkHandler.init();
	}
	
	protected static void registerBiome(FMLCommonSetupEvent event) {
		
	}
	
	protected static void registerStructure(FMLCommonSetupEvent event) {
		
	}
	
	protected static void registerUtil(FMLCommonSetupEvent event) {
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "overworld_chunk_generator"), OverworldChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "overworld_biome_source"), OverworldBiomeSource.CODEC);
	}
	
	@SuppressWarnings("unused")
	private static <F extends StructureFeature<?>> void registerStructure(F structure, StructureFeatureConfiguration structureConfig, boolean transformLand) {
		StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
		ImmutableMap<StructureFeature<?>, StructureFeatureConfiguration> defaultStructures = ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder().putAll(StructureSettings.DEFAULTS).put(structure, structureConfig).build();
		StructureSettings.DEFAULTS = defaultStructures;
		if (transformLand) {
			ArrayList<StructureFeature<?>> noiseStructure = Lists.newArrayList(StructureFeature.NOISE_AFFECTING_FEATURES);
			noiseStructure.add(structure);
			StructureFeature.NOISE_AFFECTING_FEATURES = noiseStructure;
		}
		BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(noiseSettings -> {
			StructureSettings structureSettings = noiseSettings.getValue().structureSettings();
			structureSettings.structureConfig.putIfAbsent(structure, StructureSettings.DEFAULTS.get(structure));
		});
	}
	
}