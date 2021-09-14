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
import net.luis.nero.common.world.biome.overworld.ClimateBiome;
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
	
	public static final ClimateBiome ICY = register("icy", new ClimateBiome(-1.0f, 9983));
	public static final ClimateBiome COLD = register("cold", new ClimateBiome(0.0f, 65535));
	public static final ClimateBiome MEDIUM = register("medium", new ClimateBiome(0.5f, 5046016));
	public static final ClimateBiome WARM = register("warm", new ClimateBiome(1.0f, 16738816));
	public static final ClimateBiome HOT = register("hot", new ClimateBiome(2.0f, 16711680));
	
	public static final ClimateBiome DRIZZLE = register("drizzle", new ClimateBiome(0.5f, 48895));
	public static final ClimateBiome LIGHT = register("light", new ClimateBiome(0.5f, 38655));
	public static final ClimateBiome MODERATE = register("moderate", new ClimateBiome(0.5f, 25855));
	public static final ClimateBiome STRONG = register("strong", new ClimateBiome(0.5f, 11796700));
	public static final ClimateBiome MONSOON = register("monsoon", new ClimateBiome(0.5f, 16747520));
	
	public static <T extends IBiome> T register(String name, T biome) {
		BIOME_REGISTRY.register(name, IBiome.createBiome(biome));
		BIOMES.put(name, biome);
		return biome;
	}
	
}
