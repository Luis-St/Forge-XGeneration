package net.luis.nero.event.world;

import net.luis.nero.Nero;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnSleepFinishedTimeEvent {

	@SubscribeEvent
	public static void worldLoad(SleepFinishedTimeEvent event) {
		
	}
	
}
