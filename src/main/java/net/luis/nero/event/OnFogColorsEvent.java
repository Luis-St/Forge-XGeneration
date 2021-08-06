package net.luis.nero.event;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.client.Camera;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class OnFogColorsEvent {

	@SubscribeEvent
	public static void fogColors(EntityViewRenderEvent.FogColors event) {
		Nero.LOGGER.debug("FogColors");
		Camera camera = event.getInfo();
		if (camera.getBlockAtCamera().getBlock() == ModBlocks.DRIFT_SAND.get()) {
			Nero.LOGGER.debug("fogColors in DriftSand");
		}
	}

}
