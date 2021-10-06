package net.luis.nero.common.world.levelgen.layer.climate.temperature;

import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.common.world.levelgen.layer.traits.CrossTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum FixTemperatureLayer implements CrossTransformer {
	INSTANCE;

	@Override
	public int apply(BigContext<?> context, int northBiomeId, int eastBiomeId, int southBiomeId, int westBiomeId, int biomeId) {
		if (this.isAround(OverworldLayer.CLIMATE_HOT, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.CLIMATE_HOT;
		} else if (this.isAround(OverworldLayer.CLIMATE_WARM, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.CLIMATE_WARM;
		} else if (this.isAround(OverworldLayer.CLIMATE_MEDIUM, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.CLIMATE_MEDIUM;
		} else if (this.isAround(OverworldLayer.CLIMATE_COLD, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.CLIMATE_COLD;
		} else if (this.isAround(OverworldLayer.CLIMATE_ICY, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.CLIMATE_ICY;
		}
		return biomeId;
	}
	
	protected boolean isAround(int biomeId, int northBiomeId, int eastBiomeId, int southBiomeId, int westBiomeId) {
		if (northBiomeId == biomeId && eastBiomeId == biomeId && southBiomeId == biomeId) {
			return true;
		} else if (eastBiomeId == biomeId && southBiomeId == biomeId && westBiomeId == biomeId) {
			return true;
		} else if (southBiomeId == biomeId && westBiomeId == biomeId && northBiomeId == biomeId) {
			return true;
		} else if (westBiomeId == biomeId && northBiomeId == biomeId && eastBiomeId == biomeId) {
			return true;
		}
		return false;
	}
	
}
