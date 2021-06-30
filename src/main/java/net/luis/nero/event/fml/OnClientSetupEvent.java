package net.luis.nero.event.fml;


import net.luis.nero.client.render.entity.HoveringInfernoEntityRenderer;
import net.luis.nero.client.render.entity.SoulBlazeEntityRenderer;
import net.luis.nero.client.render.entity.SoulFireballEntityRenderer;
import net.luis.nero.client.render.tileentity.BloodAltarTileEntityRenderer;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		registerEntityRenderer(event);
		registerTileEntityRenderer(event);
		registerBlockRenderType(event);
	}
	
	protected static void registerTileEntityRenderer(FMLClientSetupEvent event) {
//		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MILESTONE.get(), MilestoneTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.BLOOD_ALTAR.get(), BloodAltarTileEntityRenderer::new);
	}
	
	protected static void registerEntityRenderer(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SOUL_BLAZE.get(), SoulBlazeEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SOUL_FIREBALL.get(), SoulFireballEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HOVERING_INFERNO.get(), HoveringInfernoEntityRenderer::new);
	}
	
	protected static void registerBlockRenderType(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ModBlocks.BRIDGE_BLOCK.get(), RenderType.translucent());
	}

}
