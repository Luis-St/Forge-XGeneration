package net.luis.industry.init.world;

import net.luis.industry.Industry;
import net.luis.industry.common.world.biome.DeepslateCaveBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Industry.MOD_ID);
	
	public static final RegistryKey<Biome> DEEPSLATE_CAVE = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Industry.MOD_ID, "deepslate_cave"));
	public static final RegistryObject<Biome> DEEPSLATE_CAVE_BIOME = BIOMES.register("deepslate_cave", 
			() -> new DeepslateCaveBiome().createBiome(new Biome.Builder()));
	
}
