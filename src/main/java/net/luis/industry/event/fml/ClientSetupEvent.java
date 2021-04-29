package net.luis.industry.event.fml;


import static net.luis.industry.Industry.MOD_ID;
import static net.minecraftforge.api.distmarker.Dist.CLIENT;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.luis.industry.client.render.tileentity.MilestoneTileEntityRenderer;
import net.luis.industry.init.block.util.ModTileEntityTypes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = MOD_ID, bus = MOD, value = CLIENT)
public class ClientSetupEvent {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MILESTONE.get(), MilestoneTileEntityRenderer::new);
		
	}

}
