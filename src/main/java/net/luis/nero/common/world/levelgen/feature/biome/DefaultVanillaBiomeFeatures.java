package net.luis.nero.common.world.levelgen.feature.biome;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DefaultVanillaBiomeFeatures {
	
	public static void addMesaStructures(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT_MESA);
		generationBuilder.addStructureStart(StructureFeatures.STRONGHOLD);
	}
	
	public static void addRuinedPortal(BiomeGenerationBuilder generationBuilder, boolean mountain) {
		generationBuilder.addStructureStart(mountain ? StructureFeatures.RUINED_PORTAL_MOUNTAIN : StructureFeatures.RUINED_PORTAL_STANDARD);
	}
	
	public static void addBeachStructures(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addStructureStart(StructureFeatures.BURIED_TREASURE);
		generationBuilder.addStructureStart(StructureFeatures.SHIPWRECH_BEACHED);
	}
	
	public static void addDesertStructures(BiomeGenerationBuilder generationBuilder, boolean hilly, boolean lakey) {
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);
		if (!hilly) {
			generationBuilder.addStructureStart(StructureFeatures.DESERT_PYRAMID);
			if (!lakey) {
				generationBuilder.addStructureStart(StructureFeatures.VILLAGE_DESERT);
				generationBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
			}
		}
	}

	public static void addDefaultStructures(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addStructureStart(StructureFeatures.STRONGHOLD);
	}

	public static void addOceanStructures(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addStructureStart(StructureFeatures.SHIPWRECK);
	}

	public static void addDefaultCarvers(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
	}

	public static void addOceanCarvers(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.OCEAN_CAVE);
		generationBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
		generationBuilder.addCarver(GenerationStep.Carving.LIQUID, Carvers.UNDERWATER_CANYON);
		generationBuilder.addCarver(GenerationStep.Carving.LIQUID, Carvers.UNDERWATER_CAVE);
	}

	public static void addDefaultLakes(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_WATER);
		generationBuilder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_LAVA);
	}

	public static void addDesertLakes(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LAKES, Features.LAKE_LAVA);
	}

	public static void addDefaultMonsterRoom(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, Features.MONSTER_ROOM);
	}

	public static void addDefaultUndergroundVariety(BiomeGenerationBuilder generationBuilder) {
		addDefaultUndergroundVariety(generationBuilder, false);
	}

	public static void addDefaultUndergroundVariety(BiomeGenerationBuilder generationBuilder, boolean cave) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIRT);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GRAVEL);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GRANITE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIORITE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_ANDESITE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_TUFF);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DEEPSLATE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RARE_DRIPSTONE_CLUSTER_FEATURE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RARE_SMALL_DRIPSTONE_FEATURE);
		if (!cave) {
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.GLOW_LICHEN);
		}
	}
	
	public static void addDripstoneVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.LARGE_DRIPSTONE_FEATURE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.DRIPSTONE_CLUSTER_FEATURE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SMALL_DRIPSTONE_FEATURE);
	}

	public static void addDefaultOres(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_COAL);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_IRON);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_COPPER);
	}

	public static void addExtraGold(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD_EXTRA);
	}

	public static void addExtraEmeralds(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_EMERALD);
	}

	public static void addInfestedStone(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_INFESTED);
	}

	public static void addDefaultSoftDisks(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_SAND);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_GRAVEL);
	}

	public static void addSwampClayDisk(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY);
	}

	public static void addMossyStoneBlock(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.FOREST_ROCK);
	}

	public static void addFerns(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_LARGE_FERN);
	}

	public static void addBerryBushes(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_BERRY_DECORATED);
	}

	public static void addRareBerryBushes(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_BERRY_SPARSE);
	}

	public static void addLightBambooVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BAMBOO_LIGHT);
	}

	public static void addBambooVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BAMBOO);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BAMBOO_VEGETATION);
	}

	public static void addTaigaTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TAIGA_VEGETATION);
	}

	public static void addWaterTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_WATER);
	}

	public static void addBirchTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_BIRCH);
	}

	public static void addOtherBirchTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BIRCH_OTHER);
	}

	public static void addTallBirchTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BIRCH_TALL);
	}

	public static void addSavannaTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_SAVANNA);
	}

	public static void addShatteredSavannaTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_SHATTERED_SAVANNA);
	}

	public static void addLushCavesVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.LUSH_CAVES_CEILING_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CAVE_VINES);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.LUSH_CAVES_CLAY);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.LUSH_CAVES_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.ROOTED_AZALEA_TREES);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPORE_BLOSSOM_FEATURE);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CLASSIC_VINES_CAVE_FEATURE);
	}

	public static void addLushCavesSpecialOres(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.ORE_CLAY);
	}

	public static void addMountainTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_MOUNTAIN);
	}

	public static void addMountainEdgeTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_MOUNTAIN_EDGE);
	}

	public static void addJungleTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_JUNGLE);
	}

	public static void addJungleEdgeTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_JUNGLE_EDGE);
	}

	public static void addBadlandsTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_BADLANDS);
	}

	public static void addSnowyTrees(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_SNOWY);
	}

	public static void addJungleGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_JUNGLE);
	}

	public static void addSavannaGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS);
	}

	public static void addShatteredSavannaGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL);
	}

	public static void addSavannaExtraGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_SAVANNA);
	}

	public static void addBadlandGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_BADLANDS);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_BADLANDS);
	}

	public static void addForestFlowers(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION);
	}

	public static void addForestGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);
	}

	public static void addSwampVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TREES_SWAMP);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_WATERLILLY);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_SWAMP);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_SWAMP);
	}

	public static void addMushroomFieldVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.MUSHROOM_FIELD_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_TAIGA);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_TAIGA);
	}

	public static void addPlainVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PLAIN_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
	}

	public static void addDesertVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
	}

	public static void addGiantTaigaVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_TAIGA);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_GIANT);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_GIANT);
	}

	public static void addDefaultFlowers(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_DEFAULT);
	}

	public static void addWarmFlowers(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_WARM);
	}

	public static void addDefaultGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_BADLANDS);
	}

	public static void addTaigaGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_TAIGA_2);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_TAIGA);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_TAIGA);
	}

	public static void addPlainGrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS_2);
	}

	public static void addDefaultMushrooms(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_NORMAL);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_NORMAL);
	}

	public static void addDefaultExtraVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
	}

	public static void addBadlandExtraVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE_BADLANDS);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_CACTUS_DECORATED);
	}

	public static void addJungleExtraVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_MELON);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.VINES);
	}

	public static void addDesertExtraVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE_DESERT);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_CACTUS_DESERT);
	}

	public static void addSwampExtraVegetation(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE_SWAMP);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
	}

	public static void addDesertWell(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.WELL);
	}

	public static void addFossilDecoration(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, Features.FOSSIL);
	}

	public static void addColdOceanKelp(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.KELP_COLD);
	}

	public static void addDefaultSeagrass(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SIMPLE);
	}

	public static void addLukeWarmKelp(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.KELP_WARM);
	}

	public static void addDefaultSprings(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_WATER);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
	}

	public static void addIcebergs(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.ICEBERG_PACKED);
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.ICEBERG_BLUE);
	}

	public static void addBlueIce(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.BLUE_ICE);
	}

	public static void addSurfaceFreezing(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, Features.FREEZE_TOP_LAYER);
	}

	public static void addNetherDefaultOres(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_GRAVEL_NETHER);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_BLACKSTONE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_GOLD_NETHER);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_QUARTZ_NETHER);
		addAncientDebris(generationBuilder);
	}

	public static void addAncientDebris(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_DEBRIS_LARGE);
		generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_DEBRIS_SMALL);
	}

	public static void addDefaultAmethystGeode(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, Features.AMETHYST_GEODE);
	}
	
}
