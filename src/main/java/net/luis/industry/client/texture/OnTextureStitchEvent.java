package net.luis.industry.client.texture;

import static net.luis.industry.Industry.MOD_ID;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OnTextureStitchEvent {

	@SubscribeEvent
	public static void TextureStitch(TextureStitchEvent.Pre event) {
		event.addSprite(new ResourceLocation(MOD_ID, "entity/mile"));
	}

}