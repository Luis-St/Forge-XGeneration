package net.luis.nero.common.world.levelgen.configured;

import net.luis.nero.Nero;
import net.luis.nero.init.world.levelgen.surfacebuilder.ModSurfaceBuilders;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class ConfiguredModSurfaceBuilders {
	
	
	protected static final SurfaceBuilderBaseConfiguration DEEPSLATE_CONFIG = new SurfaceBuilderBaseConfiguration(Blocks.DEEPSLATE.defaultBlockState(), Blocks.DEEPSLATE.defaultBlockState(), Blocks.DEEPSLATE.defaultBlockState());
	protected static final SurfaceBuilderBaseConfiguration PEAKS_CONFIG = new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> DEEPSLATE = register("deepslate", ModSurfaceBuilders.DEEPSLATE.get().configured(DEEPSLATE_CONFIG));
//	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> PEAKS = register("deepslate", ModSurfaceBuilders.PEAKS.get().configured(PEAKS_CONFIG));
	
	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> surfaceBuilder) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Nero.MOD_ID, name), surfaceBuilder);
	}

}
