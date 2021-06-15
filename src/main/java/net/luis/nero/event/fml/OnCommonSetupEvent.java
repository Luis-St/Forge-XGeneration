package net.luis.nero.event.fml;

import net.luis.nero.Nero;
import net.luis.nero.api.capability.CapabilityFactory;
import net.luis.nero.api.capability.CapabilityStorage;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.common.world.biome.DeepslateBiomeProvider;
import net.luis.nero.common.world.gen.DeepslateChunkGenerator;
import net.luis.nero.core.NetworkHandler;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
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
		registerStructure(ModStructures.DEEPSLATE_PORTAL.get(), new StructureSeparationSettings(10, 4, 456734349));
	}
	
	// TODO: later if needed add transformSurroundingLand -> https://github.com/TelepathicGrunt/StructureTutorialMod
	private static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings settings) {
		Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
	}
	
}