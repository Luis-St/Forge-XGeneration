package net.luis.nero.event.entity;

import net.luis.nero.common.entity.SoulBlazeEntity;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD)
public class OnEntityAttributeCreationEvent {
	
	@SubscribeEvent
	public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.SOUL_BLAZE.get(), SoulBlazeEntity.registerAttributes());
	}

}