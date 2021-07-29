package net.luis.nero.event.world;

import net.luis.nero.Nero;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

//TODO: fix
@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnWorldLoadEvent {

	@SubscribeEvent
	public static void worldLoad(WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerLevel) {
//			ServerLevel serverWorld = (ServerLevel) event.getWorld();
//			Reflections.addStructureSetting(serverWorld.getChunkSource().generator.getSettings(), ModStructures.DEEPSLATE_MINESHAFT.get());
		}
	}
	
}
