package net.luis.nero.common.world.gen.feature;

import net.luis.nero.common.world.gen.configured.ConfiguredModFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class DefaultModFeatures {
	
	public static final int RAW_GENERATION = Decoration.RAW_GENERATION.ordinal();
	public static final int LAKES = Decoration.LAKES.ordinal();
	public static final int LOCAL_MODIFICATIONS = Decoration.LOCAL_MODIFICATIONS.ordinal();
	public static final int UNDERGROUND_STRUCTURES = Decoration.UNDERGROUND_STRUCTURES.ordinal();
	public static final int SURFACE_STRUCTURES = Decoration.SURFACE_STRUCTURES.ordinal();
	public static final int STRONGHOLDS = Decoration.STRONGHOLDS.ordinal();
	public static final int UNDERGROUND_ORES = Decoration.UNDERGROUND_ORES.ordinal();
	public static final int UNDERGROUND_DECORATION = Decoration.UNDERGROUND_DECORATION.ordinal();
	public static final int VEGETAL_DECORATION = Decoration.VEGETAL_DECORATION.ordinal();
	public static final int TOP_LAYER_MODIFICATION = Decoration.TOP_LAYER_MODIFICATION.ordinal();
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateOres(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_COAL_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_COPPER_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_IRON_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_GOLD_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_LAPIS_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_REDSTONE_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_EXTRA_REDSTONE_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_DIAMOND_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_EMERALD_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOreOverwrites(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.COAL_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.COPPER_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.COPPER_ORE_BLOBS);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.IRON_ORE);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.IRON_ORE_BLOBS);
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.GOLD_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateStructures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_STRUCTURES, () -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addAmethystGeode(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(LOCAL_MODIFICATIONS, () -> ConfiguredModFeatures.DEEPSLATE_AMETHYST_GEODE);
	}

	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
		
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addFlatBedrock(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(RAW_GENERATION, () -> ConfiguredModFeatures.FLAT_BEDROCK);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addCommonSpawns(MobSpawnSettings.Builder mobSpawnBuilder) {
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 25, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addWaterCaveSpawns(MobSpawnSettings.Builder mobSpawnBuilder) {
		mobSpawnBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 20, 2, 4));
		mobSpawnBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 5, 1, 3));
		mobSpawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 10, 1, 2));
		mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 10, 1, 4));
	}
	
}
