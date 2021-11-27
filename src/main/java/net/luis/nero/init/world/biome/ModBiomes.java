package net.luis.nero.init.world.biome;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.luis.nero.Nero;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.IBiome;
import net.luis.nero.common.world.biome.biomes.TempBiome;
import net.luis.nero.common.world.biome.biomes.type.BadlandsBiomeType;
import net.luis.nero.common.world.biome.biomes.type.BeachBiomeType;
import net.luis.nero.common.world.biome.biomes.type.CaveBiomeType;
import net.luis.nero.common.world.biome.biomes.type.DesertBiomeType;
import net.luis.nero.common.world.biome.biomes.type.ForestBiomeType;
import net.luis.nero.common.world.biome.biomes.type.JungleBiomeType;
import net.luis.nero.common.world.biome.biomes.type.MushroomFieldsBiomeType;
import net.luis.nero.common.world.biome.biomes.type.OceanBiomeType;
import net.luis.nero.common.world.biome.biomes.type.OldGrowthBiomeType;
import net.luis.nero.common.world.biome.biomes.type.PeakBiomeType;
import net.luis.nero.common.world.biome.biomes.type.PlainsBiomeType;
import net.luis.nero.common.world.biome.biomes.type.RiverBiomeType;
import net.luis.nero.common.world.biome.biomes.type.SavannaBiomeType;
import net.luis.nero.common.world.biome.biomes.type.SwampBiomeType;
import net.luis.nero.common.world.biome.biomes.type.WindsweptBiomeType;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.BadlandsBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.BeachBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.DeepdarkOceanBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.DesertBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.DripstoneCaveBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.ForestBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.JungleBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.LushCavesBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.MushroomFieldsBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.OceanBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.OldGrowthBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.PeakBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.PlainsBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.RiverBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.SavannaBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.SwampBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.WindsweptBiome;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("removal")
public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	public static final Map<IBiome, RegistryObject<Biome>> REGISTRY_BIOMES = Maps.newHashMap();
	public static final Map<ResourceLocation, IBiome> BIOME_IDS = Maps.newHashMap();
	
	public static final Set<IBiome> MAIN_BIOMES = Sets.newHashSet(ModBiomes.BADLANDS, ModBiomes.DESERT, ModBiomes.SAVANNA, ModBiomes.JUNGLE, ModBiomes.FOREST, ModBiomes.BIRCH_FOREST, ModBiomes.DARK_FOREST,
			ModBiomes.SWAMP, ModBiomes.PLAINS, ModBiomes.SNOWY_PLAINS, ModBiomes.OCEAN, ModBiomes.MUSHROOM_FIELDS, ModBiomes.WINDSWEPT_HILLS, ModBiomes.BEACH, ModBiomes.TAIGA, ModBiomes.RIVER);
	
	public static final TempBiome CLIMATE_ICY = register("climate_icy", new TempBiome(BiomeEffects.CLIMATE_ICY));
	public static final TempBiome CLIMATE_COLD = register("climate_cold", new TempBiome(BiomeEffects.CLIMATE_COLD));
	public static final TempBiome CLIMATE_MEDIUM = register("climate_medium", new TempBiome(BiomeEffects.CLIMATE_MEDIUM));
	public static final TempBiome CLIMATE_WARM = register("climate_warm", new TempBiome(BiomeEffects.CLIMATE_WARM));
	public static final TempBiome CLIMATE_HOT = register("climate_hot", new TempBiome(BiomeEffects.CLIMATE_HOT));
	
	public static final TempBiome CLIMATE_DRIZZLE = register("climate_drizzle", new TempBiome(BiomeEffects.CLIMATE_DRIZZLE));
	public static final TempBiome CLIMATE_LIGHT = register("climate_light", new TempBiome(BiomeEffects.CLIMATE_LIGHT));
	public static final TempBiome CLIMATE_MODERATE = register("climate_moderate", new TempBiome(BiomeEffects.CLIMATE_MODERATE));
	public static final TempBiome CLIMATE_STRONG = register("climate_strong", new TempBiome(BiomeEffects.CLIMATE_STRONG));
	public static final TempBiome CLIMATE_MONSOON = register("climate_monsoon", new TempBiome(BiomeEffects.CLIMATE_MONSOON));
	
	@Deprecated(forRemoval = true) public static final BadlandsBiome BADLANDS = register("badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.BADLANDS));
	@Deprecated(forRemoval = true) public static final BadlandsBiome WINDSWEPT_BADLANDS = register("windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.WINDSWEPT_BADLANDS));
	@Deprecated(forRemoval = true) public static final BadlandsBiome ERODED_BADLANDS = register("eroded_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.ERODED_BADLANDS));
	@Deprecated(forRemoval = true) public static final BadlandsBiome MODIFIED_WINDSWEPT_BADLANDS = register("modified_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.MODIFIED_WINDSWEPT_BADLANDS));
	@Deprecated(forRemoval = true) public static final BadlandsBiome WOODED_WINDSWEPT_BADLANDS = register("wooded_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.WOODED_WINDSWEPT_BADLANDS));
	@Deprecated(forRemoval = true) public static final BadlandsBiome MODIFIED_WOODED_WINDSWEPT_BADLANDS = register("modified_wooded_windswept_badlands", new BadlandsBiome(BiomeEffects.BADLANDS, BadlandsBiomeType.MODIFIED_WOODED_WINDSWEPT_BADLANDS));
	
	@Deprecated(forRemoval = true) public static final DesertBiome DESERT = register("desert", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT));
	@Deprecated(forRemoval = true) public static final DesertBiome DESERT_HILLS = register("desert_hills", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT_HILLS));
	@Deprecated(forRemoval = true) public static final DesertBiome DESERT_LAKES = register("desert_lakes", new DesertBiome(BiomeEffects.DESERT, DesertBiomeType.DESERT_LAKES));
	
	@Deprecated(forRemoval = true) public static final SavannaBiome SAVANNA = register("savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SAVANNA));
	@Deprecated(forRemoval = true) public static final SavannaBiome WINDSWEPT_SAVANNA = register("windswept_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.WINDSWEPT_SAVANNA));
	@Deprecated(forRemoval = true) public static final SavannaBiome SHATTERED_SAVANNA = register("shattered_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SHATTERED_SAVANNA));
	@Deprecated(forRemoval = true) public static final SavannaBiome SHATTERED_WINDSWEPT_SAVANNA = register("shattered_windswept_savanna", new SavannaBiome(BiomeEffects.SAVANNA, SavannaBiomeType.SHATTERED_WINDSWEPT_SAVANNA));
	
	@Deprecated(forRemoval = true) public static final JungleBiome JUNGLE = register("jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.JUNGLE));
	@Deprecated(forRemoval = true) public static final JungleBiome JUNGLE_HILLS = register("jungle_hills", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.JUNGLE_HILLS));
	@Deprecated(forRemoval = true) public static final JungleBiome MODIFIED_JUNGLE = register("modified_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.MODIFIED_JUNGLE));
	@Deprecated(forRemoval = true) public static final JungleBiome BAMBOO_JUNGLE = register("bamboo_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.BAMBOO_JUNGLE));
	@Deprecated(forRemoval = true) public static final JungleBiome BAMBOO_JUNGLE_HILLS = register("bamboo_jungle_hills", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.BAMBOO_JUNGLE_HILLS));
	@Deprecated(forRemoval = true) public static final JungleBiome SPARSE_JUNGLE = register("sparse_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.SPARSE_JUNGLE));
	@Deprecated(forRemoval = true) public static final JungleBiome MODIFIED_SPARSE_JUNGLE = register("modified_sparse_jungle", new JungleBiome(BiomeEffects.JUNGLE, JungleBiomeType.MODIFIED_SPARSE_JUNGLE));
	
	@Deprecated(forRemoval = true) public static final ForestBiome FOREST = register("forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.FOREST));
	@Deprecated(forRemoval = true) public static final ForestBiome FLOWER_FOREST = register("flower_forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.FLOWER_FOREST));
	@Deprecated(forRemoval = true) public static final ForestBiome HILLY_FOREST = register("hilly_forest", new ForestBiome(BiomeEffects.FOREST, ForestBiomeType.HILLY_FOREST));
	
	@Deprecated(forRemoval = true) public static final ForestBiome BIRCH_FOREST = register("birch_forest", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.BIRCH_FOREST));
	@Deprecated(forRemoval = true) public static final ForestBiome BIRCH_FOREST_HILLS = register("birch_forest_hills", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.BIRCH_FOREST_HILLS));
	@Deprecated(forRemoval = true) public static final ForestBiome OLD_GROWTH_BIRCH_FOREST = register("old_growth_birch_forest", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.OLD_GROWTH_BIRCH_FOREST));
	@Deprecated(forRemoval = true) public static final ForestBiome OLD_GROWTH_BIRCH_FOREST_HILLS = register("old_growth_birch_forest_hills", new ForestBiome(BiomeEffects.BIRCH_FOREST, ForestBiomeType.OLD_GROWTH_BIRCH_FOREST_HILLS));
	
	@Deprecated(forRemoval = true) public static final ForestBiome DARK_FOREST = register("dark_forest", new ForestBiome(BiomeEffects.DARK_FOREST, ForestBiomeType.DARK_FOREST));
	@Deprecated(forRemoval = true) public static final ForestBiome DARK_FOREST_HILLS = register("dark_forest_hills", new ForestBiome(BiomeEffects.DARK_FOREST, ForestBiomeType.DARK_FOREST_HILLS));
	
	@Deprecated(forRemoval = true) public static final SwampBiome SWAMP = register("swamp", new SwampBiome(BiomeEffects.SWAMP, SwampBiomeType.SWAMP));
	@Deprecated(forRemoval = true) public static final SwampBiome SWAMP_HILLS = register("swamp_hills", new SwampBiome(BiomeEffects.SWAMP, SwampBiomeType.SWAMP_HILLS));
	
	@Deprecated(forRemoval = true) public static final PlainsBiome PLAINS = register("plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.PLAINS));
	@Deprecated(forRemoval = true) public static final PlainsBiome HILLY_PLAINS = register("hilly_plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.HILLY_PLAINS));
	@Deprecated(forRemoval = true) public static final PlainsBiome SUNFLOWER_PLAINS = register("sunflower_plains", new PlainsBiome(BiomeEffects.PLAINS, PlainsBiomeType.SUNFLOWER_PLAINS));
	@Deprecated(forRemoval = true) public static final PlainsBiome SNOWY_PLAINS = register("snowy_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.SNOWY_PLAINS));
	@Deprecated(forRemoval = true) public static final PlainsBiome SNOWY_HILLY_PLAINS = register("snowy_hilly_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.SNOWY_HILLY_PLAINS));
	@Deprecated(forRemoval = true) public static final PlainsBiome ICE_SPIKES_PLAINS = register("ice_spikes_plains", new PlainsBiome(BiomeEffects.SNOWY_PLAINS, PlainsBiomeType.ICE_SPIKES_PLAINS));
	
	@Deprecated(forRemoval = true) public static final OceanBiome OCEAN = register("ocean", new OceanBiome(BiomeEffects.OCEAN, OceanBiomeType.OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome DEEP_OCEAN = register("deep_ocean", new OceanBiome(BiomeEffects.OCEAN, OceanBiomeType.DEEP_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome WARM_OCEAN = register("warm_ocean", new OceanBiome(BiomeEffects.WARM_OCEAN, OceanBiomeType.WARM_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome DEEP_WARM_OCEAN = register("deep_warm_ocean", new OceanBiome(BiomeEffects.WARM_OCEAN, OceanBiomeType.DEEP_WARM_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome LUKEWARM_OCEAN = register("lukewarm_ocean", new OceanBiome(BiomeEffects.LUKEWARM_OCEAN, OceanBiomeType.LUKEWARM_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome DEEP_LUKEWARM_OCEAN = register("deep_lukewarm_ocean", new OceanBiome(BiomeEffects.LUKEWARM_OCEAN, OceanBiomeType.DEEP_LUKEWARM_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome COLD_OCEAN = register("cold_ocean", new OceanBiome(BiomeEffects.COLD_OCEAN, OceanBiomeType.COLD_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome DEEP_COLD_OCEAN = register("deep_cold_ocean", new OceanBiome(BiomeEffects.COLD_OCEAN, OceanBiomeType.DEEP_COLD_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome FROZEN_OCEAN = register("frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.FROZEN_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome DEEP_FROZEN_OCEAN = register("deep_frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.DEEP_FROZEN_OCEAN));
	@Deprecated(forRemoval = true) public static final OceanBiome LEGACY_FORZEN_OCEAN = register("leagacy_frozen_ocean", new OceanBiome(BiomeEffects.FROZEN_OCEAN, OceanBiomeType.LEGACY_FORZEN_OCEAN));
	@Deprecated(forRemoval = true) public static final DeepdarkOceanBiome DEEPDARK_OCEAN = register("deepdark_ocean", new DeepdarkOceanBiome(BiomeEffects.DEEPDARK_OCEAN, OceanBiomeType.DEEPDARK_OCEAN));
	
	@Deprecated(forRemoval = true) public static final MushroomFieldsBiome MUSHROOM_FIELDS = register("mushroom_fields", new MushroomFieldsBiome(BiomeEffects.MUSHROOM_FIELDS, MushroomFieldsBiomeType.MUSHROOM_FIELDS));
	@Deprecated(forRemoval = true) public static final MushroomFieldsBiome MUSHROOM_FIELD_SHORE = register("mushroom_field_shore", new MushroomFieldsBiome(BiomeEffects.MUSHROOM_FIELDS, MushroomFieldsBiomeType.MUSHROOM_FIELD_SHORE));
	
	@Deprecated(forRemoval = true) public static final WindsweptBiome WINDSWEPT_HILLS = register("windswept_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_HILLS));
	@Deprecated(forRemoval = true) public static final WindsweptBiome WINDSWEPT_EDGE_HILLS = register("windswept_edge_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_EDGE_HILLS));
	@Deprecated(forRemoval = true) public static final WindsweptBiome WINDSWEPT_GRAVELLY_HILLS = register("windswept_gravelly_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WINDSWEPT_GRAVELLY_HILLS));
	@Deprecated(forRemoval = true) public static final WindsweptBiome MODIFIED_WINDSWEPT_GRAVELLY_HILLS = register("modified_windswept_gravelly_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.MODIFIED_WINDSWEPT_GRAVELLY_HILLS));
	@Deprecated(forRemoval = true) public static final WindsweptBiome WOODED_WINDSWEPT_HILLS = register("wooded_windswept_hills", new WindsweptBiome(BiomeEffects.WINDSWEPT_HILLS, WindsweptBiomeType.WOODED_WINDSWEPT_HILLS));
	@Deprecated(forRemoval = true) public static final WindsweptBiome SNOWY_WINDSWEPT_HILLS = register("snowy_windswept_hills", new WindsweptBiome(BiomeEffects.SNOWY_WINDSWEPT_HILLS, WindsweptBiomeType.SNOWY_WINDSWEPT_HILLS));
	
	@Deprecated(forRemoval = true) public static final PeakBiome MEADOW = register("meadow", new PeakBiome(BiomeEffects.MEADOW, PeakBiomeType.MEADOW));
	@Deprecated(forRemoval = true) public static final PeakBiome GROVE = register("grove", new PeakBiome(BiomeEffects.GROVE, PeakBiomeType.GROVE));
	@Deprecated(forRemoval = true) public static final PeakBiome SNOWY_GROVE = register("snowy_grove", new PeakBiome(BiomeEffects.GROVE, PeakBiomeType.SNOWY_GROVE));
	@Deprecated(forRemoval = true) public static final PeakBiome SNOWY_SLOPES = register("snowy_slopes", new PeakBiome(BiomeEffects.SNOWY_SLOPES, PeakBiomeType.SNOWY_SLOPES));
	@Deprecated(forRemoval = true) public static final PeakBiome JAGGED_PEAKS = register("jagged_peaks", new PeakBiome(BiomeEffects.JAGGED_PEAKS, PeakBiomeType.JAGGED_PEAKS));
	@Deprecated(forRemoval = true) public static final PeakBiome FROZEN_PEAKS = register("frozen_peaks", new PeakBiome(BiomeEffects.FROZEN_PEAKS, PeakBiomeType.FROZEN_PEAKS));
	@Deprecated(forRemoval = true) public static final PeakBiome STONY_PEAKS = register("stony_peaks", new PeakBiome(BiomeEffects.STONY_PEAKS, PeakBiomeType.STONY_PEAKS));
	
	@Deprecated(forRemoval = true) public static final BeachBiome BEACH = register("beach", new BeachBiome(BiomeEffects.BEACH, BeachBiomeType.BEACH));
	@Deprecated(forRemoval = true) public static final BeachBiome SNOWY_BEACH = register("snowy_beach", new BeachBiome(BiomeEffects.SNOWY_BEACH, BeachBiomeType.SNOWY_BEACH));
	@Deprecated(forRemoval = true) public static final BeachBiome STONY_SHORE = register("stony_shore", new BeachBiome(BiomeEffects.STONY_SHORE, BeachBiomeType.STONY_SHORE));
	
	@Deprecated(forRemoval = true) public static final ForestBiome TAIGA = register("taiga", new ForestBiome(BiomeEffects.TAIGA, ForestBiomeType.TAIGA));
	@Deprecated(forRemoval = true) public static final ForestBiome TAIGA_HILLS = register("taiga_hills", new ForestBiome(BiomeEffects.TAIGA, ForestBiomeType.TAIGA_HILLS));
	@Deprecated(forRemoval = true) public static final ForestBiome SNOWY_TAIGA = register("snowy_taiga", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_TAIGA));
	@Deprecated(forRemoval = true) public static final ForestBiome SNOWY_TAIGA_HILLS = register("snowy_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_TAIGA_HILLS));
	@Deprecated(forRemoval = true) public static final ForestBiome WINDSWEPT_TAIGA_HILLS = register("windswept_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.WINDSWEPT_TAIGA_HILLS));
	@Deprecated(forRemoval = true) public static final ForestBiome SNOWY_WINDSWEPT_TAIGA_HILLS = register("snowy_windswept_taiga_hills", new ForestBiome(BiomeEffects.SNOWY_TAIGA, ForestBiomeType.SNOWY_WINDSWEPT_TAIGA_HILLS));
	
	@Deprecated(forRemoval = true) public static final OldGrowthBiome OLD_GROWTH_SPRUCE_TAIGA = register("old_growth_spruce_taiga", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_SPRUCE_TAIGA));
	@Deprecated(forRemoval = true) public static final OldGrowthBiome OLD_GROWTH_SPRUCE_TAIGA_HILLS = register("old_growth_spruce_taiga_hills", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_SPRUCE_TAIGA_HILLS));
	@Deprecated(forRemoval = true) public static final OldGrowthBiome OLD_GROWTH_PINE_TAIGA = register("old_growth_pine_taiga", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_PINE_TAIGA));
	@Deprecated(forRemoval = true) public static final OldGrowthBiome OLD_GROWTH_PINE_TAIGA_HILLS = register("old_growth_pine_taiga_hills", new OldGrowthBiome(BiomeEffects.OLD_GROWTH_TAIGA, OldGrowthBiomeType.OLD_GROWTH_PINE_TAIGA_HILLS));
	
	@Deprecated(forRemoval = true) public static final RiverBiome RIVER = register("river", new RiverBiome(BiomeEffects.RIVER, RiverBiomeType.RIVER));
	@Deprecated(forRemoval = true) public static final RiverBiome FROZEN_RIVER = register("frozen_river", new RiverBiome(BiomeEffects.FROZEN_RIVER, RiverBiomeType.FROZEN_RIVER));
	
	@Deprecated(forRemoval = true) public static final DripstoneCaveBiome DRIPSTONE_CAVE = register("dripstone_cave", new DripstoneCaveBiome(BiomeEffects.DRIPSTONE_CAVE, CaveBiomeType.DRIPSTONE_CAVE));
	@Deprecated(forRemoval = true) public static final LushCavesBiome LUSH_CAVES = register("lush_caves", new LushCavesBiome(BiomeEffects.LUSH_CAVES, CaveBiomeType.LUSH_CAVES));
	
	protected static <T extends IBiome> T register(String name, T biome) {
		REGISTRY_BIOMES.put(biome, BIOMES.register(name, IBiome.createBiome(biome)));
		BIOME_IDS.put(new ResourceLocation(Nero.MOD_ID, name), biome);
		return biome;
	}
	
}
