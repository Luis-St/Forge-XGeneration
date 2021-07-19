package net.luis.nero.event.entity.living.player.tick;

import net.luis.nero.Nero;
import net.luis.nero.common.block.DriftSandBlock;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
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
			ClientPlayerEntity player = (ClientPlayerEntity) event.player;
			ClientWorld world = (ClientWorld) player.getCommandSenderWorld();
			BlockPos pos = new BlockPos(player.getX(), player.getY(), player.getZ());
			if (world.getBlockState(pos).getBlock() instanceof DriftSandBlock) {
				if (!player.isCreative() && !player.isSpectator()) { // TODO: isCreative only in dev
					player.setDeltaMovement(0, -0.1, 0);
				}
			}
		}
	}

}
