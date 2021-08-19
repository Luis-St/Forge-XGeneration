package net.luis.nero.init.world.biome;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.DeepslateBiome;
import net.luis.nero.common.world.biome.DeepslateLavaLakeBiome;
import net.luis.nero.common.world.biome.DeepslateOceanBiome;
import net.luis.nero.common.world.biome.cave.DeepdarkCaveBiome;
import net.luis.nero.common.world.biome.cave.DripstoneCaveBiome;
import net.luis.nero.common.world.biome.cave.LushCaveBiome;
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
	
}
