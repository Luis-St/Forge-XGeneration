package net.luis.nero.event.input;

import net.luis.nero.Nero;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID, value = Dist.CLIENT)
public class OnClientTickEvent {

	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event) {
		if (event.phase == Phase.START) {
			
		}
	}

}
