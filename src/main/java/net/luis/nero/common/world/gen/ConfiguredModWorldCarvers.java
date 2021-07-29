
package net.luis.nero.common.world.gen;

import net.luis.nero.Nero;
import net.luis.nero.init.world.gen.feature.ModWorldCarvers;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;

public class ConfiguredModWorldCarvers {
	
//	public static final ConfiguredCarver<ProbabilityConfig> DEEP_LAVA_CAVE = ModCarvers.register("deep_lava_cave",
//			ModWorldCarvers.DEEP_LAVA_CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
//	
//	public static final ConfiguredCarver<ProbabilityConfig> FLAT_CAVE = ModCarvers.register("flat_cave",
//			ModWorldCarvers.FLAT_CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
//	
//	public static final ConfiguredCarver<ProbabilityConfig> DEEP_CAVE = ModCarvers.register("deep_cave",
//			ModWorldCarvers.DEEP_CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
//	
//	public static final ConfiguredCarver<ProbabilityConfig> DEFAULT_CAVE = ModCarvers.register("default_cave",
//			ModWorldCarvers.DEFAULT_CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
//	
//	public static final ConfiguredCarver<ProbabilityConfig> SMALL_CAVE = ModCarvers.register("small_cave",
//			ModWorldCarvers.SMALL_CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
	
	public static final ConfiguredWorldCarver<CanyonCarverConfiguration> CANYON = register("canyon",
			ModWorldCarvers.CANYON.get().configured(new CanyonCarverConfiguration(0.02F, null, null, null, false, null, null, null)));
	public static final ConfiguredWorldCarver<CaveCarverConfiguration> CAVE = register("cave",
			ModWorldCarvers.CAVE.get().configured(new CaveCarverConfiguration(0.14285715F, null, null, null, false, null, null, null, null)));
	
	
	public static final ConfiguredWorldCarver<CanyonCarverConfiguration> LARGE_CANYON = register("large_canyon",
			ModWorldCarvers.LARGE_CANYON.get().configured(new CanyonCarverConfiguration(0.01F, null, null, null, false, null, null, null)));
	public static final ConfiguredWorldCarver<CanyonCarverConfiguration> HIGHER_CANYON = register("higher_canyon",
			ModWorldCarvers.HIGHER_CANYON.get().configured(new CanyonCarverConfiguration(0.01F, null, null, null, false, null, null, null)));
	
	private static <WC extends CarverConfiguration> ConfiguredWorldCarver<WC> register(String name, ConfiguredWorldCarver<WC> configuredCarver) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_CARVER, new ResourceLocation(Nero.MOD_ID, name), configuredCarver);
	}

}
