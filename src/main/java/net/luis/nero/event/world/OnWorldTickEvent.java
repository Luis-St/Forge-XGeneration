package net.luis.nero.event.world;

import net.luis.nero.Nero;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnWorldTickEvent {

	@SubscribeEvent
	public static void worldLoad(TickEvent.WorldTickEvent event) {
		
	}
	
}
