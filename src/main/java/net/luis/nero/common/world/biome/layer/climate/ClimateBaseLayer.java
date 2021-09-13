package net.luis.nero.common.world.biome.layer.climate;

import net.luis.nero.common.world.biome.layer.OverworldLayer;
import net.luis.nero.common.world.biome.layer.traits.BaseTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum ClimateBaseLayer implements BaseTransformer {
	TEMPERATURE {
		@Override
		public int apply(BigContext<?> context, int x, int z) {
			return OverworldLayer.MEDIUM;
		}
	},
	RAINFALL {
		@Override
		public int apply(BigContext<?> context, int x, int z) {
			return OverworldLayer.DRIZZLE;
		}
	};
}
