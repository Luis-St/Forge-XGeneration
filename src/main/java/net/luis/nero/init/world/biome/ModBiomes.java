package net.luis.nero.init.world.biome;

import java.util.Map;

import com.google.common.collect.Maps;

import net.luis.nero.Nero;
import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateLavaLakeBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateOceanBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DeepslateDeepdarkCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DeepslateDripstoneCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DeepslateLushCaveBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.TempBiome;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	public static final Map<String, IBiome> BIOMES = Maps.newHashMap();
	
	
	public static final DeepslateBiome DEEPSLATE = register("deepslate", new DeepslateBiome(BiomeEffects.DEEPSLATE));
	public static final DeepslateOceanBiome DEEPSLATE_OCEAN = register("deepslate_ocean", new DeepslateOceanBiome(BiomeEffects.DEEPSLATE_OCEAN));
	public static final DeepslateLavaLakeBiome DEEPSLATE_LAVA_LAKE = register("deepslate_lava_lake", new DeepslateLavaLakeBiome(BiomeEffects.DEEPSLATE_LAVA_LAKE));
	public static final DeepslateDeepdarkCaveBiome DEEPDARK = register("deepdark", new DeepslateDeepdarkCaveBiome(BiomeEffects.DEEPDARK));
	public static final DeepslateLushCaveBiome LUSH_CAVES = register("lush_caves", new DeepslateLushCaveBiome(BiomeEffects.LUSH_CAVE));
	public static final DeepslateDripstoneCaveBiome DRIPSTONE_CAVE = register("dripstone_cave", new DeepslateDripstoneCaveBiome(BiomeEffects.DRIPSTONE_CAVE));
	
	public static final TempBiome CLIMATE_ICY = register("climate_icy", new TempBiome(-1.0F, 9983));
	public static final TempBiome CLIMATE_COLD = register("climate_cold", new TempBiome(0.5F, 65535));
	public static final TempBiome CLIMATE_MEDIUM = register("climate_medium", new TempBiome(0.5F, 5046016));
	public static final TempBiome CLIMATE_WARM = register("climate_warm", new TempBiome(1.0F, 16738816));
	public static final TempBiome CLIMATE_HOT = register("climate_hot", new TempBiome(2.0F, 16711680));
	
	public static final TempBiome CLIMATE_DRIZZLE = register("climate_drizzle", new TempBiome(0.5F, 48895));
	public static final TempBiome CLIMATE_LIGHT = register("climate_light", new TempBiome(0.5F, 38655));
	public static final TempBiome CLIMATE_MODERATE = register("climate_moderate", new TempBiome(0.5F, 25855));
	public static final TempBiome CLIMATE_STRONG = register("climate_strong", new TempBiome(0.5F, 11796700));
	public static final TempBiome CLIMATE_MONSOON = register("climate_monsoon", new TempBiome(0.5F, 16747520));
	
	protected static <T extends IBiome> T register(String name, T biome) {
		BIOME_REGISTRY.register(name, IBiome.createBiome(biome));
		BIOMES.put(name, biome);
		return biome;
	}
	
}
