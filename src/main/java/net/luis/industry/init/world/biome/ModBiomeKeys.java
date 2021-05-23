package net.luis.industry.init.world.biome;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.industry.Industry;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {
	
	public static final List<RegistryKey<Biome>> BIOMES = Lists.newArrayList();
	public static final Map<Integer, RegistryKey<Biome>> BIOME_IDS = Maps.newLinkedHashMap();
	
	public static final RegistryKey<Biome> DEEPSLATE = register("deepslate", -1);
	
	private static RegistryKey<Biome> register(String biomeName, int id) {
		RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Industry.MOD_ID, biomeName));
		BIOMES.add(key);
		BIOME_IDS.put(id, key);
		return key;
	}
	
	public static RegistryKey<Biome> byId(int id) {
		if (!BIOME_IDS.containsKey(id)) {
			return null;
		} else {
			return BIOME_IDS.get(id);
		}
	}
	
}
