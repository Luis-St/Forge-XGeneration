package net.luis.nero.event;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class OnFogDensityEvent {

	@SubscribeEvent
	public static void fogDensity(EntityViewRenderEvent.FogDensity event) {
		Minecraft minecraft = Minecraft.getInstance();
		Camera camera = event.getInfo();
		if (camera.getBlockAtCamera().getBlock() == ModBlocks.DRIFT_SAND.get()) {
			event.setCanceled(true);
			if (minecraft.player.isSpectator()) {
				event.setDensity(30.0F);
			} else {
				event.setDensity(7.5F);
			}
		}
	}

} 
