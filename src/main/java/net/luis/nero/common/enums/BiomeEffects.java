package net.luis.nero.common.enums;

import net.minecraft.world.level.biome.BiomeSpecialEffects;

public enum BiomeEffects {
	
	OVERWORLD(4159204, 329011, 12638463, 9551193, 7842607),
	NETHER(4159204, 329011, 3344392, 12564309, 11445290),
	END(4159204, 329011, 10518688, 9353585, 7448397),
	
	BADLANDS(4159204, 329011, 12638463, 9470285, 10387789),
	DESERT(4159204, 329011, 12638463, 12564309, 11445290),
	SAVANNA(4159204, 329011, 12638463, 12564309, 11445290),
	JUNGLE(1810136, 329011, 12638463, 5884220, 3193611),
	FOREST(4159204, 329011, 12638463, 7979098, 5877296),
	BIRCH_FOREST(4159204, 329011, 12638463, 8960871, 7055681),
	DARK_FOREST(4159204, 329011, 12638463, 5274162, 5877296),
	SWAMP(6388580, 329011, 12638463, 6975545, 6975545),
	PLAINS(4159204, 329011, 12638463, 9551193, 7842607),
	BEACH(4159204, 329011, 12638463, 9551193, 7842607),
	OCEAN(4159204, 329011, 12638463, 9353585, 7448397),
	WARM_OCEAN(4445678, 329011, 12638463, 9353585, 7448397),
	LUKEWARM_OCEAN(4566514, 329011, 12638463, 9353585, 7448397),
	COLD_OCEAN(4020182, 329011, 12638463, 9353585, 7448397),
	RIVER(4159204, 329011, 12638463, 9353585, 7448397),
	MUSHROOM_FIELDS(4159204, 329011, 12638463, 5622079, 2865935),
	WINDSWEPT_HILLS(4159204, 329011, 12638463, 9090697, 7185259),
	
	MEADOW(937679, 329011, 12638463, 8633197, 6531400),
	GROVE(4159204, 329011, 12638463, 8434839, 6332795),
	SNOWY_SLOPES(4159204, 329011, 12638463, 8434839, 6332795),
	JAGGED_PEAKS(4159204, 329011, 12638463, 8434839, 6332795),
	FROZEN_PEAKS(4159204, 329011, 12638463, 8434839, 6332795),
	STONY_PEAKS(4159204, 329011, 12638463, 10141259, 8563742),
	
	STONY_SHORE(4159204, 329011, 12638463, 9090697, 7185259),
	SNOWY_BEACH(4159204, 329011, 12638463, 8631699, 6595192),
	TAIGA(4159204, 329011, 12638463, 8828803, 6857828),
	OLD_GROWTH_TAIGA(4159204, 329011, 12638463, 8829055, 6858079),
	SNOWY_PLAINS(4159204, 329011, 12638463, 8434839, 6332795),
	SNOWY_WINDSWEPT_HILLS(4159204, 329011, 12638463, 8434839, 6332795),
	SNOWY_TAIGA(4020182, 329011, 12638463, 8434839, 6332795),
	FROZEN_OCEAN(3750089, 329011, 12638463, 8434839, 6332795),
	FROZEN_RIVER(3750089, 329011, 12638463, 8434839, 6332795),
	
	DRIPSTONE_CAVE(4159204, 329011, 12638463, 9551193, 7842607),
	LUSH_CAVES(4159204, 329011, 12638463, 5884220, 3193611),
	DEEPDARK_OCEAN(4159204, 329011, 12638463, 9353585, 7448397),
	
	DEEPSLATE(4159204, 329011, 12638463, 7979098, 5877296),
	DEEPSLATE_OCEAN(4159204, 329011, 12638463, 255, 5877296),
	DEEPSLATE_LAVA_LAKE(4010530, 1053449, 9074550, 10187605, 8478784),
	DEEPSLATE_DEEPDARK(4400, 30, 9800, 213328, 5153),
	DEEPSLATE_LUSH_CAVES(4169444, 332595, 9352375, 4710195, 1756928),
	DEEPSLATE_DRIPSTONE_CAVE(4159204, 329011, 12638463, 5059871, 5877296);
	
	private final int waterColor;
	private final int waterFogColor;
	private final int fogColor;
	private final int grassColor;
	private final int foliageColor;
	private final BiomeSpecialEffects.GrassColorModifier grassColorModifier;
	
	private BiomeEffects(int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor) {
		this(waterColor, waterFogColor, fogColor, grassColor, foliageColor, BiomeSpecialEffects.GrassColorModifier.NONE);
	}
	
	private BiomeEffects(int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor, BiomeSpecialEffects.GrassColorModifier grassColorModifier) {
		this.waterColor = waterColor;
		this.waterFogColor = waterFogColor;
		this.fogColor = fogColor;
		this.grassColor = grassColor;
		this.foliageColor = foliageColor;
		this.grassColorModifier = grassColorModifier;
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
	
	public BiomeSpecialEffects.GrassColorModifier getGrassColorModifier() {
		return this.grassColorModifier;
	}
	
	public BiomeSpecialEffects toBiomeSpecialEffects() {
		return new BiomeSpecialEffects.Builder().waterColor(this.waterColor).waterFogColor(this.waterFogColor).fogColor(this.fogColor)
				.foliageColorOverride(this.foliageColor).grassColorOverride(this.grassColor).grassColorModifier(this.grassColorModifier).build();
	}
	
}
