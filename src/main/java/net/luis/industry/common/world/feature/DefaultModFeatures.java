package net.luis.industry.common.world.feature;

import net.luis.industry.common.world.carver.ModCarvers;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;

public class DefaultModFeatures {
	
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
//		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
//		generationBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, ModFeatures.DEEPSLATE_MONSTER_ROOM); 
//		generationBuilder.addFeature(GenerationStage.Decoration.LAKES, ModFeatures.DEEPSLATE_WATER_LAKE);
	}

	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addCarver(GenerationStage.Carving.AIR, ModCarvers.CAVE);
//		generationBuilder.addCarver(GenerationStage.Carving.AIR, ModCarvers.CANYON);
	}
	
	public static void addCommonSpawns(MobSpawnInfo.Builder mobSpawnBuilder) {
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 5, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
	}
	
	public static void addFlatBedrock(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStage.Decoration.RAW_GENERATION, ModFeatures.FLAT_BEDROCK);
	}

}
