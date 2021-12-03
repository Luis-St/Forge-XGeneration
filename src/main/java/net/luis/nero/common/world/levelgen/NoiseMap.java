package net.luis.nero.common.world.levelgen;

import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class NoiseMap {
	
	protected final PerlinSimplexNoise worldNoise;
	protected final BiomeSource biomeSource;
	protected final int offset;
	
	public NoiseMap(PerlinSimplexNoise worldNoise, BiomeSource biomeSource, int offset) {
		this.worldNoise = worldNoise;
		this.biomeSource = biomeSource;
		this.offset = offset > 0 ? offset : 2;
	}
	
//	@SuppressWarnings("unused")
//	public void getNoise(int x, int z) {
//		OverworldBiome centerBiome = this.getOverworldBiome(x, z);
//		double base = centerBiome.getBiomeNoise().getBaseNoise();
//		double scale = centerBiome.getBiomeNoise().getNoiseScale();
//		List<OverworldBiome> overworldBiomes = this.makeMap(x, z);
//	}
//	
//	protected List<OverworldBiome> makeMap(int xIn, int zIn) {
//		List<OverworldBiome> overworldBiomes = Lists.newArrayList();
//		for (int x = -this.offset; x <= this.offset; x++) {
//			for (int z = -this.offset; z <= this.offset; z++) {
//				overworldBiomes.add(this.getOverworldBiome(xIn + x, zIn + z));
//			}
//		}
//		return overworldBiomes;
//	}
//	
//	protected OverworldBiome getOverworldBiome(int x, int z) {
//		IBiome biome = IBiome.byVanilla(this.biomeSource.getNoiseBiome(x, 302, z));
//		if (biome != null && biome instanceof OverworldBiome) {
//			return (OverworldBiome) biome;
//		}
//		Nero.LOGGER.warn("Fail to get IBiome");
//		return null;
//	}
	
}
