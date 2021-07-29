package net.luis.nero.event.entity.living.player.tick;

import net.luis.nero.Nero;
import net.luis.nero.common.block.DriftSandBlock;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID, value = Dist.CLIENT)
public class OnPlayerClientTickEvent {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == Phase.START && event.side == LogicalSide.CLIENT) {
			LocalPlayer localPlayer = (LocalPlayer) event.player;
			ClientLevel clientLevel = (ClientLevel) localPlayer.getCommandSenderWorld();
			BlockPos pos = new BlockPos(localPlayer.getX(), localPlayer.getY(), localPlayer.getZ());
			if (clientLevel.getBlockState(pos).getBlock() instanceof DriftSandBlock) {
				if (!localPlayer.isSpectator()) {
					localPlayer.setDeltaMovement(0, -0.1, 0);
				}
			}
		}
	}

}
