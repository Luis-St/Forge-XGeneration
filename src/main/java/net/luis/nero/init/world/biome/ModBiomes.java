package net.luis.nero.init.world.biome;

import java.util.Map;

import com.google.common.collect.Maps;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.biomes.ModBiome;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	public static final Map<ModBiome, RegistryObject<Biome>> REGISTRY_BIOMES = Maps.newHashMap();
	public static final Map<ResourceLocation, ModBiome> BIOME_IDS = Maps.newHashMap();
	
//	public static final Set<IBiome> MAIN_BIOMES = Sets.newHashSet(ModBiomes.BADLANDS, ModBiomes.DESERT, ModBiomes.SAVANNA, ModBiomes.JUNGLE, ModBiomes.FOREST, ModBiomes.BIRCH_FOREST, ModBiomes.DARK_FOREST,
//			ModBiomes.SWAMP, ModBiomes.PLAINS, ModBiomes.SNOWY_PLAINS, ModBiomes.OCEAN, ModBiomes.MUSHROOM_FIELDS, ModBiomes.WINDSWEPT_HILLS, ModBiomes.BEACH, ModBiomes.TAIGA, ModBiomes.RIVER);
//	
//	public static final BadlandsBiome BADLANDS = register("badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.BADLANDS));
//	public static final BadlandsBiome WINDSWEPT_BADLANDS = register("windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.WINDSWEPT_BADLANDS));
//	public static final BadlandsBiome ERODED_BADLANDS = register("eroded_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.ERODED_BADLANDS));
//	public static final BadlandsBiome MODIFIED_WINDSWEPT_BADLANDS = register("modified_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.MODIFIED_WINDSWEPT_BADLANDS));
//	public static final BadlandsBiome WOODED_WINDSWEPT_BADLANDS = register("wooded_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.WOODED_WINDSWEPT_BADLANDS));
//	public static final BadlandsBiome MODIFIED_WOODED_WINDSWEPT_BADLANDS = register("modified_wooded_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.MODIFIED_WOODED_WINDSWEPT_BADLANDS));
//	
//	public static final DesertBiome DESERT = register("desert", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT));
//	public static final DesertBiome DESERT_HILLS = register("desert_hills", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT_HILLS));
//	public static final DesertBiome DESERT_LAKES = register("desert_lakes", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT_LAKES));
//	
//	public static final SavannaBiome SAVANNA = register("savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SAVANNA));
//	public static final SavannaBiome WINDSWEPT_SAVANNA = register("windswept_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.WINDSWEPT_SAVANNA));
//	public static final SavannaBiome SHATTERED_SAVANNA = register("shattered_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SHATTERED_SAVANNA));
//	public static final SavannaBiome SHATTERED_WINDSWEPT_SAVANNA = register("shattered_windswept_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SHATTERED_WINDSWEPT_SAVANNA));
//	
//	public static final JungleBiome JUNGLE = register("jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.JUNGLE));
//	public static final JungleBiome JUNGLE_HILLS = register("jungle_hills", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.JUNGLE_HILLS));
//	public static final JungleBiome MODIFIED_JUNGLE = register("modified_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.MODIFIED_JUNGLE));
//	public static final JungleBiome BAMBOO_JUNGLE = register("bamboo_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.BAMBOO_JUNGLE));
//	public static final JungleBiome BAMBOO_JUNGLE_HILLS = register("bamboo_jungle_hills", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.BAMBOO_JUNGLE_HILLS));
//	public static final JungleBiome SPARSE_JUNGLE = register("sparse_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.SPARSE_JUNGLE));
//	public static final JungleBiome MODIFIED_SPARSE_JUNGLE = register("modified_sparse_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.MODIFIED_SPARSE_JUNGLE));
//	
//	public static final ForestBiome FOREST = register("forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.FOREST));
//	public static final ForestBiome FLOWER_FOREST = register("flower_forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.FLOWER_FOREST));
//	public static final ForestBiome HILLY_FOREST = register("hilly_forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.HILLY_FOREST));
//	
//	public static final ForestBiome BIRCH_FOREST = register("birch_forest", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.BIRCH_FOREST));
//	public static final ForestBiome BIRCH_FOREST_HILLS = register("birch_forest_hills", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.BIRCH_FOREST_HILLS));
//	public static final ForestBiome OLD_GROWTH_BIRCH_FOREST = register("old_growth_birch_forest", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.OLD_GROWTH_BIRCH_FOREST));
//	public static final ForestBiome OLD_GROWTH_BIRCH_FOREST_HILLS = register("old_growth_birch_forest_hills", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.OLD_GROWTH_BIRCH_FOREST_HILLS));
//	
//	public static final ForestBiome DARK_FOREST = register("dark_forest", new ForestBiome(BiomeEffects.DARK_FOREST, ForestBiomeType.DARK_FOREST));
//	public static final ForestBiome DARK_FOREST_HILLS = register("dark_forest_hills", new ForestBiome(BiomeEffects.DARK_FOREST, ForestBiomeType.DARK_FOREST_HILLS));
//	
//	public static final SwampBiome SWAMP = register("swamp", new SwampBiome(BiomeEffects.SWAMP, SwampBiomeType.SWAMP));
//	public static final SwampBiome SWAMP_HILLS = register("swamp_hills", new SwampBiome(BiomeEffects.SWAMP, SwampBiomeType.SWAMP_HILLS));
//	
//	public static final PlainsBiome PLAINS = register("plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.PLAINS));
//	public static final PlainsBiome HILLY_PLAINS = register("hilly_plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.HILLY_PLAINS));
//	public static final PlainsBiome SUNFLOWER_PLAINS = register("sunflower_plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.SUNFLOWER_PLAINS));
//	public static final PlainsBiome SNOWY_PLAINS = register("snowy_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.SNOWY_PLAINS));
//	public static final PlainsBiome SNOWY_HILLY_PLAINS = register("snowy_hilly_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.SNOWY_HILLY_PLAINS));
//	public static final PlainsBiome ICE_SPIKES_PLAINS = register("ice_spikes_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.ICE_SPIKES_PLAINS));
//	
//	public static final OceanBiome OCEAN = register("ocean", new OceanBiome(BiomeEffects.OCEAN, OceanBiomeType.OCEAN));
//	public static final OceanBiome DEEP_OCEAN = register("deep_ocean", new OceanBiome(BiomeEffects.OCEAN, OceanBiomeType.DEEP_OCEAN));
//	public static final OceanBiome WARM_OCEAN = register("warm_ocean", new OceanBiome(BiomeEffects.WARM_OCEAN, OceanBiomeType.WARM_OCEAN));
//	public static final OceanBiome DEEP_WARM_OCEAN = register("deep_warm_ocean", new OceanBiome(BiomeEffects.WARM_OCEAN, OceanBiomeType.DEEP_WARM_OCEAN));
//	public static final OceanBiome LUKEWARM_OCEAN = register("lukewarm_ocean", new OceanBiome(BiomeEffects.LUKEWARM_OCEAN, OceanBiomeType.LUKEWARM_OCEAN));
//	public static final OceanBiome DEEP_LUKEWARM_OCEAN = register("deep_lukewarm_ocean", new OceanBiome(BiomeEffects.LUKEWARM_OCEAN, OceanBiomeType.DEEP_LUKEWARM_OCEAN));
//	public static final OceanBiome COLD_OCEAN = register("cold_ocean", new OceanBiome(BiomeEffects.COLD_OCEAN, OceanBiomeType.COLD_OCEAN));
//	public static final OceanBiome DEEP_COLD_OCEAN = register("deep_cold_ocean", new OceanBiome(BiomeEffects.COLD_OCEAN, OceanBiomeType.DEEP_COLD_OCEAN));
//	public static final OceanBiome FROZEN_OCEAN = register("frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.FROZEN_OCEAN));
//	public static final OceanBiome DEEP_FROZEN_OCEAN = register("deep_frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.DEEP_FROZEN_OCEAN));
//	public static final OceanBiome LEGACY_FORZEN_OCEAN = register("leagacy_frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.LEGACY_FORZEN_OCEAN));
//	public static final DeepdarkOceanBiome DEEPDARK_OCEAN = register("deepdark_ocean", new DeepdarkOceanBiome(BiomeEffects.DEEPDARK_OCEAN, OceanBiomeType.DEEPDARK_OCEAN));
//	
//	public static final MushroomFieldsBiome MUSHROOM_FIELDS = register("mushroom_fields", new MushroomFieldsBiome(BiomeEffects.MUSHROOM_FIELDS, MushroomFieldsBiomeType.MUSHROOM_FIELDS));
//	public static final MushroomFieldsBiome MUSHROOM_FIELD_SHORE = register("mushroom_field_shore", new MushroomFieldsBiome(BiomeEffects.MUSHROOM_FIELDS, MushroomFieldsBiomeType.MUSHROOM_FIELD_SHORE));
//	
//	public static final WindsweptBiome WINDSWEPT_HILLS = register("windswept_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_HILLS));
//	public static final WindsweptBiome WINDSWEPT_EDGE_HILLS = register("windswept_edge_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_EDGE_HILLS));
//	public static final WindsweptBiome WINDSWEPT_GRAVELLY_HILLS = register("windswept_gravelly_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_GRAVELLY_HILLS));
//	public static final WindsweptBiome MODIFIED_WINDSWEPT_GRAVELLY_HILLS = register("modified_windswept_gravelly_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.MODIFIED_WINDSWEPT_GRAVELLY_HILLS));
//	public static final WindsweptBiome WOODED_WINDSWEPT_HILLS = register("wooded_windswept_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WOODED_WINDSWEPT_HILLS));
//	public static final WindsweptBiome SNOWY_WINDSWEPT_HILLS = register("snowy_windswept_hills", new WindsweptBiome(BiomeEffects.SNOWY_WINDSWEPT_HILLS, WindsweptBiomeType.SNOWY_WINDSWEPT_HILLS));
//	
//	public static final PeakBiome MEADOW = register("meadow", new PeakBiome(BiomeEffects.MEADOW, PeakBiomeType.MEADOW));
//	public static final PeakBiome GROVE = register("grove", new PeakBiome(BiomeEffects.GROVE, PeakBiomeType.GROVE));
//	public static final PeakBiome SNOWY_GROVE = register("snowy_grove", new PeakBiome(BiomeEffects.GROVE, PeakBiomeType.SNOWY_GROVE));
//	public static final PeakBiome SNOWY_SLOPES = register("snowy_slopes", new PeakBiome(BiomeEffects.SNOWY_SLOPES, PeakBiomeType.SNOWY_SLOPES));
//	public static final PeakBiome JAGGED_PEAKS = register("jagged_peaks", new PeakBiome(BiomeEffects.JAGGED_PEAKS, PeakBiomeType.JAGGED_PEAKS));
//	public static final PeakBiome FROZEN_PEAKS = register("frozen_peaks", new PeakBiome(BiomeEffects.FROZEN_PEAKS, PeakBiomeType.FROZEN_PEAKS));
//	public static final PeakBiome STONY_PEAKS = register("stony_peaks", new PeakBiome(BiomeEffects.STONY_PEAKS, PeakBiomeType.STONY_PEAKS));
//	
//	public static final BeachBiome BEACH = register("beach", new BeachBiome(BiomeEffects.BEACH, BeachBiomeType.BEACH));
//	public static final BeachBiome SNOWY_BEACH = register("snowy_beach", new BeachBiome(BiomeEffects.SNOWY_BEACH, BeachBiomeType.SNOWY_BEACH));
//	public static final BeachBiome STONY_SHORE = register("stony_shore", new BeachBiome(BiomeEffects.STONY_SHORE, BeachBiomeType.STONY_SHORE));
//	
//	public static final ForestBiome TAIGA = register("taiga", new ForestBiome(BiomeEffects.TAIGA, ForestBiomeType.TAIGA));
//	public static final ForestBiome TAIGA_HILLS = register("taiga_hills", new ForestBiome(BiomeEffects.TAIGA, ForestBiomeType.TAIGA_HILLS));
//	public static final ForestBiome SNOWY_TAIGA = register("snowy_taiga", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_TAIGA));
//	public static final ForestBiome SNOWY_TAIGA_HILLS = register("snowy_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_TAIGA_HILLS));
//	public static final ForestBiome WINDSWEPT_TAIGA_HILLS = register("windswept_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.WINDSWEPT_TAIGA_HILLS));
//	public static final ForestBiome SNOWY_WINDSWEPT_TAIGA_HILLS = register("snowy_windswept_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_WINDSWEPT_TAIGA_HILLS));
//	
//	public static final OldGrowthBiome OLD_GROWTH_SPRUCE_TAIGA = register("old_growth_spruce_taiga", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_SPRUCE_TAIGA));
//	public static final OldGrowthBiome OLD_GROWTH_SPRUCE_TAIGA_HILLS = register("old_growth_spruce_taiga_hills", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_SPRUCE_TAIGA_HILLS));
//	public static final OldGrowthBiome OLD_GROWTH_PINE_TAIGA = register("old_growth_pine_taiga", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_PINE_TAIGA));
//	public static final OldGrowthBiome OLD_GROWTH_PINE_TAIGA_HILLS = register("old_growth_pine_taiga_hills", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_PINE_TAIGA_HILLS));
//	
//	public static final RiverBiome RIVER = register("river", new RiverBiome(BiomeEffects.RIVER, RiverBiomeType.RIVER));
//	public static final RiverBiome FROZEN_RIVER = register("frozen_river", new RiverBiome(BiomeEffects.FROZEN_RIVER, RiverBiomeType.FROZEN_RIVER));
//	
//	public static final DripstoneCaveBiome DRIPSTONE_CAVE = register("dripstone_cave", new DripstoneCaveBiome(BiomeEffects.DRIPSTONE_CAVE, CaveBiomeType.DRIPSTONE_CAVE));
//	public static final LushCavesBiome LUSH_CAVES = register("lush_caves", new LushCavesBiome(BiomeEffects.LUSH_CAVES, CaveBiomeType.LUSH_CAVES));
//	
//	protected static <T extends IBiome> T register(String name, T biome) {
//		REGISTRY_BIOMES.put(biome, BIOMES.register(name, IBiome.createBiome(biome)));
//		BIOME_IDS.put(new ResourceLocation(Nero.MOD_ID, name), biome);
//		return biome;
//	}
	
}
