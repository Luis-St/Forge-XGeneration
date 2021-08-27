package net.luis.nero.event.entity;

import net.luis.nero.Nero;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.luis.nero.common.entity.ModVillagerEntity;
import net.luis.nero.common.entity.SoulBlazeEntity;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD)
public class OnEntityAttributeCreationEvent {
	
	@SubscribeEvent
	public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.SOUL_BLAZE.get(), SoulBlazeEntity.registerAttributes());
		event.put(ModEntityTypes.HOVERING_INFERNO.get(), HoveringInfernoEntity.registerAttributes());
		event.put(ModEntityTypes.VILLAGER.get(), ModVillagerEntity.registerAttributes());
	}

}
