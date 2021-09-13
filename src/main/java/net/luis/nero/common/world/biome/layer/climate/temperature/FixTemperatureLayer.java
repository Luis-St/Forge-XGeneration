package net.luis.nero.common.world.biome.layer.climate.temperature;

import net.luis.nero.common.world.biome.layer.OverworldLayer;
import net.luis.nero.common.world.biome.layer.traits.CrossBiomeTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum FixTemperatureLayer implements CrossBiomeTransformer {
	INSTANCE;

	@Override
	public int apply(BigContext<?> context, int northBiomeId, int eastBiomeId, int southBiomeId, int westBiomeId, int biomeId) {
		if (this.isAround(OverworldLayer.HOT, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.HOT;
		} else if (this.isAround(OverworldLayer.WARM, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.WARM;
		} else if (this.isAround(OverworldLayer.MEDIUM, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.MEDIUM;
		} else if (this.isAround(OverworldLayer.COLD, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.COLD;
		} else if (this.isAround(OverworldLayer.ICY, northBiomeId, eastBiomeId, southBiomeId, westBiomeId)) {
			return OverworldLayer.ICY;
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
