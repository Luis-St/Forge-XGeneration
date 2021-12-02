package net.luis.nero.event.fml;

import net.luis.nero.Nero;
import net.luis.nero.client.world.ModDimensionSpecialEffects;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.world.ModWorldTypes;
import net.luis.nero.init.world.dimension.ModDimensionTypes;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeWorldPresetScreens;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		registerBlockRenderType(event);
		registerUtil(event);
		registerWorldTypes(event);
	}
	
	protected static void registerBlockRenderType(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRIDGE_BLOCK.get(), RenderType.translucent());
	}
	
	protected static void registerUtil(FMLClientSetupEvent event) {
		DimensionSpecialEffects.EFFECTS.defaultReturnValue(ModDimensionSpecialEffects.OVERWORLD);
		DimensionSpecialEffects.EFFECTS.put(ModDimensionTypes.OVERWORLD.location(), ModDimensionSpecialEffects.OVERWORLD);
		DimensionSpecialEffects.EFFECTS.put(ModDimensionTypes.DEEPSLATE.location(), ModDimensionSpecialEffects.DEEPSLATE);
	}
	
	protected static void registerWorldTypes(FMLClientSetupEvent event) {
		ForgeWorldPresetScreens.registerPresetEditor(ModWorldTypes.NERO_OVWERWORLD.get(), (worldScreen, worldGenSettings) -> new Screen(ModWorldTypes.NERO_OVWERWORLD.get().getDisplayName()) {
			@Override
			protected void init() {
				super.init();
				this.addRenderableWidget(new Button(0, 0, 120, 20, new TextComponent("close"), action -> {
					this.getMinecraft().setScreen(worldScreen);
				}));
			};
		});
	}

}
