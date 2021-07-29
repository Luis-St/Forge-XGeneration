package net.luis.nero.init.world.dimension;

import net.luis.nero.Nero;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensionTypes {

	public static final ResourceKey<DimensionType> DEEPSLATE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Nero.MOD_ID, "deepslate"));
	public static final ResourceKey<DimensionType> TEST = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Nero.MOD_ID, "test"));

}
