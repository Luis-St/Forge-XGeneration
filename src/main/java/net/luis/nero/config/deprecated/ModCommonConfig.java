package net.luis.nero.config.deprecated;

import java.util.Random;

import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ModCommonConfig {
	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CONFIG;

	private static final ConfigValue<Integer> XP_COAL_MIN;
	private static final ConfigValue<Integer> XP_COAL_MAX;
	
	private static final ConfigValue<Integer> XP_LAPIS_MIN;
	private static final ConfigValue<Integer> XP_LAPIS_MAX;
	
	private static final ConfigValue<Integer> XP_DIAMOND_MIN;
	private static final ConfigValue<Integer> XP_DIAMOND_MAX;
	
	private static final ConfigValue<Integer> XP_EMERALD_MIN;
	private static final ConfigValue<Integer> XP_EMERALD_MAX;

	static {
		BUILDER.comment("This is a working default configuration\nChanges of the default values can lead problems");
		BUILDER.push("Nero Common Config");

		BUILDER.comment("Min/Max xp that drops deepslate coal\nDefault min value: 0");
		XP_COAL_MIN = BUILDER.define("deepslateCoalOreXpMin", 0);
		BUILDER.comment("Default max value: 4");
		XP_COAL_MAX = BUILDER.define("deepslateCoalOreXpMax", 4);
		
		BUILDER.comment("Min/Max xp that drops deepslate lapis\nDefault min value: 3");
		XP_LAPIS_MIN = BUILDER.define("deepslateLapisOreXpMin", 3);
		BUILDER.comment("Default max value: 6");
		XP_LAPIS_MAX = BUILDER.define("deepslateLapisOreXpMax", 6);
		
		BUILDER.comment("Min/Max xp that drops deepslate diamond\nDefault min value: 4");
		XP_DIAMOND_MIN = BUILDER.define("deepslateDiamondOreXpMin", 4);
		BUILDER.comment("Default max value: 8");
		XP_DIAMOND_MAX = BUILDER.define("deepslateDiamondOreXpMax", 8);
		
		BUILDER.comment("Min/Max xp that drops deepslate emerald\nDefault min value: 4");
		XP_EMERALD_MIN = BUILDER.define("deepslateEmeraldOreXpMin", 4);
		BUILDER.comment("Default max value: 8");
		XP_EMERALD_MAX = BUILDER.define("deepslateEmeraldOreXpMax", 8);
		
		BUILDER.pop();
		CONFIG = BUILDER.build();
	}

	public static int getDeepslateCoalXp(Random rng) {
		return MathHelper.nextInt(rng, XP_COAL_MIN.get(), XP_COAL_MAX.get());
	}

	public static int getDeepslateLapisXp(Random rng) {
		return MathHelper.nextInt(rng, XP_LAPIS_MIN.get(), XP_LAPIS_MAX.get());
	}

	public static int getDeepslateDiamondXp(Random rng) {
		return MathHelper.nextInt(rng, XP_DIAMOND_MIN.get(), XP_DIAMOND_MAX.get());
	}

	public static int getDeepslateEmeraldXp(Random rng) {
		return MathHelper.nextInt(rng, XP_EMERALD_MIN.get(), XP_EMERALD_MAX.get());
	}

}
