package net.luis.nero.event.entity.living;

import net.luis.nero.Nero;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnLivingHurtEvent {

	@SubscribeEvent
	public static void livingHurt(LivingHurtEvent event) {
		Nero.LOGGER.debug("LivingHurtEvent");
	}

}
