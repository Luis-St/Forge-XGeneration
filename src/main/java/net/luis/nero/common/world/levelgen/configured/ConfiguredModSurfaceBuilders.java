package net.luis.nero.common.world.levelgen.configured;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.newsurfacebuilder.OverworldSurfaceBuilderConfiguration;
import net.luis.nero.init.world.levelgen.surfacebuilder.ModSurfaceBuilders;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class ConfiguredModSurfaceBuilders {
	
	protected static final SurfaceBuilderBaseConfiguration NULL_CONFIG = new SurfaceBuilderBaseConfiguration(Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState());
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> DEEPSLATE = register("deepslate", ModSurfaceBuilders.DEEPSLATE.get().configured(NULL_CONFIG));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> LEGACY_FORZEN_OCEAN = register("legacy_frozen_ocean", ModSurfaceBuilders.LEGACY_FORZEN_OCEAN.get().configured(NULL_CONFIG));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SNOWY_GROVE = register("snowy_grove", ModSurfaceBuilders.SNOWY_GROVE.get().configured(NULL_CONFIG));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SNOWY_SLOPES = register("snowy_slopes", ModSurfaceBuilders.SNOWY_SLOPES.get().configured(NULL_CONFIG));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> JAGGED_PEAKS = register("jagged_peaks", ModSurfaceBuilders.JAGGED_PEAKS.get().configured(NULL_CONFIG));
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> FROZEN_PEAKS = register("frozen_peaks", ModSurfaceBuilders.FROZEN_PEAKS.get().configured(NULL_CONFIG));
	
	public static final ConfiguredSurfaceBuilder<OverworldSurfaceBuilderConfiguration> BADLANDS = register("overworld_badlands", ModSurfaceBuilders.BADLANDS.get().configured());
	
	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> surfaceBuilder) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Nero.MOD_ID, name), surfaceBuilder);
	}

}
