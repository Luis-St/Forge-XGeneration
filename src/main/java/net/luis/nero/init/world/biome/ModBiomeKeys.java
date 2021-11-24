package net.luis.nero.init.world.biome;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.nero.Nero;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeKeys {
	
	public static final List<ResourceKey<Biome>> BIOMES = Lists.newArrayList();
	
	public static final ResourceKey<Biome> CLIMATE_ICY = register("climate_icy");
	public static final ResourceKey<Biome> CLIMATE_COLD = register("climate_cold");
	public static final ResourceKey<Biome> CLIMATE_MEDIUM = register("climate_medium");
	public static final ResourceKey<Biome> CLIMATE_WARM = register("climate_warm");
	public static final ResourceKey<Biome> CLIMATE_HOT = register("climate_hot");
	
	public static final ResourceKey<Biome> CLIMATE_DRIZZLE = register("climate_drizzle");
	public static final ResourceKey<Biome> CLIMATE_LIGHT = register("climate_light");
	public static final ResourceKey<Biome> CLIMATE_MODERATE = register("climate_moderate");
	public static final ResourceKey<Biome> CLIMATE_STRONG = register("climate_strong");
	public static final ResourceKey<Biome> CLIMATE_MONSOON = register("climate_monsoon");
	
	
	public static final ResourceKey<Biome> BADLANDS = register("badlands");
	public static final ResourceKey<Biome> WINDSWEPT_BADLANDS = register("windswept_badlands");
	public static final ResourceKey<Biome> ERODED_BADLANDS = register("eroded_badlands");
	public static final ResourceKey<Biome> MODIFIED_WINDSWEPT_BADLANDS = register("modified_windswept_badlands");
	public static final ResourceKey<Biome> WOODED_WINDSWEPT_BADLANDS = register("wooded_windswept_badlands");
	public static final ResourceKey<Biome> MODIFIED_WOODED_WINDSWEPT_BADLANDS = register("modified_wooded_windswept_badlands");
	
	public static final ResourceKey<Biome> DESERT = register("desert");
	public static final ResourceKey<Biome> DESERT_HILLS = register("desert_hills");
	public static final ResourceKey<Biome> DESERT_LAKES = register("desert_lakes");
	
	public static final ResourceKey<Biome> SAVANNA = register("savanna");
	public static final ResourceKey<Biome> WINDSWEPT_SAVANNA = register("windswept_savanna");
	public static final ResourceKey<Biome> SHATTERED_SAVANNA = register("shattered_savanna");
	public static final ResourceKey<Biome> SHATTERED_WINDSWEPT_SAVANNA = register("shattered_windswept_savanna");
	
	public static final ResourceKey<Biome> JUNGLE = register("jungle");
	public static final ResourceKey<Biome> JUNGLE_HILLS = register("jungle_hills");
	public static final ResourceKey<Biome> MODIFIED_JUNGLE = register("modified_jungle");
	public static final ResourceKey<Biome> BAMBOO_JUNGLE = register("bamboo_jungle");
	public static final ResourceKey<Biome> BAMBOO_JUNGLE_HILLS = register("bamboo_jungle_hills");
	public static final ResourceKey<Biome> SPARSE_JUNGLE = register("sparse_jungle");
	public static final ResourceKey<Biome> MODIFIED_SPARSE_JUNGLE = register("modified_sparse_jungle");
	
	public static final ResourceKey<Biome> FOREST = register("forest");
	public static final ResourceKey<Biome> FLOWER_FOREST = register("flower_forest");
	public static final ResourceKey<Biome> HILLY_FOREST = register("hilly_forest");
	
	public static final ResourceKey<Biome> BIRCH_FOREST = register("birch_forest");
	public static final ResourceKey<Biome> BIRCH_FOREST_HILLS = register("birch_forest_hills");
	public static final ResourceKey<Biome> OLD_GROWTH_BIRCH_FOREST = register("old_growth_birch_forest");
	public static final ResourceKey<Biome> OLD_GROWTH_BIRCH_FOREST_HILLS = register("old_growth_birch_forest_hills");
	
	public static final ResourceKey<Biome> DARK_FOREST = register("dark_forest");
	public static final ResourceKey<Biome> DARK_FOREST_HILLS = register("dark_forest_hills");
	
	public static final ResourceKey<Biome> SWAMP = register("swamp");
	public static final ResourceKey<Biome> SWAMP_HILLS = register("swamp_hills");
	
	public static final ResourceKey<Biome> PLAINS = register("plains");
	public static final ResourceKey<Biome> HILLY_PLAINS = register("hilly_plains");
	public static final ResourceKey<Biome> SUNFLOWER_PLAINS = register("sunflower_plains");
	public static final ResourceKey<Biome> SNOWY_PLAINS = register("snowy_plains");
	public static final ResourceKey<Biome> SNOWY_HILLY_PLAINS = register("snowy_hilly_plains");
	public static final ResourceKey<Biome> ICE_SPIKES_PLAINS = register("ice_spikes_plains");
	
	public static final ResourceKey<Biome> OCEAN = register("ocean");
	public static final ResourceKey<Biome> DEEP_OCEAN = register("deep_ocean");
	public static final ResourceKey<Biome> WARM_OCEAN = register("warm_ocean");
	public static final ResourceKey<Biome> DEEP_WARM_OCEAN = register("deep_warm_ocean");
	public static final ResourceKey<Biome> LUKEWARM_OCEAN = register("lukewarm_ocean");
	public static final ResourceKey<Biome> DEEP_LUKEWARM_OCEAN = register("deep_lukewarm_ocean");
	public static final ResourceKey<Biome> COLD_OCEAN = register("cold_ocean");
	public static final ResourceKey<Biome> DEEP_COLD_OCEAN = register("deep_cold_ocean");
	public static final ResourceKey<Biome> FROZEN_OCEAN = register("frozen_ocean");
	public static final ResourceKey<Biome> DEEP_FROZEN_OCEAN = register("deep_frozen_ocean");
	public static final ResourceKey<Biome> LEGACY_FORZEN_OCEAN = register("leagacy_frozen_ocean");
	
	public static final ResourceKey<Biome> MUSHROOM_FIELDS = register("mushroom_fields");
	public static final ResourceKey<Biome> MUSHROOM_FIELD_SHORE = register("mushroom_field_shore");
	
	public static final ResourceKey<Biome> WINDSWEPT_HILLS = register("windswept_hills");
	public static final ResourceKey<Biome> WINDSWEPT_EDGE_HILLS = register("windswept_edge_hills");
	public static final ResourceKey<Biome> WINDSWEPT_GRAVELLY_HILLS = register("windswept_gravelly_hills");
	public static final ResourceKey<Biome> MODIFIED_WINDSWEPT_GRAVELLY_HILLS = register("modified_windswept_gravelly_hills");
	public static final ResourceKey<Biome> WOODED_WINDSWEPT_HILLS = register("wooded_windswept_hills");
	public static final ResourceKey<Biome> SNOWY_WINDSWEPT_HILLS = register("snowy_windswept_hills");
	
	public static final ResourceKey<Biome> MEADOW = register("meadow");
	public static final ResourceKey<Biome> GROVE = register("grove");
	public static final ResourceKey<Biome> SNOWY_GROVE = register("snowy_grove");
	public static final ResourceKey<Biome> SNOWY_SLOPES = register("snowy_slopes");
	public static final ResourceKey<Biome> JAGGED_PEAKS = register("jagged_peaks");
	public static final ResourceKey<Biome> FROZEN_PEAKS = register("frozen_peaks");
	public static final ResourceKey<Biome> STONY_PEAKS = register("stony_peaks");
	
	public static final ResourceKey<Biome> BEACH = register("beach");
	public static final ResourceKey<Biome> SNOWY_BEACH = register("snowy_beach");
	public static final ResourceKey<Biome> STONY_SHORE = register("stony_shore");
	
	public static final ResourceKey<Biome> TAIGA = register("taiga");
	public static final ResourceKey<Biome> TAIGA_HILLS = register("taiga_hills");
	public static final ResourceKey<Biome> SNOWY_TAIGA = register("snowy_taiga");
	public static final ResourceKey<Biome> WINDSWEPT_TAIGA_HILLS = register("windswept_taiga_hills");
	public static final ResourceKey<Biome> SNOWY_WINDSWEPT_TAIGA_HILLS = register("snowy_windswept_taiga_hills");
	
	public static final ResourceKey<Biome> SNOWY_TAIGA_HILLS = register("snowy_taiga_hills");
	public static final ResourceKey<Biome> OLD_GROWTH_SPRUCE_TAIGA = register("old_growth_spruce_taiga");
	public static final ResourceKey<Biome> OLD_GROWTH_SPRUCE_TAIGA_HILLS = register("old_growth_spruce_taiga_hills");
	public static final ResourceKey<Biome> OLD_GROWTH_PINE_TAIGA = register("old_growth_pine_taiga");
	public static final ResourceKey<Biome> OLD_GROWTH_PINE_TAIGA_HILLS = register("old_growth_pine_taiga_hills");
	
	public static final ResourceKey<Biome> RIVER = register("river");
	public static final ResourceKey<Biome> FROZEN_RIVER = register("frozen_river");
	
	public static final ResourceKey<Biome> DRIPSTONE_CAVE = register("dripstone_cave");
	public static final ResourceKey<Biome> LUSH_CAVES = register("lush_caves");
	public static final ResourceKey<Biome> DEEPDARK_OCEAN = register("deepdark_ocean");
	
	protected static ResourceKey<Biome> register(String biomeName) {
		ResourceKey<Biome> resourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Nero.MOD_ID, biomeName));
		BIOMES.add(resourceKey);
		return resourceKey;
	}
}
