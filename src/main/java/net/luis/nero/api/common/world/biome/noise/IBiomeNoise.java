package net.luis.nero.api.common.world.biome.noise;

public interface IBiomeNoise {
	
	static final IBiomeNoise NULL = new IBiomeNoise() {
		@Override
		public double getNoiseScale() {
			return 0.0;
		}
		
		@Override
		public double getBaseNoise() {
			return 0.0;
		}
	};
	
	double getBaseNoise();
	
	double getNoiseScale();
	
}
