package net.luis.nero.config;

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

		BUILDER.comment("Min/Max xp that drops deepslate coal").comment("Default min value: 0");
		XP_COAL_MIN = BUILDER.define("deepslateCoalOreXpMin", 0);
		BUILDER.comment("Default max value: 4");
		XP_COAL_MAX = BUILDER.define("deepslateCoalOreXpMax", 4);
		
		BUILDER.comment("").comment("");
		XP_LAPIS_MIN = BUILDER.define("deepslateLapisOreXpMin", 0);
		BUILDER.comment("");
		XP_LAPIS_MAX = BUILDER.define("deepslateLapisOreXpMax", 4);
		
		BUILDER.comment("").comment("");
		XP_DIAMOND_MIN = BUILDER.define("deepslateDiamondOreXpMin", 0);
		BUILDER.comment("");
		XP_DIAMOND_MAX = BUILDER.define("deepslateDiamondOreXpMax", 4);
		
		BUILDER.comment("").comment("");
		XP_EMERALD_MIN = BUILDER.define("deepslateEmeraldOreXpMin", 0);
		BUILDER.comment("");
		XP_EMERALD_MAX = BUILDER.define("deepslateEmeraldOreXpMax", 4);
		
		BUILDER.pop();
		CONFIG = BUILDER.build();
	}

}
