package net.luis.nero.common.world.biome;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;

import net.luis.nero.common.world.gen.layer.DeepslateBiomeLayer;
import net.luis.nero.common.world.gen.layer.ModLayer;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

public class DeepslateBiomeProvider extends BiomeSource {

	// TODO: custom tp engine for deepslate dimension

	public static final Codec<DeepslateBiomeProvider> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
			.xmap(DeepslateBiomeProvider::new, DeepslateBiomeProvider::getBiomeRegistry).codec();
	
	private final long seed;
	private final Registry<Biome> biomeRegistry;
	private final ModLayer noiseBiomeLayer;
	private static final List<ResourceKey<Biome>> BIOMES = ModBiomeKeys.BIOMES;
	
	public DeepslateBiomeProvider(Registry<Biome> biomeRegistry) {
		this(biomeRegistry, new Random().nextLong());
	}
	
	public DeepslateBiomeProvider(Registry<Biome> biomeRegistry, long seed) {
		super(getStartBiomes(biomeRegistry));
		this.seed = seed;
		this.biomeRegistry = biomeRegistry;
		this.noiseBiomeLayer = DeepslateBiomeLayer.createLayer(seed);
	}

	private static List<Biome> getStartBiomes(Registry<Biome> registry) {
		return BIOMES.stream().map(biome -> registry.get(biome.location())).collect(Collectors.toList());
	}
	
	public long getSeed() {
		return seed;
	}
	
	public Registry<Biome> getBiomeRegistry() {
		return this.biomeRegistry;
	}

	@Override
	public boolean canGenerateStructure(StructureFeature<?> structure) {
		return false;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return DeepslateBiomeProvider.CODEC;
	}

	@Override
	public DeepslateBiomeProvider withSeed(long seed) {
		return new DeepslateBiomeProvider(this.biomeRegistry, seed);
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.noiseBiomeLayer.get(this.biomeRegistry, x, z);
	}

}