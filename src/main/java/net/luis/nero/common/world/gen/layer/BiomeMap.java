package net.luis.nero.common.world.gen.layer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.PerlinNoiseGenerator;

public class BiomeMap {
	
	// is it possible to generate a noise value between two values so like: between 0 and 9?
	protected double xScale = 0.0035;
	protected double zScale = 0.0035;
	
	protected final PerlinNoiseGenerator biomeNoiseGenerator;
	protected final Biome defaultBiome;
	protected List<NoiseBiome> biomes = Lists.newArrayList();
	
	public BiomeMap(Biome defaultBiome, long seed) {
		this(defaultBiome, new SharedSeedRandom(seed));
	}
	
	public BiomeMap(Biome defaultBiome, SharedSeedRandom seedRandom) {
		this(defaultBiome, new PerlinNoiseGenerator(seedRandom, IntStream.rangeClosed(-3, 0)));
	}
	
	public BiomeMap(Biome defaultBiome, PerlinNoiseGenerator biomeNoiseGenerator) {
		this.defaultBiome = defaultBiome;
		this.biomeNoiseGenerator = biomeNoiseGenerator;
	}
	
	public BiomeMap registerBiome(Biome biome, double minNoise, double maxNoise) {
		this.biomes.add(new NoiseBiome(biome, minNoise, maxNoise));
		return this;
	}
	
	protected BiomeMap scale(double scale) {
		this.xScale = scale;
		this.zScale = scale;
		return this;
	}
	
	protected double getNoise(int x, int z) {
		return this.biomeNoiseGenerator.getSurfaceNoiseValue(x * xScale, z * zScale, 0, 0);
	}
	
	protected Biome getNoiseBiome(int x, int z) {
		double noise = this.getNoise(x, z);
		List<NoiseBiome> biomes = this.biomes.stream().filter(noiseBiome -> noiseBiome.isNoiseBetween(noise)).collect(Collectors.toList());
		if (!biomes.isEmpty()) {
			Collections.shuffle(biomes);
			return this.biomes.get(0).getBiome();
		}
		return this.defaultBiome;
	}
	
	public static class NoiseBiome {
		
		protected final Biome biome;
		protected final double minNoise;
		protected final double maxNoise;
		
		public NoiseBiome(Biome biome, double minNoise, double maxNoise) {
			this.biome = biome;
			this.minNoise = minNoise;
			this.maxNoise = maxNoise;
		}
		
		public Biome getBiome() {
			return this.biome;
		}
		
		public double getMinNoise() {
			return this.minNoise;
		}
		
		public double getMaxNoise() {
			return this.maxNoise;
		}
		
		public boolean isNoiseBetween(double noise) {
			return this.maxNoise >= noise && noise >= this.minNoise;
		}
		
	}

}
