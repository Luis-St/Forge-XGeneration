package net.luis.nero.event.world;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnWorldLoadEvent {

	@SubscribeEvent
	public static void worldLoad(WorldEvent.Load event) {
//		if (event.getWorld() instanceof ServerWorld) {
//			ServerWorld world = (ServerWorld) event.getWorld();
//			if (world.getChunkSource().getGenerator() instanceof FlatChunkGenerator) {
//				return;
//			}
//			if (!world.dimension().equals(ModDimensions.DEEPSLATE_WORLD)) {
//				return;
//			}
//			Map<Structure<?>, StructureSeparationSettings> structureSettings = 
//					new HashMap<>(world.getChunkSource().getGenerator().getSettings().structureConfig());
//			structureSettings.putIfAbsent(ModStructures.DEEPSLATE_MINESHAFT.get(),
//					DimensionStructuresSettings.DEFAULTS.get(ModStructures.DEEPSLATE_MINESHAFT.get()));
//			world.getChunkSource().getGenerator().getSettings().structureConfig = structureSettings;
//		}
	}

}
