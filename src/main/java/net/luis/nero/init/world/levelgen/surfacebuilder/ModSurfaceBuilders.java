package net.luis.nero.init.world.levelgen.surfacebuilder;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.surfacebuilder.DeepslateSurfaceBuilder;
import net.luis.nero.common.world.levelgen.surfacebuilder.FrozenPeaksSurfaceBuilder;
import net.luis.nero.common.world.levelgen.surfacebuilder.JaggedPeaksSurfaceBuilder;
import net.luis.nero.common.world.levelgen.surfacebuilder.LegacyFrozenOceanSurfaceBuilder;
import net.luis.nero.common.world.levelgen.surfacebuilder.SnowyGroveSurfaceBuilder;
import net.luis.nero.common.world.levelgen.surfacebuilder.SnowySlopesSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfaceBuilders {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Nero.MOD_ID);
	
	public static final RegistryObject<DeepslateSurfaceBuilder> DEEPSLATE = SURFACE_BUILDERS.register("deepslate", DeepslateSurfaceBuilder::new);
	public static final RegistryObject<LegacyFrozenOceanSurfaceBuilder> LEGACY_FORZEN_OCEAN = SURFACE_BUILDERS.register("legacy_frozen_ocean", LegacyFrozenOceanSurfaceBuilder::new);
	public static final RegistryObject<SnowyGroveSurfaceBuilder> SNOWY_GROVE = SURFACE_BUILDERS.register("snowy_grove", SnowyGroveSurfaceBuilder::new);
	public static final RegistryObject<SnowySlopesSurfaceBuilder> SNOWY_SLOPES = SURFACE_BUILDERS.register("snowy_slopes", SnowySlopesSurfaceBuilder::new);
	public static final RegistryObject<JaggedPeaksSurfaceBuilder> JAGGED_PEAKS = SURFACE_BUILDERS.register("jagged_peaks", JaggedPeaksSurfaceBuilder::new);
	public static final RegistryObject<FrozenPeaksSurfaceBuilder> FROZEN_PEAKS = SURFACE_BUILDERS.register("frozen_peaks", FrozenPeaksSurfaceBuilder::new);
	
}
