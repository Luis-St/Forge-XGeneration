package net.luis.industry.common.world.carver;

import java.util.Random;
import java.util.Set;

import net.luis.industry.init.block.ModBlocks;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ModTestCave extends CaveWorldCarver {

	public ModTestCave(int maxGenerationHight) {
		super(ProbabilityConfig.CODEC, maxGenerationHight);
		this.replaceableBlocks = Set.of(ModBlocks.DEEPSLATE.get(), ModBlocks.DEEPSLATE_COAL_ORE.get(),
				ModBlocks.DEEPSLATE_COPPER_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get(),
				ModBlocks.DEEPSLATE_GOLD_ORE.get(), ModBlocks.DEEPSLATE_LAPIS_ORE.get(),
				ModBlocks.DEEPSLATE_REDSTONE_ORE.get(), ModBlocks.DEEPSLATE_DIAMOND_ORE.get(),
				ModBlocks.DEEPSLATE_EMERALD_ORE.get());
	}
	
	/**
	 * cave generation length
	 * @default 4
	 */
	@Override
	public int getRange() {
		return super.getRange();
	}
	
	/**
	 * cave generation count
	 * @default 15
	 */
	@Override
	protected int getCaveBound() {
		return super.getCaveBound();
	}
	
	/**
	 * cave diameter
	 * @default 1 - 10
	 */
	@Override
	protected float getThickness(Random rng) {
		return super.getThickness(rng);
	}
	
	/**
	 * y cave size scale (the height of the cave)
	 * @default 1
	 */
	@Override
	protected double getYScale() {
		return super.getYScale();
	}
	
	/**
	 * y hight of the cave generation
	 * @default 0 - 128
	 */
	@Override
	protected int getCaveY(Random rng) {
		return super.getCaveY(rng);
	}

}
