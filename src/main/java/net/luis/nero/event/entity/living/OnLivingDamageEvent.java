package net.luis.nero.event.entity.living;

import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnLivingDamageEvent {

	@SubscribeEvent
	public static void livingDamage(LivingDamageEvent event) {
		
	}

}
