package net.luis.nero.api.block;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock {

	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rng) {
		if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
			return MathHelper.nextInt(rng, 0, 4);
		} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
			return MathHelper.nextInt(rng, 3, 6);
		}else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
			return MathHelper.nextInt(rng, 4, 8);
		} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
			return MathHelper.nextInt(rng, 4, 8);
		} else {
			return super.xpOnDrop(rng);
		}
	}

}
