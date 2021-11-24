package net.luis.nero.event.registery;

import net.luis.nero.Nero;
import net.luis.nero.client.model.BloodAltarModel;
import net.luis.nero.client.model.HoveringInfernoModel;
import net.luis.nero.client.model.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnRegisterLayerDefinitionsEvent {
	
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModModelLayers.HOVERING_INFERNO, () -> HoveringInfernoModel.createLayerDefinition());
		event.registerLayerDefinition(ModModelLayers.BLOOD, () -> BloodAltarModel.createLayerDefinition());
	}

}

