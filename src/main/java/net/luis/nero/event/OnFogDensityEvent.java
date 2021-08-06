package net.luis.nero.event;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.client.Camera;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID, value = Dist.CLIENT)
public class OnFogDensityEvent {

	@SubscribeEvent
	public static void fogDensity(EntityViewRenderEvent.FogDensity event) {
		Nero.LOGGER.debug("FogDensity");
		Camera camera = event.getInfo();
		if (camera.getBlockAtCamera().getBlock() == ModBlocks.DRIFT_SAND.get()) {
			Nero.LOGGER.debug("fogDensity in DriftSand");
		}
	}

}
