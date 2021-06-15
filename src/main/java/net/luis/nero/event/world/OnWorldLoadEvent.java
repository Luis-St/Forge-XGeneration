package net.luis.nero.event.world;

import java.util.HashMap;
import java.util.Map;

import net.luis.nero.init.world.structure.ModStructures;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@EventBusSubscriber
public class OnWorldLoadEvent {

	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void worldLoad(WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) event.getWorld();
			DimensionStructuresSettings structuresSettings = serverWorld.getChunkSource().generator.getSettings();
			Map<Structure<?>, StructureSeparationSettings> structureMap = new HashMap<>(structuresSettings.structureConfig());
			structureMap.putIfAbsent(ModStructures.DEEPSLATE_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(ModStructures.DEEPSLATE_PORTAL.get()));
			ObfuscationReflectionHelper.setPrivateValue(DimensionStructuresSettings.class, structuresSettings, structureMap, "field_236193_d_");
		}
	}

}
