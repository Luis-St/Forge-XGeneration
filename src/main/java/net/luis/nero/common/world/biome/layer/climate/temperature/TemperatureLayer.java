package net.luis.nero.common.world.biome.layer.climate.temperature;

import net.luis.nero.common.world.biome.layer.OverworldLayer;
import net.luis.nero.common.world.biome.layer.traits.CastleBiomeTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum TemperatureLayer implements CastleBiomeTransformer {
	WARM {
		@Override
		public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
			if (nBiomeId == OverworldLayer.MEDIUM && eBiomeId == OverworldLayer.MEDIUM && sBiomeId == OverworldLayer.MEDIUM && wBiomeId == OverworldLayer.MEDIUM) {
				if (nEBiomeId == OverworldLayer.MEDIUM && sEBiomeId == OverworldLayer.MEDIUM && sWBiomeId == OverworldLayer.MEDIUM && nWBiomeId == OverworldLayer.MEDIUM) {
					int rng = context.nextRandom(4);
					if (rng == 0) {
						return OverworldLayer.WARM;
					}
				}
			}
			return biomeId;
		}
	},
	COLD {
		@Override
		public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
			if (nBiomeId == OverworldLayer.MEDIUM && eBiomeId == OverworldLayer.MEDIUM && sBiomeId == OverworldLayer.MEDIUM && wBiomeId == OverworldLayer.MEDIUM) {
				if (nEBiomeId == OverworldLayer.MEDIUM && sEBiomeId == OverworldLayer.MEDIUM && sWBiomeId == OverworldLayer.MEDIUM && nWBiomeId == OverworldLayer.MEDIUM) {
					return OverworldLayer.COLD;
				}
			}
			return biomeId;
		}
	};
	
}
