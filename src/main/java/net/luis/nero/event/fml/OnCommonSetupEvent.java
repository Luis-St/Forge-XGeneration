package net.luis.nero.event.fml;

import net.luis.nero.Nero;
import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.common.util.Reflections;
import net.luis.nero.common.world.biome.DeepslateBiomeSource;
import net.luis.nero.common.world.gen.DeepslateChunkGenerator;
import net.luis.nero.common.world.test.TestBiomeSource;
import net.luis.nero.common.world.test.TestChunkGenerator;
import net.luis.nero.core.NetworkHandler;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
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
		CapabilityManager.INSTANCE.register(IBloodOrbCapability.class);
	}
	
	protected static void registerBiome(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE, Type.MODIFIED);
	}
	
	protected static void registerUtil(FMLCommonSetupEvent event) {
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "deepslate_chunk_generator"), DeepslateChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "deepslate_biome_provider"), DeepslateBiomeSource.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "test_chunk_generator"), TestChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "test_biomes"), TestBiomeSource.CODEC);
/*		Map<ResourceLocation, DimensionRenderInfo> renderInfos = new HashMap<>(); // TODO: try 
		renderInfos.put(ModDimensionTypes.DEEPSLATE.location(), ModDimensionRenderInfo.DEEPSLATE);
		Reflections.addDimensionRenderInfos(renderInfos);*/
	}
	
	protected static void registerStructure(FMLCommonSetupEvent event) {
		registerStructure(ModStructures.DEEPSLATE_MINESHAFT.get(), new StructureFeatureConfiguration(4, 1, 456734349), false);
	}
	
	// TODO: fix
	private static <F extends StructureFeature<?>> void registerStructure(F structure, StructureFeatureConfiguration structureConfig, boolean transformLand) {
		StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
		Reflections.addDefaultStructure(structure, structureConfig);
		if (transformLand) {
			Reflections.addNoiseStructure(structure);
		}
		BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(noiseSettings -> {
			StructureSettings structureSettings = noiseSettings.getValue().structureSettings();
			Reflections.addStructureSetting(structureSettings, structure);
		});
	}
	
}