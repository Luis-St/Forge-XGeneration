package net.luis.nero.common.world.gen.feature;

import net.luis.nero.common.world.gen.configured.ConfiguredModFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DefaultModFeatures {
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateOres(BiomeGenerationSettings.Builder generationBuilder) {
		int stageOre = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_COAL_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_COPPER_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_IRON_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_GOLD_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_LAPIS_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_REDSTONE_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_EXTRA_REDSTONE_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_DIAMOND_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.DEEPSLATE_EMERALD_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOreOverwrites(BiomeGenerationSettings.Builder generationBuilder) {
		int stageOre = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COAL_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COPPER_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COPPER_ORE_BLOBS);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.IRON_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.IRON_ORE_BLOBS);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.GOLD_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
//		int stageOre = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
//		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateStructures(BiomeGenerationSettings.Builder generationBuilder) {
		int stageStructures = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
		int stageLake = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
		generationBuilder.addFeature(stageStructures, () -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM); 
		generationBuilder.addFeature(stageLake, () -> ConfiguredModFeatures.DEEPSLATE_WATER_LAKE);
	}

	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
//		generationBuilder.addCarver(GenerationStep.Carving.AIR, ConfiguredModWorldCarvers.LARGE_CANYON);
//		generationBuilder.addCarver(GenerationStep.Carving.AIR, ConfiguredModWorldCarvers.HIGHER_CANYON);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addCommonSpawns(MobSpawnSettings.Builder mobSpawnBuilder) {
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 5, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addFlatBedrock(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ConfiguredModFeatures.FLAT_BEDROCK);
	}

}
