package net.luis.nero.api.common.world.biome.noise;

public class HillyBiomeNoise implements IBiomeNoise {
	
	protected final double baseNoise;
	protected final double noiseScale;
	protected final double baseHillyNoise;
	protected final double hillyNoiseScale;
	
	protected HillyBiomeNoise(double baseNoise, double noiseScale, double baseHillyNoise, double hillyNoiseScale) {
		this.baseNoise = baseNoise;
		this.noiseScale = noiseScale;
		this.baseHillyNoise = baseHillyNoise;
		this.hillyNoiseScale = hillyNoiseScale;
	}
	
	public static IBiomeNoise of(double baseNoise, double noiseScale, double baseHillyNoise, double hillyNoiseScale) {
		return new HillyBiomeNoise(baseNoise, noiseScale, baseHillyNoise, hillyNoiseScale);
	}
	
	@Override
	public double getBaseNoise() {
		return this.baseNoise;
	}
	
	@Override
	public double getNoiseScale() {
		return this.noiseScale;
	}
	
	public double getBaseHillyNoise() {
		return this.baseHillyNoise;
	}
	
	public double getHillyNoiseScale() {
		return this.hillyNoiseScale;
	}
	
}
