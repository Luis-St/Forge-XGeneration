package net.luis.nero.event.entity.living.player;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnPlayerTickEvent {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		
	}

}
