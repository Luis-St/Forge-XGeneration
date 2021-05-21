package net.luis.industry.init.world;

import net.luis.industry.Industry;
import net.luis.industry.common.world.surfacebuilder.DeepslateSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Industry.MOD_ID);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> DEEPSLATE = SURFACE_BUILDERS.register("deepslate", DeepslateSurfaceBuilder::new);
//	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> WATER_OCEAN = SURFACE_BUILDERS.register("water_ocean", WaterOceanSurfaceBuilder::new);
//	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> LAVA_OCEAN = SURFACE_BUILDERS.register("lava_ocean", LavaOceanSurfaceBuilder::new);

}
