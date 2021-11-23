package net.luis.nero.common.world.biome.noise;

public class BiomeNoise implements IBiomeNoise {
	
	protected final int baseNoise;
	protected final double noiseScale;
	
	protected BiomeNoise(int baseNoise, double noiseScale) {
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
	}
	
	public static IBiomeNoise of(int baseNoise, double noiseScale) {
		return new BiomeNoise(baseNoise, noiseScale);
	}
	
	@Override
	public int getBaseNoise() {
		return this.baseNoise;
	}
	
	@Override
	public double getNoiseScale() {
		return this.noiseScale;
	}
	
}
