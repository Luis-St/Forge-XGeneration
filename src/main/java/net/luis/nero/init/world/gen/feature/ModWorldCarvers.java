package net.luis.nero.init.world.gen.feature;

import net.luis.nero.Nero;
import net.luis.nero.api.common.world.gen.carver.ModCanyonWorldCarver;
import net.luis.nero.api.common.world.gen.carver.ModCaveWorldCarver;
import net.luis.nero.common.world.gen.carver.canyon.HigherCanyon;
import net.luis.nero.common.world.gen.carver.canyon.LargeCanyon;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldCarvers {
	
	public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Nero.MOD_ID);
	
	public static final RegistryObject<WorldCarver<CanyonCarverConfiguration>> CANYON = WORLD_CARVERS.register("canyon", ModCanyonWorldCarver::new);
	public static final RegistryObject<WorldCarver<CaveCarverConfiguration>> CAVE = WORLD_CARVERS.register("cave", ModCaveWorldCarver::new);
	
	// TODO: add more custom cave and canyons
	
	public static final RegistryObject<WorldCarver<CanyonCarverConfiguration>> LARGE_CANYON = WORLD_CARVERS.register("large_canyon", LargeCanyon::new);
	public static final RegistryObject<WorldCarver<CanyonCarverConfiguration>> HIGHER_CANYON = WORLD_CARVERS.register("higher_canyon", HigherCanyon::new); 
	
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEEP_LAVA_CAVE = WORLD_CARVERS.register("deep_lava_cave", DeepLavaCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> FLAT_CAVE = WORLD_CARVERS.register("flat_cave", FlatCave::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEEP_CAVE = WORLD_CARVERS.register("deep_cave", DeepCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEFAULT_CAVE = WORLD_CARVERS.register("default_cave", DefaultCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> SMALL_CAVE = WORLD_CARVERS.register("small_cave", SmallCave::new);
	
}
