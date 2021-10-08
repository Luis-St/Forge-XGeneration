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
	
	public static final ResourceKey<Biome> CLIMATE_ICY = register("climate_icy");
	public static final ResourceKey<Biome> CLIMATE_COLD = register("climate_cold");
	public static final ResourceKey<Biome> CLIMATE_MEDIUM = register("climate_medium");
	public static final ResourceKey<Biome> CLIMATE_WARM = register("climate_warm");
	public static final ResourceKey<Biome> CLIMATE_HOT = register("climate_hot");
	
	public static final ResourceKey<Biome> CLIMATE_DRIZZLE = register("climate_drizzle");
	public static final ResourceKey<Biome> CLIMATE_LIGHT = register("climate_light");
	public static final ResourceKey<Biome> CLIMATE_MODERATE = register("climate_moderate");
	public static final ResourceKey<Biome> CLIMATE_STRONG = register("climate_strong");
	public static final ResourceKey<Biome> CLIMATE_MONSOON = register("climate_monsoon");
	
	protected static ResourceKey<Biome> register(String biomeName) {
		ResourceKey<Biome> resourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Nero.MOD_ID, biomeName));
		BIOMES.add(resourceKey);
		return resourceKey;
	}
}
