package net.luis.nero.api.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModRedstoneOreBlock extends RedStoneOreBlock {
	
	public ModRedstoneOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? Mth.nextInt(RANDOM, ModOreBlock.DEEPSLATE_REDSTONE_XP_MIN, ModOreBlock.DEEPSLATE_REDSTONE_XP_MAX) : 0;
	}
	
}
