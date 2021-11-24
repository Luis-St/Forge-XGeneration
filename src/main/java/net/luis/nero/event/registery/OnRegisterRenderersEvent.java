package net.luis.nero.event.registery;

import net.luis.nero.Nero;
import net.luis.nero.client.render.blockentity.BloodAltarBlockEntityRenderer;
import net.luis.nero.client.render.entity.HoveringInfernoEntityRenderer;
import net.luis.nero.client.render.entity.SoulBlazeEntityRenderer;
import net.luis.nero.client.render.entity.SoulFireballEntityRenderer;
import net.luis.nero.init.block.util.ModBlockEntityTypes;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnRegisterRenderersEvent {
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntityTypes.SOUL_BLAZE.get(), SoulBlazeEntityRenderer::new);
		event.registerEntityRenderer(ModEntityTypes.SOUL_FIREBALL.get(), SoulFireballEntityRenderer::new);
		event.registerEntityRenderer(ModEntityTypes.HOVERING_INFERNO.get(), HoveringInfernoEntityRenderer::new);
		event.registerEntityRenderer(ModEntityTypes.VILLAGER.get(), VillagerRenderer::new);
		event.registerBlockEntityRenderer(ModBlockEntityTypes.BLOOD_ALTAR.get(), BloodAltarBlockEntityRenderer::new);
//		event.registerBlockEntityRenderer(ModBlockEntityTypes.MILESTONE.get(), MilestoneBlockEntityRenderer::new);
	}

}
