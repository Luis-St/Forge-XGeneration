package net.luis.nero.api.common.block;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

@Config
public class ModOreBlock extends OreBlock {
	
	@ConfigValue
	private static Integer DEEPSLATE_COAL_XP_MIN = 0;
	@ConfigValue
	private static Integer DEEPSLATE_COAL_XP_MAX = 4;
	
	@ConfigValue
	private static Integer DEEPSLATE_LAPIS_XP_MIN = 3;
	@ConfigValue
	private static  Integer DEEPSLATE_LAPIS_XP_MAX = 6;
	
	@ConfigValue
	public static Integer DEEPSLATE_REDSTONE_XP_MIN = 1;
	@ConfigValue
	public static Integer DEEPSLATE_REDSTONE_XP_MAX = 6;
	
	@ConfigValue 
	private static Integer DEEPSLATE_DIAMOND_XP_MIN = 4;
	@ConfigValue
	private static Integer DEEPSLATE_DIAMOND_XP_MAX = 8;
	
	@ConfigValue
	private static Integer DEEPSLATE_EMERALD_XP_MIN = 4;
	@ConfigValue
	private static Integer DEEPSLATE_EMERALD_XP_MAX = 8;
	
	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getExpDrop(BlockState state, LevelReader levelReader, BlockPos pos, int fortune, int silkTouch) {
		if (silkTouch == 0) {
			if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
				return Mth.nextInt(RANDOM, DEEPSLATE_COAL_XP_MIN, DEEPSLATE_COAL_XP_MAX);
			} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
				return Mth.nextInt(RANDOM, DEEPSLATE_LAPIS_XP_MIN, DEEPSLATE_LAPIS_XP_MAX);
			} else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
				return Mth.nextInt(RANDOM, DEEPSLATE_DIAMOND_XP_MIN, DEEPSLATE_DIAMOND_XP_MAX);
			} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
				return Mth.nextInt(RANDOM, DEEPSLATE_EMERALD_XP_MIN, DEEPSLATE_EMERALD_XP_MAX);
			}
		}
		return 0;
	}
	
}
