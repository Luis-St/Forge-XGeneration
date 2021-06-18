package net.luis.nero.event.fml;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.luis.nero.Nero;
import net.luis.nero.api.capability.CapabilityFactory;
import net.luis.nero.api.capability.CapabilityStorage;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.common.world.biome.DeepslateBiomeProvider;
import net.luis.nero.common.world.gen.DeepslateChunkGenerator;
import net.luis.nero.core.NetworkHandler;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			registerNetwork(event);
			registerCapability(event);
			registerBiome(event);
			registerUtil(event);
			registerStructure(event);
		});
	}
	
	protected static void registerNetwork(FMLCommonSetupEvent event) {
		NetworkHandler.init();
	}
	
	protected static void registerCapability(FMLCommonSetupEvent event) {
		registerCapability(IBloodOrbCapability.class);
	}
	
	private static <T> void registerCapability(Class<T> clazz) {
		CapabilityManager.INSTANCE.register(clazz, new CapabilityStorage<T>(), new CapabilityFactory<T>());
	}
	
	protected static void registerBiome(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE, Type.MODIFIED);
	}
	
	protected static void registerUtil(FMLCommonSetupEvent event) {
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "deepslate_chunk_generator"), DeepslateChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "biomes"), DeepslateBiomeProvider.CODEC);
	}
	
	protected static void registerStructure(FMLCommonSetupEvent event) {
		registerStructure(ModStructures.DEEPSLATE_MINESHAFT.get(), new StructureSeparationSettings(4, 1, 456734349), false);
	}
	
	private static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings settings, boolean transformLand) {
		Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
		ImmutableMap<Structure<?>, StructureSeparationSettings> defaultStructures = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
				.putAll(DimensionStructuresSettings.DEFAULTS).put(structure, settings).build();
		ObfuscationReflectionHelper.setPrivateValue(DimensionStructuresSettings.class, null, defaultStructures, "field_236191_b_");
		if (transformLand) {
			ImmutableList<Structure<?>> noiseStructure = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
			ObfuscationReflectionHelper.setPrivateValue(Structure.class, null, noiseStructure, "field_236384_t_");
		}
		WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(noiseSettings -> {
			DimensionStructuresSettings dimensionSettings = noiseSettings.getValue().structureSettings();
			Map<Structure<?>, StructureSeparationSettings> structureConfig = dimensionSettings.structureConfig();
			if (structureConfig instanceof ImmutableMap) {
				Map<Structure<?>, StructureSeparationSettings> tempStructureConfig = new HashMap<>(structureConfig);
				tempStructureConfig.put(structure, settings);
				ObfuscationReflectionHelper.setPrivateValue(DimensionStructuresSettings.class, dimensionSettings, tempStructureConfig, "field_236193_d_");
			}
		});
	}
	
}