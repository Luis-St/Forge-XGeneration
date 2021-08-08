package net.luis.nero.init.world.gen.carver;

import net.luis.nero.Nero;
import net.luis.nero.api.common.world.gen.carver.ModCanyonWorldCarver;
import net.luis.nero.api.common.world.gen.carver.ModCaveWorldCarver;
import net.luis.nero.api.common.world.gen.carver.config.ModCanyonCarverConfiguration;
import net.luis.nero.api.common.world.gen.carver.config.ModCaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldCarvers {
	
	public static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, Nero.MOD_ID);
	
	
	public static final RegistryObject<ModCaveWorldCarver> CAVE = WORLD_CARVERS.register("cave", () -> new ModCaveWorldCarver(ModCaveCarverConfiguration.CODEC));
	public static final RegistryObject<ModCanyonWorldCarver> CANYON = WORLD_CARVERS.register("canyon", () -> new ModCanyonWorldCarver(ModCanyonCarverConfiguration.CODEC));
	
}
