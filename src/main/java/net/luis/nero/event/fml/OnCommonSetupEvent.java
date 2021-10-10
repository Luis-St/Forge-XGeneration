package net.luis.nero.event.fml;

import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.DeepslateBiomeSource;
import net.luis.nero.common.world.biome.OverworldBiomeSource;
import net.luis.nero.common.world.levelgen.DeepslateChunkGenerator;
import net.luis.nero.common.world.levelgen.OverworldChunkGenerator;
import net.luis.nero.common.world.test.TestBiomeSource;
import net.luis.nero.common.world.test.TestChunkGenerator;
import net.luis.nero.core.NetworkHandler;
import net.luis.nero.init.entity.ModEntityTypes;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.levelgen.feature.structure.ModStructures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
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
		registerEntitySpawnPlacements(event);
		registerStructure(event);
		registerUtil(event);
	}
	
	protected static void registerNetwork(FMLCommonSetupEvent event) {
		NetworkHandler.init();
	}
	
	protected static void registerBiome(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE, Type.MODIFIED);
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE_OCEAN, Type.MODIFIED);
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE_LAVA_LAKE, Type.MODIFIED);
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE_DEEPDARK, Type.MODIFIED);
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE_LUSH_CAVES, Type.MODIFIED);
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE_DRIPSTONE_CAVE, Type.MODIFIED);
	}
	
	protected static void registerEntitySpawnPlacements(FMLCommonSetupEvent event) {
		SpawnPlacements.register(ModEntityTypes.SOUL_BLAZE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,  Monster::checkAnyLightMonsterSpawnRules);
		SpawnPlacements.register(ModEntityTypes.HOVERING_INFERNO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,  Monster::checkAnyLightMonsterSpawnRules);
	}
	
	protected static void registerStructure(FMLCommonSetupEvent event) {
		registerStructure(ModStructures.DEEPSLATE_MINESHAFT.get(), new StructureFeatureConfiguration(4, 1, 456734349), false);
	}
	
	protected static void registerUtil(FMLCommonSetupEvent event) {
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "deepslate_chunk_generator"), DeepslateChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "deepslate_biome_source"), DeepslateBiomeSource.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "overworld_chunk_generator"), OverworldChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "overworld_biome_source"), OverworldBiomeSource.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "test_chunk_generator"), TestChunkGenerator.CODEC);
		Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "test_biome_source"), TestBiomeSource.CODEC);
	}
	
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