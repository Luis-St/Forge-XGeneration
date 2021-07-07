package net.luis.nero.event.entity.living;

import net.luis.nero.Nero;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnLivingJumpEvent {

	@SubscribeEvent
	public static void livingJump(LivingEvent.LivingJumpEvent event) {
		
	}

}

