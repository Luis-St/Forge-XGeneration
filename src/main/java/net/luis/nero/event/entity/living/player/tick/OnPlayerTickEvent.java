package net.luis.nero.event.entity.living.player.tick;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnPlayerTickEvent {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == Phase.START) {
			Player player = event.player;
			if (player.hasEffect(ModEffects.BRIDGE.get()) && player instanceof ServerPlayer && !player.isShiftKeyDown()) {
				Level level = player.getCommandSenderWorld();
				BlockPos pos = new BlockPos(player.getX(), player.getY() - 1, player.getZ());
				if (level.getBlockState(pos).getBlock() instanceof AirBlock) {
					level.setBlock(pos, ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.north()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.north(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.east()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.east(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.south()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.south(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.west()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.west(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.north(2)).getBlock() instanceof AirBlock) {
					level.setBlock(pos.north(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.east(2)).getBlock() instanceof AirBlock) {
					level.setBlock(pos.east(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.south(2)).getBlock() instanceof AirBlock) {
					level.setBlock(pos.south(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.west(2)).getBlock() instanceof AirBlock) {
					level.setBlock(pos.west(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.north().east()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.north().east(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.east().south()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.east().south(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.south().west()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.south().west(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (level.getBlockState(pos.west().north()).getBlock() instanceof AirBlock) {
					level.setBlock(pos.west().north(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
			}
		}
	}

}
