package net.luis.nero.common.world.biome.util;

import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeFeatures;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeSpawns;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class BiomeSettings {
	
	protected static BiomeGenerationBuilder getFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		return generationBuilder;
	}
	
	protected static MobSpawnBuilder getSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		return mobBuilder;
	}
	
	protected static ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> getWindsweptSurfaceBuilder(boolean edge, boolean wooded, boolean gravelly) {
		if (edge || wooded) {
			return SurfaceBuilders.GRASS;
		} else if (gravelly) {
			return SurfaceBuilders.GRAVELLY_MOUNTAIN;
		}
		return SurfaceBuilders.MOUNTAIN;
	}
	
	public static BiomeGenerationBuilder getBadlandsFeatures(boolean windswept, boolean wooded, boolean eroded) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		DefaultVanillaBiomeFeatures.addMesaStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, windswept || eroded);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addExtraGold(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addBadlandGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addBadlandExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		if (wooded) {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.WOODED_BADLANDS);
			DefaultVanillaBiomeFeatures.addBadlandsTrees(generationBuilder);
		} else if (eroded) {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.ERODED_BADLANDS);
		} else {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.BADLANDS);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getBadlandsSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getBeachFeatures(boolean shore) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, shore);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		if (shore) {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.STONE);
			DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		} else {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.DESERT);
			DefaultVanillaBiomeFeatures.addBeachStructures(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getBeachSpawns(boolean turtle) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		if (turtle) {
			DefaultVanillaBiomeSpawns.addBeachSpawns(mobBuilder);
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getDesertFeatures(boolean hilly, boolean lakey) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.DESERT);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDesertVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDesertExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addDesertStructures(generationBuilder, hilly, lakey);
		if (!lakey && !hilly) {
			DefaultVanillaBiomeFeatures.addFossilDecoration(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getDesertSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addDesertSpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getTaigaFeatures(boolean hilly, boolean snowy, boolean windswept) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addFerns(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addTaigaTrees(generationBuilder);
		DefaultVanillaBiomeFeatures.addTaigaGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, windswept);
		DefaultVanillaBiomeFeatures.addTaigaBerryBushes(generationBuilder, snowy);
		if (!hilly && !snowy && !windswept) {
			DefaultVanillaBiomeFeatures.addTagiaStructures(generationBuilder);
		} else if (!hilly && !windswept) {
			DefaultVanillaBiomeFeatures.addSnowyTagiaStructures(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getTaigaSpawns(boolean canPlayerSpawn) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addTaigaSpawns(mobBuilder);
		if (canPlayerSpawn) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getForestFeatures(boolean flower) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		if (flower) {
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION_COMMON);
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_TREES);
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST);
			DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		} else {
			DefaultVanillaBiomeFeatures.addForestFlowers(generationBuilder);
			DefaultVanillaBiomeFeatures.addOtherBirchTrees(generationBuilder);
			DefaultVanillaBiomeFeatures.addForestGrass(generationBuilder);
			DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getForestSpawns(boolean flower) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		if (flower) {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		} else {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getBirchForestFeatures(boolean oldGrowth) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addForestGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		if (oldGrowth) {
			DefaultVanillaBiomeFeatures.addOldGrowthBirchTrees(generationBuilder);
		} else {
			DefaultVanillaBiomeFeatures.addBirchTrees(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getBirchForestSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getDarkForestFeatures(boolean hilly) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addForestFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addForestGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addDarkForestStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addDarkForestVegetation(generationBuilder, hilly);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getDarkForestSpawns(boolean hilly) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		if (!hilly) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getOldGrowthTaigaFeatures(boolean spruce) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GIANT_TREE_TAIGA);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addMossyStoneBlock(generationBuilder);
		DefaultVanillaBiomeFeatures.addFerns(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addOldGrowthTaigaVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addRareBerryBushes(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addOldGrowthTaigaTrees(generationBuilder, spruce);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getOldGrowthTaigaSpawns(boolean spruce) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
		DefaultVanillaBiomeSpawns.addOldGrowthTaigaMonsterSpawns(mobBuilder, spruce);
		if (!spruce) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getJungleFeatures(boolean bamboo, boolean sparse, boolean modified) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addJungleRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addJungleGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addJungleExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		if (!sparse && !modified) {
			DefaultVanillaBiomeFeatures.addJungleStructures(generationBuilder);
		}
		if (bamboo) {
			DefaultVanillaBiomeFeatures.addBambooVegetation(generationBuilder);
		} else {
			if (!sparse && !modified) {
				DefaultVanillaBiomeFeatures.addLightBambooVegetation(generationBuilder);
			}
			if (sparse) {
				DefaultVanillaBiomeFeatures.addJungleSparseTrees(generationBuilder);
			} else {
				DefaultVanillaBiomeFeatures.addJungleTrees(generationBuilder);
			}
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getJungleSpawns(boolean hilly, boolean modified) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addJungleSpawns(mobBuilder, hilly, modified);
		if (!hilly && !modified) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static MobSpawnBuilder getJungleSparseSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addBaseJungleSpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static MobSpawnBuilder getBambooJungleSpawns(boolean hilly) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addBambooJungleSpawns(mobBuilder, hilly);
		if (!hilly) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getMushroomFieldsFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.MYCELIUM);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addMushroomFieldVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getMushroomFieldsSpawns(boolean shore) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addMushroomSpawns(mobBuilder);
		if (!shore) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getWindsweptFeatures(boolean edge, boolean wooded, boolean gravelly) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> getWindsweptSurfaceBuilder(edge, wooded, gravelly));
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortalMountain(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addExtraEmeralds(generationBuilder);
		if (edge) {
			DefaultVanillaBiomeFeatures.addWindsweptEdgeTrees(generationBuilder);
		} else {
			DefaultVanillaBiomeFeatures.addWindsweptTrees(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getWindsweptSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 4, 6));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 10, 4, 6));
		return mobBuilder;
	}
	
	protected static BiomeGenerationBuilder baseOceanFeatures(ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> surfaceBuilder, boolean deep, boolean warm) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> surfaceBuilder);
		DefaultVanillaBiomeFeatures.addOceanCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addWaterTrees(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addOceanStructures(generationBuilder, deep, warm);
		return generationBuilder;
	}
	
	public static BiomeGenerationBuilder getWarmOceanFeatures(boolean deep) {
		BiomeGenerationBuilder generationBuilder = baseOceanFeatures(SurfaceBuilders.FULL_SAND, deep, true);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.WARM_OCEAN_VEGETATION);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_WARM);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEA_PICKLE);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getWarmOceanSpawns(boolean deep) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addWarmOceanSpawns(mobBuilder, deep ? 5 : 10, deep ? 1 : 4);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getLukewarmOceanFeatures(boolean deep) {
		BiomeGenerationBuilder generationBuilder = baseOceanFeatures(SurfaceBuilders.OCEAN_SAND, deep, true);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, deep ? Features.SEAGRASS_DEEP_WARM : Features.SEAGRASS_WARM);
		DefaultVanillaBiomeFeatures.addLukeWarmKelp(generationBuilder);
		if (deep) {
			DefaultVanillaBiomeFeatures.addDefaultSeagrass(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getLukewarmOceanSpawns(boolean deep) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addOceanSpawns(mobBuilder, deep ? 8 : 10, deep ? 4 : 2, deep ? 8 : 15);
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 5, 1, 3));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 2));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getOceanFeatures(boolean deep) {
		BiomeGenerationBuilder generationBuilder = baseOceanFeatures(SurfaceBuilders.GRASS, deep, false);
		DefaultVanillaBiomeFeatures.addDefaultSeagrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addColdOceanKelp(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getOceanSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addOceanSpawns(mobBuilder, 1, 4, 10);
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 1, 1, 2));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getColdOceanFeatures(boolean deep) {
		BiomeGenerationBuilder generationBuilder = baseOceanFeatures(SurfaceBuilders.GRASS, deep, false);
		generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, deep ? Features.SEAGRASS_DEEP_COLD : Features.SEAGRASS_COLD);
		DefaultVanillaBiomeFeatures.addDefaultSeagrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addColdOceanKelp(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getColdOceanSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addOceanSpawns(mobBuilder, 3, 4, 15);
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getFrozenOceanFeatures(boolean deep) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.FROZEN_OCEAN);
		DefaultVanillaBiomeFeatures.addOceanStructures(generationBuilder, deep, false);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_OCEAN);
		DefaultVanillaBiomeFeatures.addOceanCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addIcebergs(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder, true);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addWaterTrees(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getFrozenOceanSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 1, 4));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 5, 1, 1));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getLegacyFrozenOceanFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.FROZEN_OCEAN);
		DefaultVanillaBiomeFeatures.addOceanStructures(generationBuilder, false, false);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_OCEAN);
		DefaultVanillaBiomeFeatures.addOceanCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder, true);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getLegacyFrozenOceanSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 1, 4));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 5, 1, 1));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getPlainsFeatures(boolean sunflower) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addPlainGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addPlainVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		if (sunflower) {
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN);
		} else {
			generationBuilder.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
			generationBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
			DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getPlainsSpawns(boolean sunflower) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addPlainsSpawns(mobBuilder);
		if (!sunflower) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getSavannaFeatures(boolean windswept, boolean shattered) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> (shattered ? SurfaceBuilders.SHATTERED_SAVANNA : SurfaceBuilders.GRASS));
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, windswept);
		if (!windswept && !shattered) {
			generationBuilder.addStructureStart(StructureFeatures.VILLAGE_SAVANNA);
			generationBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		}
		if (shattered) {
			DefaultVanillaBiomeFeatures.addShatteredSavannaGrass(generationBuilder);
			DefaultVanillaBiomeFeatures.addShatteredSavannaTrees(generationBuilder);
			DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		} else {
			DefaultVanillaBiomeFeatures.addWarmFlowers(generationBuilder);
			DefaultVanillaBiomeFeatures.addSavannaTrees(generationBuilder);
			DefaultVanillaBiomeFeatures.addSavannaGrass(generationBuilder);
			DefaultVanillaBiomeFeatures.addSavannaExtraGrass(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getSavannaSpawns(boolean windswept) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addSavannaSpawns(mobBuilder);
		if (windswept) {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 8, 4, 4));
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getSwampFeatures(boolean hilly) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.SWAMP);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSwampVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addSwampExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addSwampClayDisk(generationBuilder);
		DefaultVanillaBiomeFeatures.addFossilDecoration(generationBuilder);
		DefaultVanillaBiomeFeatures.addSwampStructures(generationBuilder, hilly);
		if (!hilly) {
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getSwampSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getTundraFeatures(boolean iceSpikes, boolean windswept) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> (iceSpikes ? SurfaceBuilders.ICE_SPIKES : SurfaceBuilders.GRASS));
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addSnowyTrees(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, windswept);
		if (!iceSpikes && !windswept) {
			generationBuilder.addStructureStart(StructureFeatures.VILLAGE_SNOWY);
			generationBuilder.addStructureStart(StructureFeatures.IGLOO);
			generationBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		} else if (iceSpikes) {
			generationBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.ICE_SPIKE);
			generationBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.ICE_PATCH);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getTundraSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		mobBuilder.creatureGenerationProbability(0.07F);
		DefaultVanillaBiomeSpawns.addSnowySpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getRiverFeatures(boolean frozen) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		generationBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		generationBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addWaterTrees(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultFlowers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		if (!frozen) {
			generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_RIVER);
		}
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getRiverSpawns(boolean frozen) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, frozen ? 1 : 100, 1, 1));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getMeadowFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addMeadowStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultGrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getMeadowSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 2, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 2));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 2, 6));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getGroveFeatures(boolean snowy) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addPeakStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		if (snowy) {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
			DefaultVanillaBiomeFeatures.addSnowyTrees(generationBuilder);
		} else {
			generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
			DefaultVanillaBiomeFeatures.addTaigaTrees(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getGroveSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getSnowySlopesFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addSnowySlopesStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getSnowySlopesSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getJaggedPeaksFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addPeakStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getJaggedPeaksSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getFrozenPeaksFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addPeakStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static BiomeGenerationBuilder getStonyPeaksFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(SurfaceBuilders.STONE);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addPeakStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getPeaksSpawns(boolean goats) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		if (goats) {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
		}
		return mobBuilder;
	}
	
	protected static BiomeGenerationBuilder baseCaveFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.STONE);
		DefaultVanillaBiomeFeatures.addDefaultStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder, true);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addPlainGrass(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getCaveSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getDripstoneCaveFeatures() {
		BiomeGenerationBuilder generationBuilder = baseCaveFeatures();
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addPlainVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDripstoneVegetation(generationBuilder);
		return generationBuilder;
	}
	
	public static BiomeGenerationBuilder getLushCavesFeatures() {
		BiomeGenerationBuilder generationBuilder = baseCaveFeatures();
		DefaultVanillaBiomeFeatures.addLushCavesSpecialOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addLushCavesVegetation(generationBuilder);
		return generationBuilder;
	}
	
	public static BiomeGenerationBuilder getDeepdarkOceanFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.GRASS);
		DefaultVanillaBiomeFeatures.addOceanCarvers(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultAmethystGeode(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMonsterRoom(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultUndergroundVariety(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultOres(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSoftDisks(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSeagrass(generationBuilder);
		DefaultVanillaBiomeFeatures.addColdOceanKelp(generationBuilder);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getDeepdarkOceanSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6));
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GUARDIAN, 1, 1, 2));
		return mobBuilder;
	}
	
}
