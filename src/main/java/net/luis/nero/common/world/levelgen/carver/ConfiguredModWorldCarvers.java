
package net.luis.nero.common.world.levelgen.carver;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.carver.builder.ConfiguredCanyonBuilder;
import net.luis.nero.common.world.levelgen.carver.builder.ConfiguredCaveBuilder;
import net.luis.nero.common.world.levelgen.carver.config.ModCanyonCarverConfiguration;
import net.luis.nero.common.world.levelgen.carver.config.ModCaveCarverConfiguration;
import net.luis.nero.init.world.levelgen.carver.ModWorldCarvers;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.material.Fluids;

// TODO: fix
public class ConfiguredModWorldCarvers {
	
	public static final ConfiguredWorldCarver<ModCaveCarverConfiguration> CAVE = register("cave",
			ConfiguredCaveBuilder.of(ModWorldCarvers.CAVE.get()).probability(0.14285715F).y(20, 127).range(4).bound(15)
			.yRoomScale(0.5F).yTunnelScale(1.0F).fluidLevel(32).fluid(Fluids.LAVA).horizontalMultiplier(1.0F)
			.verticalMultiplier(1.0F).floorLevel(-0.7F).build());
	
	public static final ConfiguredWorldCarver<ModCanyonCarverConfiguration> CANYON =  register("canyon", 
			ConfiguredCanyonBuilder.of(ModWorldCarvers.CANYON.get()).probability(0.02F).y(20, 490).range(4).yScale(3.0F).fluidLevel(32)
			.fluid(Fluids.LAVA).verticalRotation(-0.125F, 0.125F).shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(0.75F, 1.0F).thickness(0.0F, 6.0F, 2.0F).widthSmoothness(3).horizontalFactor(0.75F, 1.0F)
					.verticalDefaultFactor(1.0F).verticalCenterFactor(0.0F))
			.build());
	
	public static final ConfiguredWorldCarver<ModCanyonCarverConfiguration> LARGE_CANYON = register("large_canyon",
			ConfiguredCanyonBuilder.of(ModWorldCarvers.CANYON.get()).probability(0.008F).y(20, 67).yScale(3.0F).fluidLevel(32)
			.fluid(Fluids.LAVA).verticalRotation(-0.125F, 0.125F).shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(1.6F, 1.7F).thickness(0.0F, 6.0F, 2.0F).widthSmoothness(3).horizontalFactor(0.75F, 1.0F)
					.verticalDefaultFactor(1.0F).verticalCenterFactor(0.0F))
			.build());
	
	public static final ConfiguredWorldCarver<ModCanyonCarverConfiguration> HEIGHT_CANYON =  register("height_canyon", 
			ConfiguredCanyonBuilder.of(ModWorldCarvers.CANYON.get()).probability(0.02F).y(40, 470).yScale(5.0F).fluidLevel(32)
			.fluid(Fluids.LAVA).verticalRotation(-0.35F, 0.35F).shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(0.75F, 0.85F).thickness(0.0F, 7.0F, 3.0F).widthSmoothness(6).horizontalFactor(1.0F, 1.25F)
					.verticalDefaultFactor(1.0F).verticalCenterFactor(0.0F))
			.build());
	
	
	
	public static final ConfiguredWorldCarver<ModCaveCarverConfiguration> TEST_CAVE = register("test_cave",
			ConfiguredCaveBuilder.of(ModWorldCarvers.CAVE.get()).probability(0.14285715F).y(64, 128)
			.range(4) // tunnel length
			.bound(15) // cave gen length
			.yRoomScale(0.5F) // room height
			.yTunnelScale(1.0F) // tunnel height
			.fluidLevel(10) // fluid height
			.fluid(Fluids.LAVA) // filler fluid
			.horizontalMultiplier(1.0F) // tunnel height
			.verticalMultiplier(1.0F) // tunnel width
			.floorLevel(-0.7F) // length of a cave
			.build());
	
	public static final ConfiguredWorldCarver<ModCanyonCarverConfiguration> TEST_CANYON =  register("canyon_test", 
			ConfiguredCanyonBuilder.of(ModWorldCarvers.CANYON.get()).probability(0.02F).y(20, 67)
			.range(4) // canyon length
			.yScale(3.0F) // height
			.fluidLevel(10) // fluid height
			.fluid(Fluids.LAVA) // filler fluid
			.verticalRotation(-0.125F, 0.125F) // move direction multiplier
			.shape(ConfiguredCanyonBuilder.ShapeBuilder.of()
					.distanceFactor(1.6F, 1.7F) // length
					.thickness(0.0F, 6.0F, 2.0F) // width
					.widthSmoothness(3) // smoothness
					.horizontalFactor(0.75F, 1.0F) // width multiplier
					.verticalDefaultFactor(1.0F) // height multiplier
					.verticalCenterFactor(0.0F)) // height center multiplier
			.build());

	private static <C extends CarverConfiguration> ConfiguredWorldCarver<C> register(String name,ConfiguredWorldCarver<C> configuredCarver) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_CARVER, new ResourceLocation(Nero.MOD_ID, name), configuredCarver);
	}

}
