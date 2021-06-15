package net.luis.nero.common.world.gen;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.world.ModSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ConfiguredModSurfaceBuilders {
	
	protected static final BlockState DEFAULT_STATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	protected static final SurfaceBuilderConfig DEEPSLATE_CONFIG = new SurfaceBuilderConfig(DEFAULT_STATE, DEFAULT_STATE, DEFAULT_STATE);
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DEEPSLATE = register("deepslate", 
			ModSurfaceBuilders.DEEPSLATE.get().configured(DEEPSLATE_CONFIG));
	
	private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> surfaceBuilder) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Nero.MOD_ID, name), surfaceBuilder);
	}

}
