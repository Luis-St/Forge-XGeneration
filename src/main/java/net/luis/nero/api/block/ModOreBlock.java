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
	
	@ConfigIntegerValue(name = "deepslateCoalOreXpMin", value = 0) private ConfigValue<Integer> coalXpMin;
	@ConfigIntegerValue(name = "deepslateCoalOreXpMax", value = 4) private ConfigValue<Integer> coalXpMax;

	@ConfigIntegerValue(name = "deepslateLapisOreXpMin", value = 3) private ConfigValue<Integer> lapisXpMin;
	@ConfigIntegerValue(name = "deepslateLapisOreXpMax", value = 6) private ConfigValue<Integer> lapisXpMax;

	@ConfigIntegerValue(name = "deepslateDiamondOreXpMin", value = 4) private ConfigValue<Integer> diamondXpMin;
	@ConfigIntegerValue(name = "deepslateDiamondOreXpMax", value = 8) private ConfigValue<Integer> diamondXpMax;

	@ConfigIntegerValue(name = "deepslateEmeraldOreXpMin", value = 4) private ConfigValue<Integer> emeraldXpMin;
	@ConfigIntegerValue(name = "deepslateEmeraldOreXpMax", value = 8) private ConfigValue<Integer> emeraldXpMax;
	
	public ModOreBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected int xpOnDrop(Random rng) {
		if (this == ModBlocks.DEEPSLATE_COAL_ORE.get()) {
			return MathHelper.nextInt(rng, this.coalXpMin.get(), this.coalXpMax.get());
		} else if (this == ModBlocks.DEEPSLATE_LAPIS_ORE.get()) {
			return MathHelper.nextInt(rng, this.lapisXpMin.get(), this.lapisXpMax.get());
		} else if (this == ModBlocks.DEEPSLATE_DIAMOND_ORE.get()) {
			return MathHelper.nextInt(rng, this.diamondXpMin.get(), this.diamondXpMax.get());
		} else if (this == ModBlocks.DEEPSLATE_EMERALD_ORE.get()) {
			return MathHelper.nextInt(rng, this.emeraldXpMin.get(), this.emeraldXpMax.get());
		}
		return super.xpOnDrop(rng);
	}

}
