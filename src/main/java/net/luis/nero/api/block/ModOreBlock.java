package net.luis.nero.api.block;

import java.util.Random;

import net.luis.nero.config.deprecated.ModCommonConfig;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.OreBlock;

public class ModOreBlock extends OreBlock {

	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rng) {
		if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
			return ModCommonConfig.getDeepslateCoalXp(rng);
		} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
			return ModCommonConfig.getDeepslateLapisXp(rng);
		}else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
			return ModCommonConfig.getDeepslateDiamondXp(rng);
		} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
			return ModCommonConfig.getDeepslateEmeraldXp(rng);
		} else {
			return super.xpOnDrop(rng);
		}
	}

}
