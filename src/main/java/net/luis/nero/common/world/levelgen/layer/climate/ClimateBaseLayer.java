package net.luis.nero.common.world.levelgen.layer.climate;

import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.common.world.levelgen.layer.traits.BaseTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum ClimateBaseLayer implements BaseTransformer {
	TEMPERATURE {
		@Override
		public int apply(BigContext<?> context, int x, int z) {
			return OverworldLayer.CLIMATE_MEDIUM;
		}
	},
	RAINFALL {
		@Override
		public int apply(BigContext<?> context, int x, int z) {
			return OverworldLayer.CLIMATE_DRIZZLE;
		}
	};
}
