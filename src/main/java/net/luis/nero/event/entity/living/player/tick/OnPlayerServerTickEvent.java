package net.luis.nero.event.entity.living.player.tick;

import net.luis.nero.Nero;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID, value = Dist.DEDICATED_SERVER)
public class OnPlayerServerTickEvent {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		
	}

}
