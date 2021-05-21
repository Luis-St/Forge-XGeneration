package net.luis.industry.init.world;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.industry.Industry;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {
	
	public static final List<RegistryKey<Biome>> BIOMES = Lists.newArrayList();
	
	public static final RegistryKey<Biome> DEEPSLATE = register("deepslate");
	
	private static RegistryKey<Biome> register(String biomeName) {
		RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Industry.MOD_ID, biomeName));
		BIOMES.add(key);
		return key;
	}

}
