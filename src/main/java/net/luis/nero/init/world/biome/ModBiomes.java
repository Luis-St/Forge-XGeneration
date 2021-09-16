package net.luis.nero.init.world.biome;

import java.util.Map;

import com.google.common.collect.Maps;

import net.luis.nero.Nero;
import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateLavaLakeBiome;
import net.luis.nero.common.world.biome.deepslate.DeepslateOceanBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DeepdarkCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.DripstoneCaveBiome;
import net.luis.nero.common.world.biome.deepslate.cave.LushCaveBiome;
import net.luis.nero.common.world.biome.overworld.TempBiome;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, Nero.MOD_ID);
	public static final Map<String, IBiome> BIOMES = Maps.newHashMap();
	
	
	public static final DeepslateBiome DEEPSLATE = register("deepslate", new DeepslateBiome());
	public static final DeepslateOceanBiome DEEPSLATE_OCEAN = register("deepslate_ocean", new DeepslateOceanBiome());
	public static final DeepslateLavaLakeBiome DEEPSLATE_LAVA_LAKE = register("deepslate_lava_lake", new DeepslateLavaLakeBiome());
	public static final DeepdarkCaveBiome DEEPDARK = register("deepdark", new DeepdarkCaveBiome());
	public static final LushCaveBiome LUSH_CAVES = register("lush_caves", new LushCaveBiome());
	public static final DripstoneCaveBiome DRIPSTONE_CAVE = register("dripstone_cave", new DripstoneCaveBiome());
	
	public static final TempBiome ICY = register("icy", new TempBiome(-1.0f, 9983));
	public static final TempBiome COLD = register("cold", new TempBiome(0.0f, 65535));
	public static final TempBiome MEDIUM = register("medium", new TempBiome(0.5f, 5046016));
	public static final TempBiome WARM = register("warm", new TempBiome(1.0f, 16738816));
	public static final TempBiome HOT = register("hot", new TempBiome(2.0f, 16711680));
	
	public static final TempBiome DRIZZLE = register("drizzle", new TempBiome(0.5f, 48895));
	public static final TempBiome LIGHT = register("light", new TempBiome(0.5f, 38655));
	public static final TempBiome MODERATE = register("moderate", new TempBiome(0.5f, 25855));
	public static final TempBiome STRONG = register("strong", new TempBiome(0.5f, 11796700));
	public static final TempBiome MONSOON = register("monsoon", new TempBiome(0.5f, 16747520));
	
	public static <T extends IBiome> T register(String name, T biome) {
		BIOME_REGISTRY.register(name, IBiome.createBiome(biome));
		BIOMES.put(name, biome);
		return biome;
	}
	
}
