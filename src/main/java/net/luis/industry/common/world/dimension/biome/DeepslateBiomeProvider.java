package net.luis.industry.common.world.dimension.biome;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;

import net.luis.industry.common.world.dimension.biome.layer.DeepslateBiomeLayer;
import net.luis.industry.common.world.dimension.biome.layer.ModLayer;
import net.luis.industry.init.world.ModBiomeKeys;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

public class DeepslateBiomeProvider extends BiomeProvider {

	// TODO Deepslate cave biome -> deepslate

	public static final Codec<DeepslateBiomeProvider> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
			.xmap(DeepslateBiomeProvider::new, DeepslateBiomeProvider::getBiomeRegistry).codec();

	private final ModLayer noiseBiomeLayer;
	private final Registry<Biome> biomeRegistry;
	private static final List<RegistryKey<Biome>> BIOMES = ModBiomeKeys.BIOMES;

	public DeepslateBiomeProvider(Registry<Biome> biomeRegistry) {
		super(getStartBiomes(biomeRegistry));
		this.biomeRegistry = biomeRegistry;
		this.noiseBiomeLayer = DeepslateBiomeLayer.createLayer(new Random().nextLong());
	}

	private static List<Biome> getStartBiomes(Registry<Biome> registry) {
		return DeepslateBiomeProvider.BIOMES.stream().map(biome -> registry.get(biome.location())).collect(Collectors.toList());
	}
	
	public Registry<Biome> getBiomeRegistry() {
		return this.biomeRegistry;
	}

	@Override
	public boolean canGenerateStructure(Structure<?> structure) {
		return false;
	}

	@Override
	protected Codec<? extends BiomeProvider> codec() {
		return DeepslateBiomeProvider.CODEC;
	}

	@Override
	public BiomeProvider withSeed(long seed) {
		return this;
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		// TODO: custom layer
		return this.noiseBiomeLayer.get(this.biomeRegistry, x, z) /*ModBiomes.DEEPSLATE.get()*/;
	}
	
}