package net.luis.nero.init.world.biome;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.nero.Nero;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeKeys {
	
	public static final List<ResourceKey<Biome>> BIOMES = Lists.newArrayList();
	public static final Map<Integer, ResourceKey<Biome>> BIOME_IDS = Maps.newLinkedHashMap();
	
	public static final ResourceKey<Biome> DEEPSLATE = register("deepslate", -1);
	
	private static ResourceKey<Biome> register(String biomeName, int id) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Nero.MOD_ID, biomeName));
		BIOMES.add(key);
		BIOME_IDS.put(id, key);
		return key;
	}
	
	public static ResourceKey<Biome> byId(int id) {
		if (!BIOME_IDS.containsKey(id)) {
			return null;
		} else {
			return BIOME_IDS.get(id);
		}
	}
	
}
