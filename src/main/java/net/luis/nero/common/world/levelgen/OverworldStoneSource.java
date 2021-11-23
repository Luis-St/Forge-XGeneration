package net.luis.nero.common.world.levelgen;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.BaseStoneSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;

public class OverworldStoneSource implements BaseStoneSource {
	
	protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
	protected static final BlockState DEEPSLATE = Blocks.DEEPSLATE.defaultBlockState();
	
	protected final WorldgenRandom rng;
	
	public OverworldStoneSource(long seed) {
		this.rng = new WorldgenRandom(seed);
	}
	
	@Override
	public BlockState getBaseBlock(int x, int y, int z) {
		if (165 > y) {
			return DEEPSLATE;
		} else if (y > 175) {
			return STONE;
		} else {
			if ((this.rng.nextInt(10) + 165) >= y) {
				return DEEPSLATE;
			}
			return STONE;
		}
	}
	
}
