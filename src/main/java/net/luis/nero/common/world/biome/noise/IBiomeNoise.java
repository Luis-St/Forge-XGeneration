package net.luis.nero.common.world.biome.noise;

public interface IBiomeNoise {
	
	static final IBiomeNoise NULL = new IBiomeNoise() {
		@Override
		public int getBaseNoise() {
			return 0;
		}
		
		@Override
		public double getNoiseScale() {
			return 0.0;
		}
	};
	
	int getBaseNoise();
	
	double getNoiseScale();
	
}
