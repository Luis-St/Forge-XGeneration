package net.luis.nero.init.world.biome;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateLavaLakeBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateOceanBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DeepdarkCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DripstoneCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.LushCaveBiome;
import net.luis.nero.common.world.biome.overworld.ClimateBiome;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	
	public static final RegistryObject<Biome> DEEPSLATE = BIOMES.register("deepslate", new DeepslateBiome()::createBiome);
	public static final RegistryObject<Biome> DEEPSLATE_OCEAN = BIOMES.register("deepslate_ocean", new DeepslateOceanBiome()::createBiome);
	public static final RegistryObject<Biome> DEEPSLATE_LAVA_LAKE = BIOMES.register("deepslate_lava_lake", new DeepslateLavaLakeBiome()::createBiome);
	public static final RegistryObject<Biome> DEEPDARK = BIOMES.register("deepdark", new DeepdarkCaveBiome()::createBiome);
	public static final RegistryObject<Biome> LUSH_CAVES = BIOMES.register("lush_caves", new LushCaveBiome()::createBiome);
	public static final RegistryObject<Biome> DRIPSTONE_CAVE = BIOMES.register("dripstone_cave", new DripstoneCaveBiome()::createBiome);
	
	public static final RegistryObject<Biome> ICY = BIOMES.register("icy", new ClimateBiome(-1.0f, 9983)::createBiome);
	public static final RegistryObject<Biome> COLD = BIOMES.register("cold", new ClimateBiome(0.0f, 65535)::createBiome);
	public static final RegistryObject<Biome> MEDIUM = BIOMES.register("medium", new ClimateBiome(0.5f, 5046016)::createBiome);
	public static final RegistryObject<Biome> WARM = BIOMES.register("warm", new ClimateBiome(1.0f, 16738816)::createBiome);
	public static final RegistryObject<Biome> HOT = BIOMES.register("hot", new ClimateBiome(2.0f, 16711680)::createBiome);
	
	public static final RegistryObject<Biome> DRIZZLE = BIOMES.register("drizzle", new ClimateBiome(0.5f, 48895)::createBiome);
	public static final RegistryObject<Biome> LIGHT = BIOMES.register("light", new ClimateBiome(0.5f, 38655)::createBiome);
	public static final RegistryObject<Biome> MODERATE = BIOMES.register("moderate", new ClimateBiome(0.5f, 25855)::createBiome);
	public static final RegistryObject<Biome> STRONG = BIOMES.register("strong", new ClimateBiome(0.5f, 11796700)::createBiome);
	public static final RegistryObject<Biome> MONSOON = BIOMES.register("monsoon", new ClimateBiome(0.5f, 16747520)::createBiome);
	
	
}
