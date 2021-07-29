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
			LocalPlayer player = (LocalPlayer) event.player;
			ClientLevel world = (ClientLevel) player.getCommandSenderWorld();
			BlockPos pos = new BlockPos(player.getX(), player.getY(), player.getZ());
			if (world.getBlockState(pos).getBlock() instanceof DriftSandBlock) {
				if (!player.isSpectator()) {
					player.setDeltaMovement(0, -0.1, 0);
				}
			}
		}
	}

}
