package net.luis.nero.api.common.world.biome.noise;

public class BiomeNoise implements IBiomeNoise {
	
	protected final double baseNoise;
	protected final double noiseScale;
	
	protected BiomeNoise(double baseNoise, double noiseScale) {
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
	}
	
	public static IBiomeNoise of(double baseNoise, double noiseScale) {
		return new BiomeNoise(baseNoise, noiseScale);
	}
	
	@Override
	public double getBaseNoise() {
		return this.baseNoise;
	}
	
	@Override
	public double getNoiseScale() {
		return this.noiseScale;
	}
	
}
