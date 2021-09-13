package net.luis.nero.common.world.levelgen.feature;

import net.luis.nero.common.world.levelgen.configured.ConfiguredModFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

// TODO: sort class make sub classes
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
	public static void addDeepslateUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_ORES, () -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateStructures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(UNDERGROUND_STRUCTURES, () -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM);
	}

	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addDeepslateCarvers(BiomeGenerationSettings.Builder generationBuilder) {
		
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addAmethystGeode(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(LOCAL_MODIFICATIONS, () -> ConfiguredModFeatures.DEEPSLATE_AMETHYST_GEODE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addFlatBedrock(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(RAW_GENERATION, () -> ConfiguredModFeatures.FLAT_BEDROCK);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOres(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_COAL);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_IRON);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_COPPER);
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
	public static void addVillagerStructures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
		generationBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldLandStructures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addStructureStart(StructureFeatures.STRONGHOLD);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldCarvers(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addLakes(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_WATER);
		generationBuilder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_LAVA);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldUndergroundVariety(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIRT);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GRAVEL);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GRANITE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIORITE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_ANDESITE);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.GLOW_LICHEN);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_TUFF);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DEEPSLATE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RARE_SMALL_DRIPSTONE_FEATURE);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addSoftDisks(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_SAND);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_GRAVEL);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldVegetation(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PLAIN_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addMushrooms(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_NORMAL);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_NORMAL);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addSprings(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_WATER);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldFeatures(BiomeGenerationSettings.Builder generationBuilder) {
		addVillagerStructures(generationBuilder);
		addOverworldLandStructures(generationBuilder);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		addOverworldCarvers(generationBuilder);
		addLakes(generationBuilder);
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.AMETHYST_GEODE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, Features.MONSTER_ROOM);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS_2);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
		addOverworldUndergroundVariety(generationBuilder);
		addOres(generationBuilder);
		addSoftDisks(generationBuilder);
		addOverworldVegetation(generationBuilder);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		addMushrooms(generationBuilder);
		addSprings(generationBuilder);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addNetherFeatures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER);
		generationBuilder.addStructureStart(StructureFeatures.NETHER_BRIDGE);
		generationBuilder.addStructureStart(StructureFeatures.BASTION_REMNANT);
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
		addMushrooms(generationBuilder);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addEndFeatures(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.END_CITY);
		generationBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addCommonMonsterSpawns(MobSpawnSettings.Builder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 25, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addCommonAnimalSpawns(MobSpawnSettings.Builder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addWaterCaveSpawns(MobSpawnSettings.Builder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 20, 2, 4));
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 5, 1, 3));
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 10, 1, 2));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 10, 1, 4));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addOverworldSpawns(MobSpawnSettings.Builder mobBuilder) {
		addCommonAnimalSpawns(mobBuilder);
		addCommonMonsterSpawns(mobBuilder);
		addWaterCaveSpawns(mobBuilder);
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addNetherSpawns(MobSpawnSettings.Builder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));
	}
	
	// TODO: disable/enable feature via config -> list with features in config boolean list
	public static void addEndSpawns(MobSpawnSettings.Builder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 4, 4));
	}
	
}
