package net.luis.nero.data;

import net.luis.nero.Nero;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
	@SubscribeEvent
	@SuppressWarnings("unused")
	public static void gatherData(GatherDataEvent event) {
		Nero.LOGGER.info("Generate Mod Data");
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			
		}
		if (event.includeClient()) {
			
		}
	}
	
}
