package net.luis.nero.common.world.gen.feature;

import net.luis.nero.common.world.gen.ConfiguredModFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;

public class DefaultModFeatures {
	
	// TODO: disable/enable feature via config
	public static void addDeepslateOres(BiomeGenerationSettings.Builder generationBuilder) {
		int stageOre = GenerationStage.Decoration.UNDERGROUND_ORES.ordinal();
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
	
	// TODO: disable/enable feature via configvv
	public static void addOreOverwrites(BiomeGenerationSettings.Builder generationBuilder) {
		int stageOre = GenerationStage.Decoration.UNDERGROUND_ORES.ordinal();
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COAL_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COPPER_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.COPPER_ORE_BLOBS);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.IRON_ORE);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.IRON_ORE_BLOBS);
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.GOLD_ORE);
	}
	
	// TODO: disable/enable feature via config
	public static void addDeepslateUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
		int stageOre = GenerationStage.Decoration.UNDERGROUND_ORES.ordinal();
		generationBuilder.addFeature(stageOre, () -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	public static void addDeepslateStructures(BiomeGenerationSettings.Builder generationBuilder) {
//		int stageStructures = GenerationStage.Decoration.UNDERGROUND_ORES.ordinal();
//		int stageLake = GenerationStage.Decoration.UNDERGROUND_ORES.ordinal();
//		generationBuilder.addFeature(stageStructures, () -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM); 
//		generationBuilder.addFeature(stageLake, () -> ConfiguredModFeatures.DEEPSLATE_WATER_LAKE);
	}

	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
//		generationBuilder.addCarver(GenerationStage.Carving.AIR, ConfiguredModWorldCarvers.LARGE_CANYON);
//		generationBuilder.addCarver(GenerationStage.Carving.AIR, ConfiguredModWorldCarvers.HIGHER_CANYON);
	}
	
	// TODO: disable/enable feature via config
	public static void addCommonSpawns(MobSpawnInfo.Builder mobSpawnBuilder) {
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 5, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawnBuilder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
	}
	
	public static void addFlatBedrock(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStage.Decoration.RAW_GENERATION, ConfiguredModFeatures.FLAT_BEDROCK);
	}

}
