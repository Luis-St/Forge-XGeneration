package net.luis.industry.common.world.feature.config;

public class MineshaftConfig {
	
	private final boolean generateRails;
	private final boolean generatePillar;
	private final boolean generateRandomBlock;
	private final boolean generateSpawner;
	
	public MineshaftConfig(boolean rails, boolean pillar, boolean randomBlock, boolean spawner) {
		this.generateRails = rails;
		this.generatePillar = pillar;
		this.generateRandomBlock = randomBlock;
		this.generateSpawner = spawner;
	}
	
	public boolean generateRails() {
		return this.generateRails;
	}
	
	public boolean generatePillar() {
		return this.generatePillar;
	}
	
	public boolean generateRandomBlock() {
		return this.generateRandomBlock;
	}
	
	public boolean generateSpawner() {
		return this.generateSpawner;
	}
	
}
