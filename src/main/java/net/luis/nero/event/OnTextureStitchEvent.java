package net.luis.nero.event;

import net.luis.nero.Nero;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OnTextureStitchEvent {

	@SubscribeEvent
	public static void textureStitch(TextureStitchEvent.Pre event) {
		event.addSprite(new ResourceLocation(Nero.MOD_ID, "entity/mile"));
		event.addSprite(new ResourceLocation(Nero.MOD_ID, "entity/blood"));
	}

}