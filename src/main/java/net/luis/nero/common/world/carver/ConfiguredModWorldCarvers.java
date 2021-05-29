
package net.luis.nero.common.world.carver;

import net.luis.nero.Nero;
import net.luis.nero.init.world.ModWorldCarvers;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

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
	
	public static final ConfiguredCarver<ProbabilityConfig> CANYON = ConfiguredModWorldCarvers.register("canyon",
			ModWorldCarvers.CANYON.get().configured(new ProbabilityConfig(0.02F)));
	
	public static final ConfiguredCarver<ProbabilityConfig> CAVE = ConfiguredModWorldCarvers.register("cave",
			ModWorldCarvers.CAVE.get().configured(new ProbabilityConfig(0.14285715F)));
	
	public static final ConfiguredCarver<ProbabilityConfig> LARGE_CANYON = ConfiguredModWorldCarvers.register("large_canyon",
			ModWorldCarvers.LARGE_CANYON.get().configured(new ProbabilityConfig(0.01F)));
	
	public static final ConfiguredCarver<ProbabilityConfig> OCEAN = ConfiguredModWorldCarvers.register("ocean",
			ModWorldCarvers.OCEAN.get().configured(new ProbabilityConfig(0.01F)));
	
	private static <WC extends ICarverConfig> ConfiguredCarver<WC> register(String name, ConfiguredCarver<WC> configuredCarver) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_CARVER, new ResourceLocation(Nero.MOD_ID, name), configuredCarver);
	}

}
