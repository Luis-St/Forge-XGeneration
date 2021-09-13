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
	
	public static final ResourceKey<Biome> ICY = register("icy");
	public static final ResourceKey<Biome> COLD = register("cold");
	public static final ResourceKey<Biome> MEDIUM = register("medium");
	public static final ResourceKey<Biome> WARM = register("warm");
	public static final ResourceKey<Biome> HOT = register("hot");
	
	public static final ResourceKey<Biome> DRIZZLE = register("drizzle");
	public static final ResourceKey<Biome> LIGHT = register("light");
	public static final ResourceKey<Biome> MODERATE = register("moderate");
	public static final ResourceKey<Biome> STRONG = register("strong");
	public static final ResourceKey<Biome> MONSOON = register("monsoon");
	
	private static ResourceKey<Biome> register(String biomeName) {
		ResourceKey<Biome> resourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Nero.MOD_ID, biomeName));
		BIOMES.add(resourceKey);
		return resourceKey;
	}
}
