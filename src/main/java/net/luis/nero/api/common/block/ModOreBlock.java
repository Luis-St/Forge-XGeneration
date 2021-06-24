package net.luis.nero.api.common.block;

import java.util.Random;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigIntegerValue;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

@Config
public class ModOreBlock extends OreBlock {
	
	@ConfigIntegerValue(value = 0) 
	private static ConfigValue<Integer> DEEPSLATE_COAL_XP_MIN;
	@ConfigIntegerValue(value = 4) 
	private static ConfigValue<Integer> DEEPSLATE_COAL_XP_MAX;

	@ConfigIntegerValue(value = 3) 
	private static ConfigValue<Integer> DEEPSLATE_LAPIS_XP_MIN;
	@ConfigIntegerValue(value = 6) 
	private static ConfigValue<Integer> DEEPSLATE_LAPIS_XP_MAX;

	@ConfigIntegerValue(value = 4) 
	private static ConfigValue<Integer> DEEPSLATE_DIAMOND_XP_MIN;
	@ConfigIntegerValue(value = 8) 
	private static ConfigValue<Integer> DEEPSLATE_DIAMOND_XP_MAX;

	@ConfigIntegerValue(value = 4) 
	private static ConfigValue<Integer> DEEPSLATE_EMERALD_XP_MIN;
	@ConfigIntegerValue(value = 8) 
	private static ConfigValue<Integer> DEEPSLATE_EMERALD_XP_MAX;
	
	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rng) {
		if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
			return MathHelper.nextInt(rng, DEEPSLATE_COAL_XP_MIN.get(), DEEPSLATE_COAL_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
			return MathHelper.nextInt(rng, DEEPSLATE_LAPIS_XP_MIN.get(), DEEPSLATE_LAPIS_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
			return MathHelper.nextInt(rng, DEEPSLATE_DIAMOND_XP_MIN.get(), DEEPSLATE_DIAMOND_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
			return MathHelper.nextInt(rng, DEEPSLATE_EMERALD_XP_MIN.get(), DEEPSLATE_EMERALD_XP_MAX.get());
		}
		return super.xpOnDrop(rng);
	}

}
