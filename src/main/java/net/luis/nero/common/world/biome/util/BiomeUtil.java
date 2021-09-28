package net.luis.nero.common.world.biome.util;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeFeatures;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeSpawns;
import net.minecraft.data.worldgen.SurfaceBuilders;

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
	
}
