package net.luis.nero.common.world.gen.configured;

import net.luis.nero.Nero;
import net.luis.nero.init.world.gen.feature.structure.ModStructures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

public class ConfiguredModStructures {
	
	public static final ConfiguredStructureFeature<?, ?> DEEPSLATE_MINESHAFT = register("deepslate_mineshaft", ModStructures.DEEPSLATE_MINESHAFT.get()
			.configured(FeatureConfiguration.NONE));
	
	private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> 
			register(String name, ConfiguredStructureFeature<FC, F> structure) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(Nero.MOD_ID, name), structure);
	}

}
