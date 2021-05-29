package net.luis.nero.init.world.biome;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.DeepslateBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	
	public static final RegistryObject<Biome> DEEPSLATE = BIOMES.register("deepslate", new DeepslateBiome()::createBiome);
	
}
