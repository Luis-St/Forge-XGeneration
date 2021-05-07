package net.luis.industry.common.world;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class ModDefaultFeatures {
	
	// TODO : mining test
	
	public static void addDeepslateOres(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_COAL_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_COPPER_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_IRON_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_GOLD_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_LAPIS_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_REDSTONE_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_EXTRA_REDSTONE_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_DIAMOND_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DEEPSLATE_EMERALD_ORE);
	}
	
	public static void addOreOverwrites(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.COAL_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.COPPER_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.IRON_ORE);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.GOLD_ORE);
	}
	
	public static void addDeepslateUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.TUFF_ORE);
	}
	
	public static void addDeepslateStructures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Features.MONSTER_ROOM);
		generationBuilder.addFeature(GenerationStage.Decoration.LAKES, ModFeatures.DEEPSLATE_LAVE_LAKE); // () -> new Lake Feature
		generationBuilder.addFeature(GenerationStage.Decoration.LAKES, ModFeatures.DEEPSLATE_WATER_LAKE);
	}

	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE); // () -> new Cave Feature
		generationBuilder.addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON); // () -> new Canyon Feature
	}

}
