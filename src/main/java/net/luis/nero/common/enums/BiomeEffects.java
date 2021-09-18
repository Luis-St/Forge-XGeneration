package net.luis.nero.common.enums;

public enum BiomeEffects {
	
	OVERWORLD(4159204, 329011, 12638463, 9551193, 7842607),
	NETHER(4159204, 329011, 3344392, 12564309, 11445290),
	END(4159204, 329011, 10518688, 9353585, 7448397),
	DEEPSLATE(4159204, 329011, 12638463, 7979098, 5877296),
	DEEPSLATE_OCEAN(4159204, 329011, 12638463, 255, 5877296),
	DEEPSLATE_LAVA_LAKE(4010530, 1053449, 9074550, 10187605, 8478784),
	DEEPDARK(4400, 30, 9800, 213328, 5153),
	LUSH_CAVE(4169444, 332595, 9352375, 4710195, 1756928),
	DRIPSTONE_CAVE(4159204, 329011, 12638463, 5059871, 5877296);
	
	private final int waterColor;
	private final int waterFogColor;
	private final int fogColor;
	private final int grassColor;
	private final int foliageColor;
	
	private BiomeEffects(int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor) {
		this.waterColor = waterColor;
		this.waterFogColor = waterFogColor;
		this.fogColor = fogColor;
		this.grassColor = grassColor;
		this.foliageColor = foliageColor;
	}
	
	public int getWaterColor() {
		return this.waterColor;
	}
	
	public int getWaterFogColor() {
		return this.waterFogColor;
	}
	
	public int getFogColor() {
		return this.fogColor;
	}
	
	public int getGrassColor() {
		return this.grassColor;
	}
	
	public int getFoliageColor() {
		return this.foliageColor;
	}
	
}
