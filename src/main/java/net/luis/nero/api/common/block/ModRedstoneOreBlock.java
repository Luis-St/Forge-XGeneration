package net.luis.nero.api.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class ModRedstoneOreBlock extends RedstoneOreBlock {
	
	public ModRedstoneOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? MathHelper.nextInt(RANDOM, ModOreBlock.DEEPSLATE_REDSTONE_XP_MIN, ModOreBlock.DEEPSLATE_REDSTONE_XP_MAX) : 0;
	}
	
}
