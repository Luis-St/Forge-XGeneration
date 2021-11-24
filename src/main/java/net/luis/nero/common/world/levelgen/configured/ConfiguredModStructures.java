package net.luis.nero.common.world.levelgen.configured;

import net.luis.nero.Nero;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ConfiguredModStructures {
	
	@SuppressWarnings("unused")
	private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(String name, ConfiguredStructureFeature<FC, F> structure) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(Nero.MOD_ID, name), structure);
	}

}
