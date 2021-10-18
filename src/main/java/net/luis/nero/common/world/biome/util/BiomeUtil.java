package net.luis.nero.common.world.biome.util;

import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.BadlandsBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.BeachBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.DesertBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.ForestBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.JungleBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.OldGrowthBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.PeakBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.SavannaBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.SwampBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.WindsweptBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.cave.LushCavesBiome;
import net.luis.nero.common.world.biome.vanilla.overworld.type.ForestBiomeType;
import net.luis.nero.common.world.biome.vanilla.overworld.type.PeakBiomeType;

public class BiomeUtil {
	
	public static float getDownfall(OverworldBiome overworldBiome) {
		if (overworldBiome instanceof BadlandsBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof BeachBiome) {
			return 0.3F;
		} else if (overworldBiome instanceof DesertBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof ForestBiome forestBiome) {
			switch ((ForestBiomeType) forestBiome.getBiomeType()) {
			case BIRCH_FOREST, BIRCH_FOREST_HILLS, OLD_GROWTH_BIRCH_FOREST, OLD_GROWTH_BIRCH_FOREST_HILLS:
				return 0.6F;
			default:
				return 0.8F;
			}
		} else if (overworldBiome instanceof JungleBiome) {
			return 0.9F;
		} else if (overworldBiome instanceof JungleBiome) {
			return 1.0F;
		} else if (overworldBiome instanceof OldGrowthBiome) {
			return 0.8F;
		} else if (overworldBiome instanceof PeakBiome peakBiome) {
			switch ((PeakBiomeType) peakBiome.getBiomeType()) {
			case STONY_PEAKS:
				return 0.3F;
			case MEADOW, GROVE, SNOWY_GROVE:
				return 0.8F;
			case SNOWY_SLOPES, JAGGED_PEAKS, FROZEN_PEAKS:
				return 0.9F;
			}
		}  else if (overworldBiome instanceof SavannaBiome) {
			return 0.0F;
		} else if (overworldBiome instanceof SwampBiome) {
			return 0.9F;
		} else if (overworldBiome instanceof WindsweptBiome) {
			return 0.3F;
		} else if (overworldBiome instanceof LushCavesBiome) {
			return 0.7F;
		} 
		return 0.5F;
	}
	
}
