package net.luis.industry.init.world;

import net.luis.industry.Industry;
import net.luis.industry.common.world.surfacebuilder.DefaultDeepslateSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Industry.MOD_ID);
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> DEFAULT_DEEPSLATE = SURFACE_BUILDERS.register("default_deepslate", 
			() -> new DefaultDeepslateSurfaceBuilder());

}
