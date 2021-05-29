package net.luis.nero.event.fml;


import net.luis.nero.client.render.tileentity.BloodAltarTileEntityRenderer;
import net.luis.nero.client.render.tileentity.MilestoneTileEntityRenderer;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvent {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MILESTONE.get(), MilestoneTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.BLOOD_ALTAR.get(), BloodAltarTileEntityRenderer::new);
	}

}
