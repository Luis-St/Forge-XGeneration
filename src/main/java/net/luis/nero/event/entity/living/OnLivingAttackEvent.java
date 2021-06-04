package net.luis.nero.event.entity.living;

import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnLivingAttackEvent {

	@SubscribeEvent
	public static void livingAttack(LivingAttackEvent event) {
		
	}

}

