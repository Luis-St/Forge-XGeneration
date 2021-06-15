package net.luis.nero.common.world.gen;

import net.luis.nero.Nero;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;

public class ConfiguredModStructures {
	
	public static final StructureFeature<?, ?> DEEPSLATE_PORTAL = register("deepslate_portal", ModStructures.DEEPSLATE_PORTAL.get()
			.configured(IFeatureConfig.NONE));
	
	private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
		return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(Nero.MOD_ID, name), structure);
	}

}
