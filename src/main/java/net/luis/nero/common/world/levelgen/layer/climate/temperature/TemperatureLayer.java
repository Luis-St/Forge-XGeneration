package net.luis.nero.common.world.levelgen.layer.climate.temperature;

import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.common.world.levelgen.layer.traits.SquareTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum TemperatureLayer implements SquareTransformer {
	WARM {
		@Override
		public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
			if (nBiomeId == OverworldLayer.CLIMATE_MEDIUM && eBiomeId == OverworldLayer.CLIMATE_MEDIUM && sBiomeId == OverworldLayer.CLIMATE_MEDIUM && wBiomeId == OverworldLayer.CLIMATE_MEDIUM) {
				if (nEBiomeId == OverworldLayer.CLIMATE_MEDIUM && sEBiomeId == OverworldLayer.CLIMATE_MEDIUM && sWBiomeId == OverworldLayer.CLIMATE_MEDIUM && nWBiomeId == OverworldLayer.CLIMATE_MEDIUM) {
					if (context.nextRandom(4) == 0) {
						return OverworldLayer.CLIMATE_WARM;
					}
				}
			}
			return biomeId;
		}
	},
	COLD {
		@Override
		public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
			if (nBiomeId == OverworldLayer.CLIMATE_MEDIUM && eBiomeId == OverworldLayer.CLIMATE_MEDIUM && sBiomeId == OverworldLayer.CLIMATE_MEDIUM && wBiomeId == OverworldLayer.CLIMATE_MEDIUM) {
				if (nEBiomeId == OverworldLayer.CLIMATE_MEDIUM && sEBiomeId == OverworldLayer.CLIMATE_MEDIUM && sWBiomeId == OverworldLayer.CLIMATE_MEDIUM && nWBiomeId == OverworldLayer.CLIMATE_MEDIUM) {
					return OverworldLayer.CLIMATE_COLD;
				}
			}
			return biomeId;
		}
	};
	
}