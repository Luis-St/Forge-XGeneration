package net.luis.nero.common.world.gen;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.world.gen.ModSurfaceBuilders;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class ConfiguredModSurfaceBuilders {
	
	protected static final BlockState DEFAULT_STATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	protected static final SurfaceBuilderBaseConfiguration DEEPSLATE_CONFIG = new SurfaceBuilderBaseConfiguration(DEFAULT_STATE, DEFAULT_STATE, DEFAULT_STATE);
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> DEEPSLATE = register("deepslate", 
			ModSurfaceBuilders.DEEPSLATE.get().configured(DEEPSLATE_CONFIG));
	
	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> surfaceBuilder) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Nero.MOD_ID, name), surfaceBuilder);
	}

}
