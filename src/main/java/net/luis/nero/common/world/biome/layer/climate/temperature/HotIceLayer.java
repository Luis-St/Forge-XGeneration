package net.luis.nero.common.world.biome.layer.climate.temperature;

import net.luis.nero.common.world.biome.layer.OverworldLayer;
import net.luis.nero.common.world.biome.layer.traits.CastleBiomeTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum HotIceLayer implements CastleBiomeTransformer {
	INSTANCE;

	@Override
	public int apply(BigContext<?> context, int nBiomeId, int nEBiomeId, int eBiomeId, int sEBiomeId, int sBiomeId, int sWBiomeId, int wBiomeId, int nWBiomeId, int biomeId) {
		if (nBiomeId == OverworldLayer.WARM && eBiomeId == OverworldLayer.WARM && sBiomeId == OverworldLayer.WARM && wBiomeId == OverworldLayer.WARM) {
			if (nEBiomeId == OverworldLayer.WARM && sEBiomeId == OverworldLayer.WARM && sWBiomeId == OverworldLayer.WARM && nWBiomeId == OverworldLayer.WARM) {
				return OverworldLayer.HOT;
			}
		} else if (nBiomeId == OverworldLayer.COLD && eBiomeId == OverworldLayer.COLD && sBiomeId == OverworldLayer.COLD && wBiomeId == OverworldLayer.COLD) {
			if (nEBiomeId == OverworldLayer.COLD && sEBiomeId == OverworldLayer.COLD && sWBiomeId == OverworldLayer.COLD && nWBiomeId == OverworldLayer.COLD) {
				return OverworldLayer.ICY;
			}
		}
		return biomeId;
	}
	
}
