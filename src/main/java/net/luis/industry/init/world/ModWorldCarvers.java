package net.luis.industry.init.world;

import net.luis.industry.Industry;
import net.luis.industry.common.world.carver.canyon.LargeCanyon;
import net.luis.industry.common.world.carver.canyon.ModCanyonWorldCarver;
import net.luis.industry.common.world.carver.cave.ModCaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldCarvers {
	
	public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Industry.MOD_ID);
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> CANYON = WORLD_CARVERS.register("canyon", ModCanyonWorldCarver::new);
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVE = WORLD_CARVERS.register("cave", ModCaveWorldCarver::new);
	
	// TODO: add mor custom cave and canyons
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> LARGE_CANYON = WORLD_CARVERS.register("large_canyon", LargeCanyon::new); 
	
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEEP_LAVA_CAVE = WORLD_CARVERS.register("deep_lava_cave", DeepLavaCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> FLAT_CAVE = WORLD_CARVERS.register("flat_cave", FlatCave::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEEP_CAVE = WORLD_CARVERS.register("deep_cave", DeepCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> DEFAULT_CAVE = WORLD_CARVERS.register("default_cave", DefaultCaveWorldCarver::new);
//	public static final RegistryObject<WorldCarver<ProbabilityConfig>> SMALL_CAVE = WORLD_CARVERS.register("small_cave", SmallCave::new);
	
}
