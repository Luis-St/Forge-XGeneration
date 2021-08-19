package net.luis.nero.init.world.biome;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.nero.Nero;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeKeys {
	
	public static final List<ResourceKey<Biome>> BIOMES = Lists.newArrayList();
	
	public static final ResourceKey<Biome> DEEPSLATE = register("deepslate");
	public static final ResourceKey<Biome> DEEPSLATE_OCEAN = register("deepslate_ocean");
	public static final ResourceKey<Biome> DEEPSLATE_LAVA_LAKE = register("deepslate_lava_lake");
	public static final ResourceKey<Biome> DEEPDARK = register("deepdark");
	public static final ResourceKey<Biome> LUSH_CAVES = register("lush_caves");
	public static final ResourceKey<Biome> DRIPSTONE_CAVE = register("dripstone_cave");
	
	private static ResourceKey<Biome> register(String biomeName) {
		ResourceKey<Biome> resourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Nero.MOD_ID, biomeName));
		BIOMES.add(resourceKey);
		return resourceKey;
	}
}
