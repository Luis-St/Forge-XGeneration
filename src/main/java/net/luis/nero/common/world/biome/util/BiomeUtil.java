package net.luis.nero.common.world.biome.util;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeFeatures;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeSpawns;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class BiomeUtil {
	
	protected static BiomeGenerationBuilder getFeatures() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		
		return generationBuilder;
	}
	
	protected static MobSpawnBuilder getSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		
		return mobBuilder;
	}
	
	public static float getBeachTemperature(boolean shore, boolean snowy) {
		if (snowy) {
			return 0.05F;
		}
		return shore ? 0.2F : 0.8F;
	}
	
	protected static ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> getMountainSurfaceBuilder(boolean edge, boolean wooded, boolean gravelly) {
		if (edge || wooded) {
			return SurfaceBuilders.GRASS;
		} else if (gravelly) {
			return SurfaceBuilders.GRAVELLY_MOUNTAIN;
		}
		return SurfaceBuilders.MOUNTAIN;
	}
	
	public static BiomeGenerationBuilder getBadlandsFeatures(boolean plateau, boolean wooded) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		DefaultVanillaBiomeFeatures.addMesaStructures(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, plateau);
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
		DefaultVanillaBiomeFeatures.addDefaultLakes(generationBuilder);
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
	
	public static BiomeGenerationBuilder getTaigaFeatures(boolean hilly, boolean snowy, boolean mountain) {
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
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder, mountain);
		DefaultVanillaBiomeFeatures.addTaigaBerryBushes(generationBuilder, snowy);
		if (!hilly && !snowy && !mountain) {
			DefaultVanillaBiomeFeatures.addTagiaStructures(generationBuilder);
		} else if (!hilly && !mountain) {
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
	
	public static BiomeGenerationBuilder getBirchForestFeatures(boolean tall) {
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
		if (tall) {
			DefaultVanillaBiomeFeatures.addTallBirchTrees(generationBuilder);
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
	
	public static BiomeGenerationBuilder getGiantTreeTaigaFeatures(boolean spruce) {
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
		DefaultVanillaBiomeFeatures.addGiantTaigaVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultMushrooms(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultExtraVegetation(generationBuilder);
		DefaultVanillaBiomeFeatures.addDefaultSprings(generationBuilder);
		DefaultVanillaBiomeFeatures.addSurfaceFreezing(generationBuilder);
		DefaultVanillaBiomeFeatures.addRareBerryBushes(generationBuilder);
		DefaultVanillaBiomeFeatures.addRuinedPortal(generationBuilder);
		DefaultVanillaBiomeFeatures.addGiantTaigaTrees(generationBuilder, spruce);
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getGiantTreeTaigaSpawns(boolean spruce) {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
		DefaultVanillaBiomeSpawns.addGiantTaigaMonsterSpawns(mobBuilder, spruce);
		if (!spruce) {
			mobBuilder.enablePlayerSpawn();
		}
		return mobBuilder;
	}
	
	public static BiomeGenerationBuilder getJungleFeatures(boolean bamboo, boolean edge, boolean modified) {
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
		if (!edge && !modified) {
			DefaultVanillaBiomeFeatures.addJungleStructures(generationBuilder);
		}
		if (bamboo) {
			DefaultVanillaBiomeFeatures.addBambooVegetation(generationBuilder);
		} else {
			if (!edge && !modified) {
				DefaultVanillaBiomeFeatures.addLightBambooVegetation(generationBuilder);
			}
			if (edge) {
				DefaultVanillaBiomeFeatures.addJungleEdgeTrees(generationBuilder);
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
	
	public static MobSpawnBuilder getJungleEdgeSpawns() {
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
	
	public static BiomeGenerationBuilder getMountainFeatures(boolean edge, boolean wooded, boolean gravelly) {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> getMountainSurfaceBuilder(edge, wooded, gravelly));
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
			DefaultVanillaBiomeFeatures.addMountainEdgeTrees(generationBuilder);
		} else {
			DefaultVanillaBiomeFeatures.addMountainTrees(generationBuilder);
		}
		return generationBuilder;
	}
	
	public static MobSpawnBuilder getMountainSpawns() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		DefaultVanillaBiomeSpawns.addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 4, 6));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 10, 4, 6));
		return mobBuilder;
	}
	
}
