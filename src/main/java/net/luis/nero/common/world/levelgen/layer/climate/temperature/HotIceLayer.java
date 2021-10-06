package net.luis.nero.common.world.levelgen.layer.climate.temperature;

import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.common.world.levelgen.layer.traits.SquareTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum HotIceLayer implements SquareTransformer {
	INSTANCE;

	@Override
	public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
		if (nBiomeId == OverworldLayer.CLIMATE_WARM && eBiomeId == OverworldLayer.CLIMATE_WARM && sBiomeId == OverworldLayer.CLIMATE_WARM && wBiomeId == OverworldLayer.CLIMATE_WARM) {
			if (nEBiomeId == OverworldLayer.CLIMATE_WARM && sEBiomeId == OverworldLayer.CLIMATE_WARM && sWBiomeId == OverworldLayer.CLIMATE_WARM && nWBiomeId == OverworldLayer.CLIMATE_WARM) {
				return OverworldLayer.CLIMATE_HOT;
			}
		} else if (nBiomeId == OverworldLayer.CLIMATE_COLD && eBiomeId == OverworldLayer.CLIMATE_COLD && sBiomeId == OverworldLayer.CLIMATE_COLD && wBiomeId == OverworldLayer.CLIMATE_COLD) {
			if (nEBiomeId == OverworldLayer.CLIMATE_COLD && sEBiomeId == OverworldLayer.CLIMATE_COLD && sWBiomeId == OverworldLayer.CLIMATE_COLD && nWBiomeId == OverworldLayer.CLIMATE_COLD) {
				return OverworldLayer.CLIMATE_ICY;
			}
		}
		return biomeId;
	}
	
}