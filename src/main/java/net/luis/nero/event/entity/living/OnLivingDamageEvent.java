package net.luis.nero.event.entity.living;

import net.luis.nero.Nero;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnLivingDamageEvent {

	@SubscribeEvent
	public static void livingDamage(LivingDamageEvent event) {
		
	}

}
