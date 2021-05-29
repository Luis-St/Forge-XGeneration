package net.luis.nero.event.overlay;

import java.util.Locale;

import net.luis.nero.common.world.dimension.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class OnRenderGameOverlayEvent {
	
	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void renderGameOverlay(RenderGameOverlayEvent.Text event) {
		if (event.getLeft() != null && !event.getLeft().isEmpty()) {
			ClientPlayerEntity player = Minecraft.getInstance().player;
			ClientWorld world = player.clientLevel;
			double x = Math.round(player.getX() * 1000);
			double y = Math.round(player.getY() * 100000);
			double z = Math.round(player.getZ() * 1000);
			if (world.dimension().equals(ModDimensions.DEEPSLATE_WORLD)) {
				double roundX = x / 1000;
				double roundY = (y / 100000) - 255;
				double roundZ = z / 1000;
				event.getLeft().set(10, String.format(Locale.ROOT, "XYZ: %.3f / %.5f / %.3f", roundX, roundY, roundZ));
			}
		}
	}

}
