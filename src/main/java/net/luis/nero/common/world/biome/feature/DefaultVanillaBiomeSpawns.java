package net.luis.nero.common.world.biome.feature;

import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DefaultVanillaBiomeSpawns {

	public static void addFarmAnimalSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
	}
	
	public static void addBeachSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));
	}
	
	public static void addTaigaSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
	}
	
	public static void addOldGrowthTaigaMonsterSpawns(MobSpawnBuilder mobBuilder, boolean spruce) {
		if (spruce) {
			addCommonMonsterSpawns(mobBuilder);
		} else {
			addCaveSpawns(mobBuilder);
			addMonsterSpawns(mobBuilder, 100, 25, 100);
		}
	}

	public static void addCaveSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
		addWaterCaveSpawns(mobBuilder);
	}

	public static void addCommonMonsterSpawns(MobSpawnBuilder mobBuilder) {
		addCaveSpawns(mobBuilder);
		addMonsterSpawns(mobBuilder, 95, 5, 100);
	}

	public static void addWaterCaveSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6));
		mobBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 10, 4, 6));
	}

	public static void addOceanSpawns(MobSpawnBuilder mobBuilder, int squidSpawnWeight, int squidMaxSpawnCount, int codSpawnWeight) {
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, squidSpawnWeight, 1, squidMaxSpawnCount));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.COD, codSpawnWeight, 3, 6));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 5, 1, 1));
		addCommonMonsterSpawns(mobBuilder);
	}

	public static void addWarmOceanSpawns(MobSpawnBuilder mobBuilder, int squidSpawnWeight, int squidMinSpawnCount) {
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, squidSpawnWeight, squidMinSpawnCount, 4));
		mobBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
		mobBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 2));
		addCommonMonsterSpawns(mobBuilder);
	}

	public static void addPlainsSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
		addFarmAnimalSpawns(mobBuilder);
		addCommonMonsterSpawns(mobBuilder);
	}

	public static void addSnowySpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 3));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 80, 4, 4));
		addCaveSpawns(mobBuilder);
		addMonsterSpawns(mobBuilder, 95, 5, 20);
	}

	public static void addDesertSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));
		addCaveSpawns(mobBuilder);
		addMonsterSpawns(mobBuilder, 19, 1, 100);
	}
	
	public static void addSavannaSpawns(MobSpawnBuilder mobBuilder) {
		addFarmAnimalSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
		addCommonMonsterSpawns(mobBuilder);
	}

	public static void addMonsterSpawns(MobSpawnBuilder mobBuilder, int zombieSpawnWeight, int zombieVillagerSpawnWeight, int skeletonSpawnWeight) {
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, zombieSpawnWeight, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, zombieVillagerSpawnWeight, 1, 1));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, skeletonSpawnWeight, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
	}

	public static void addMushroomSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MOOSHROOM, 8, 4, 8));
		addCaveSpawns(mobBuilder);
	}

	public static void addBaseJungleSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
		addFarmAnimalSpawns(mobBuilder);
		addCommonMonsterSpawns(mobBuilder);
	}
	
	public static void addJungleSpawns(MobSpawnBuilder mobBuilder, boolean hilly, boolean modified) {
		addBaseJungleSpawns(mobBuilder);
		if (modified) {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 10, 1, 1));
			mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
		} else {
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, hilly ? 10 : 40, 1, hilly ? 1 : 3));
			mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, hilly ? 1 : 2));
			mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 1, 2));
		}
	}
	
	public static void addBambooJungleSpawns(MobSpawnBuilder mobBuilder, boolean hilly) {
		addBaseJungleSpawns(mobBuilder);
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, hilly ? 10 : 40, 1, hilly ? 1 : 2));
		mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 80, 1, 2));
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
	}
	
	public static void addEndSpawns(MobSpawnBuilder mobBuilder) {
		mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 4, 4));
	}

}
