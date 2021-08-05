
package net.luis.nero.common.world.gen.configured;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.configured.builder.ConfiguredCanyonBuilder;
import net.luis.nero.common.world.gen.configured.builder.ConfiguredCaveBuilder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class ConfiguredModWorldCarvers {
	
	public static final ConfiguredWorldCarver<CaveCarverConfiguration> CAVE = register("cave",
			ConfiguredCaveBuilder.of(WorldCarver.CAVE).probability(0.14285715F).y(0, 127).yScale(0.5F).lavaLevel(10)
			.disableAquifers().debugSettings().horizontalMultiplier(1.0F).verticalMultiplier(1.0F).floorLevel(-0.7F).build());
	
	public static final ConfiguredWorldCarver<CaveCarverConfiguration> TEST_CAVE = register("test_cave",
			ConfiguredCaveBuilder.of(WorldCarver.CAVE).probability(0.14285715F).y(64, 128)
			.yScale(0.5F) // room height
			.lavaLevel(10) // lava height
			.disableAquifers().debugSettings()
			.horizontalMultiplier(1.0F) // tunnel height
			.verticalMultiplier(1.0F) // tunnel width
			.floorLevel(-0.7F) // length of a cave
			.build());
	
	public static final ConfiguredWorldCarver<CanyonCarverConfiguration> CANYON =  register("canyon", 
			ConfiguredCanyonBuilder.of(WorldCarver.CANYON).probability(0.02F).y(20, 67).yScale(3.0F).lavaLevel(10)
			.disableAquifers().debugSettings().verticalRotation(-0.125F, 0.125F).shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(0.75F, 1.0F).thickness(0.0F, 6.0F, 2.0F).widthSmoothness(3).horizontalFactor(0.75F, 1.0F)
					.verticalDefaultFactor(1.0F).verticalCenterFactor(0.0F))
			.build());
	
	public static final ConfiguredWorldCarver<CanyonCarverConfiguration> TEST_CANYON =  register("canyon_test", 
			ConfiguredCanyonBuilder.of(WorldCarver.CANYON).probability(0.02F).y(20, 67)
			.yScale(3.0F) // height
			.lavaLevel(10)  // lava height
			.disableAquifers().debugSettings()
			.verticalRotation(-0.125F, 0.125F) // move direction multiplier
			.shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(0.75F, 1.0F) // length
					.thickness(0.0F, 6.0F, 2.0F) // width
					.widthSmoothness(10) // smoothness
					.horizontalFactor(0.75F, 1.0F) // width multiplier
					.verticalDefaultFactor(1.0F) // height multiplier
					.verticalCenterFactor(2.0F)) // height center multiplier
			.build());

	private static <WC extends CarverConfiguration> ConfiguredWorldCarver<WC> register(String name,
			ConfiguredWorldCarver<WC> configuredCarver) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_CARVER, new ResourceLocation(Nero.MOD_ID, name),
				configuredCarver);
	}

}
