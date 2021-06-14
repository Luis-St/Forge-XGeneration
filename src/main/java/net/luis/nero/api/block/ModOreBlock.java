package net.luis.nero.api.block;

import java.util.Random;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigIntegerValue;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

@Config
public class ModOreBlock extends OreBlock {
	
	@ConfigIntegerValue(name = "deepslateCoalOreXpMin", value = 0) 
	private static ConfigValue<Integer> COAL_XP_MIN;
	@ConfigIntegerValue(name = "deepslateCoalOreXpMax", value = 4) 
	private static ConfigValue<Integer> COAL_XP_MAX;

	@ConfigIntegerValue(name = "deepslateLapisOreXpMin", value = 3) 
	private static ConfigValue<Integer> LAPIS_XP_MIN;
	@ConfigIntegerValue(name = "deepslateLapisOreXpMax", value = 6) 
	private static ConfigValue<Integer> LAPIS_XP_MAX;

	@ConfigIntegerValue(name = "deepslateDiamondOreXpMin", value = 4) 
	private static ConfigValue<Integer> DIAMOND_XP_MIN;
	@ConfigIntegerValue(name = "deepslateDiamondOreXpMax", value = 8) 
	private static ConfigValue<Integer> DIAMOND_XP_MAX;

	@ConfigIntegerValue(name = "deepslateEmeraldOreXpMin", value = 4) 
	private static ConfigValue<Integer> EMERALD_XP_MIN;
	@ConfigIntegerValue(name = "deepslateEmeraldOreXpMax", value = 8) 
	private static ConfigValue<Integer> EMERALD_XP_MAX;
	
	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rng) {
		if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
			return MathHelper.nextInt(rng, COAL_XP_MIN.get(), COAL_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
			return MathHelper.nextInt(rng, LAPIS_XP_MIN.get(), LAPIS_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
			return MathHelper.nextInt(rng, DIAMOND_XP_MIN.get(), DIAMOND_XP_MAX.get());
		} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
			return MathHelper.nextInt(rng, EMERALD_XP_MIN.get(), EMERALD_XP_MAX.get());
		}
		return super.xpOnDrop(rng);
	}

}
