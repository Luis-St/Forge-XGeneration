package net.luis.nero.common.world.test;

import java.util.Random;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;

import net.luis.nero.common.world.biome.DeepslateBiomeSource;
import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.newbiome.layer.Layer;

public class TestBiomeSource extends BiomeSource {
	
	public static final Codec<TestBiomeSource> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
			.xmap(TestBiomeSource::new, TestBiomeSource::getBiomeRegistry).codec();
	
	protected final long seed;
	protected final Registry<Biome> registry;
	protected final Layer noiseBiomeLayer;
	
	public TestBiomeSource(Registry<Biome> registry) {
		this(registry, new Random().nextLong());
	}
	
	public TestBiomeSource(Registry<Biome> registry, long seed) {
		super(ModBiomeKeys.BIOMES.stream().map(biome -> registry.get(biome.location())).collect(Collectors.toList()));
		this.seed = seed;
		this.registry = registry;
		this.noiseBiomeLayer = OverworldLayer.getSurfaceLayer(seed);
	}
	
	public long getSeed() {
		return seed;
	}
	
	public Registry<Biome> getBiomeRegistry() {
		return this.registry;
	}

	@Override
	public boolean canGenerateStructure(StructureFeature<?> structure) {
		return false;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return DeepslateBiomeSource.CODEC;
	}

	@Override
	public TestBiomeSource withSeed(long seed) {
		return new TestBiomeSource(this.registry, seed);
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.noiseBiomeLayer.get(this.registry, x, z);
	}

}
