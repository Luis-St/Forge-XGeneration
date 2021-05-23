package net.luis.industry.init.world.biome;

import net.luis.industry.Industry;
import net.luis.industry.common.world.biome.DeepslateBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Industry.MOD_ID);
	
	public static final RegistryObject<Biome> DEEPSLATE = BIOMES.register("deepslate", new DeepslateBiome()::createBiome);
	
}
