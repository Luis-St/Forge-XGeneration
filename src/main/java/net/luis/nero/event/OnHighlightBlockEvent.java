package net.luis.nero.event;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.DrawSelectionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID, value = Dist.CLIENT)
public class OnHighlightBlockEvent {
	
	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void highlightBloc(DrawSelectionEvent.HighlightBlock event) {
		LocalPlayer localPlayer = Minecraft.getInstance().player;
		BlockPos targetPos = event.getTarget().getBlockPos();
		BlockPos headPos = localPlayer.eyeBlockPosition();
		if (Minecraft.getInstance().level.getBlockState(targetPos).getBlock() == ModBlocks.BRIDGE_BLOCK.get()) {
			event.setCanceled(true);
		} else if (Minecraft.getInstance().level.getBlockState(headPos).getBlock() == ModBlocks.DRIFT_SAND.get()) {
			event.setCanceled(true);
		} else if (Minecraft.getInstance().level.getBlockState(headPos).getBlock() == Blocks.POWDER_SNOW) {
			event.setCanceled(true);
		}
	}
}
