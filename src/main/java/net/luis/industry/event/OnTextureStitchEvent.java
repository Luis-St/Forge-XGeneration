package net.luis.industry.event;

import net.luis.industry.Industry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= Industry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OnTextureStitchEvent {

	@SubscribeEvent
	public static void TextureStitch(TextureStitchEvent.Pre event) {
		event.addSprite(new ResourceLocation(Industry.MOD_ID, "entity/mile"));
	}

}