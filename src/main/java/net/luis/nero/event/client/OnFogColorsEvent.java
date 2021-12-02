package net.luis.nero.event.client;

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
		Camera camera = event.getCamera();
		if (camera.getBlockAtCamera().getBlock() == ModBlocks.DRIFT_SAND.get()) {
			event.setRed(0.87843F);
			event.setGreen(0.74117F);
			event.setBlue(0.48235F);
		}
	}

}
