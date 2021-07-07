package net.luis.nero.init.world.dimension;

import net.luis.nero.Nero;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;

public class ModDimensions {
	
    public static final RegistryKey<Dimension> DEEPSLATE = RegistryKey.create(Registry.LEVEL_STEM_REGISTRY, new ResourceLocation(Nero.MOD_ID, "deepslate"));
    public static final RegistryKey<Dimension> TEST = RegistryKey.create(Registry.LEVEL_STEM_REGISTRY, new ResourceLocation(Nero.MOD_ID, "test"));

}
