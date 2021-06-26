package net.luis.nero.event.world;

import net.luis.nero.api.common.util.Reflections;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnWorldLoadEvent {

	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void worldLoad(WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) event.getWorld();
			Reflections.addStructureSetting(serverWorld.getChunkSource().generator.getSettings(), ModStructures.DEEPSLATE_MINESHAFT.get());
		}
	}
	
}
