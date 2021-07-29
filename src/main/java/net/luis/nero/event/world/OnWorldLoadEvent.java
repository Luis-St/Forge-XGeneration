package net.luis.nero.event.world;

import net.luis.nero.Nero;
import net.luis.nero.api.common.util.Reflections;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnWorldLoadEvent {

	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void worldLoad(WorldEvent.Load event) {
		Nero.LOGGER.debug("gfdgjhfgsdjfgjsdgfdsjfgsdjsfdgjsdsgdgsd"); // no idea
		if (event.getWorld() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) event.getWorld();
			Reflections.addStructureSetting(serverLevel.getChunkSource().generator.getSettings(), ModStructures.DEEPSLATE_MINESHAFT.get());
		}
	}
	
}
