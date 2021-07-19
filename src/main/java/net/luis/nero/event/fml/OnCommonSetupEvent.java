package net.luis.nero.event.fml;

import net.luis.nero.Nero;
import net.luis.nero.api.common.capability.CapabilityFactory;
import net.luis.nero.api.common.capability.CapabilityStorage;
import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.common.util.Reflections;
import net.luis.nero.common.world.biome.DeepslateBiomeProvider;
import net.luis.nero.common.world.gen.DeepslateChunkGenerator;
import net.luis.nero.common.world.test.TestBiomeProvider;
import net.luis.nero.common.world.test.TestChunkGenerator;
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
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		registerNetwork(event);
		registerCapability(event);
		registerBiome(event);
		registerUtil(event);
		registerStructure(event);
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
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "deepslate_biome_provider"), DeepslateBiomeProvider.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "test_chunk_generator"), TestChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "test_biomes"), TestBiomeProvider.CODEC);
/*		Map<ResourceLocation, DimensionRenderInfo> renderInfos = new HashMap<>(); // TODO: try 
		renderInfos.put(ModDimensionTypes.DEEPSLATE.location(), ModDimensionRenderInfo.DEEPSLATE);
		Reflections.addDimensionRenderInfos(renderInfos);*/
	}
	
	protected static void registerStructure(FMLCommonSetupEvent event) {
		registerStructure(ModStructures.DEEPSLATE_MINESHAFT.get(), new StructureSeparationSettings(4, 1, 456734349), false);
	}
	
	private static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings settings, boolean transformLand) {
		Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
		Reflections.addDefaultStructure(structure, settings);
		if (transformLand) {
			Reflections.addNoiseStructure(structure);
		}
		WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(noiseSettings -> {
			DimensionStructuresSettings dimensionSettings = noiseSettings.getValue().structureSettings();
			Reflections.addStructureSetting(dimensionSettings, structure);
		});
	}
	
}