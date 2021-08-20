package net.luis.nero.init.world.levelgen.surfacebuilder;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.surfacebuilder.DeepslateSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Nero.MOD_ID);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderBaseConfiguration>> DEEPSLATE = SURFACE_BUILDERS.register("deepslate", DeepslateSurfaceBuilder::new);

}
