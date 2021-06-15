package net.luis.nero.init.world.dimension;

import net.luis.nero.Nero;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;

public class ModDimensionTypes {

	public static final RegistryKey<DimensionType> DEEPSLATE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Nero.MOD_ID, "deepslate"));

}
