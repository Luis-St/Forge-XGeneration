package net.luis.nero.event.world;

import net.luis.nero.Nero;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.StructureSettings;
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
//			serverLevel.getChunkSource().generator.getSettings().structureConfig.putIfAbsent(StructureSettings.DEFAULTS.get(ModStructures.DEEPSLATE_MINESHAFT.get()), ModStructures.DEEPSLATE_MINESHAFT.get());
			serverLevel.getChunkSource().generator.getSettings().structureConfig = StructureSettings.DEFAULTS;
//			Reflections.addStructureSetting(serverLevel.getChunkSource().generator.getSettings(), ModStructures.DEEPSLATE_MINESHAFT.get());
		}
	}
	
}
