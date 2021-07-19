package net.luis.nero.event.entity.living.player.tick;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.block.AirBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnPlayerTickEvent {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == Phase.START) {
			PlayerEntity player = event.player;
			if (player.hasEffect(ModEffects.BRIDGE.get()) && player instanceof ServerPlayerEntity && !player.isShiftKeyDown()) {
				World world = player.getCommandSenderWorld();
				BlockPos pos = new BlockPos(player.getX(), player.getY() - 1, player.getZ());
				if (world.getBlockState(pos).getBlock() instanceof AirBlock) {
					world.setBlock(pos, ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.north()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.north(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.east()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.east(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.south()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.south(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.west()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.west(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.north(2)).getBlock() instanceof AirBlock) {
					world.setBlock(pos.north(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.east(2)).getBlock() instanceof AirBlock) {
					world.setBlock(pos.east(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.south(2)).getBlock() instanceof AirBlock) {
					world.setBlock(pos.south(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.west(2)).getBlock() instanceof AirBlock) {
					world.setBlock(pos.west(2), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.north().east()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.north().east(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.east().south()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.east().south(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.south().west()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.south().west(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
				if (world.getBlockState(pos.west().north()).getBlock() instanceof AirBlock) {
					world.setBlock(pos.west().north(), ModBlocks.BRIDGE_BLOCK.get().defaultBlockState(), 3);
				}
			}
		}
	}

}
