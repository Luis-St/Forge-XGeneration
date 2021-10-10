package net.luis.nero.init.world.levelgen.surfacebuilder;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.surfacebuilder.DeepslateSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Nero.MOD_ID);
	
	public static final RegistryObject<DeepslateSurfaceBuilder> DEEPSLATE = SURFACE_BUILDERS.register("deepslate", DeepslateSurfaceBuilder::new);
//	public static final RegistryObject<PeaksSurfaceBuilder> PEAKS = SURFACE_BUILDERS.register("peaks", PeaksSurfaceBuilder::new);

}
