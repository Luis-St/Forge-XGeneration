package net.luis.industry.common.world.surfacebuilder;

import net.luis.industry.Industry;
import net.luis.industry.init.block.ModBlocks;
import net.luis.industry.init.world.ModSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ConfiguredModSurfaceBuilders {
	
	public static final BlockState DEEPSLATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	public static final SurfaceBuilderConfig DEEPSLATE_CONFIG = new SurfaceBuilderConfig(DEEPSLATE, DEEPSLATE, DEEPSLATE);
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DEFAULT_DEEPSLATE = register("default_deepslate", 
			ModSurfaceBuilders.DEFAULT_DEEPSLATE.get().configured(DEEPSLATE_CONFIG));
	
	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> surfaceBuilder) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Industry.MOD_ID, name), surfaceBuilder);
	}

}
