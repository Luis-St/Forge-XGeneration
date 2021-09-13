package net.luis.nero.common.world.biome.layer.climate.rainfall;

import net.luis.nero.common.world.biome.layer.OverworldLayer;
import net.luis.nero.common.world.biome.layer.traits.RainfallTransformer;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum RainfallLayer implements RainfallTransformer {
	LIGHT {
		@Override
		public int apply(BigContext<?> context, Area temperatureArea, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.DRIZZLE && temperatureEast == OverworldLayer.DRIZZLE && temperatureSouth == OverworldLayer.DRIZZLE && temperatureWest == OverworldLayer.DRIZZLE) {
				return context.nextRandom(2) == 0 ? OverworldLayer.LIGHT : temperature;
			}
			return temperature;
		}
	},
	MODERATE {
		@Override
		public int apply(BigContext<?> context, Area temperatureArea, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.LIGHT && temperatureEast == OverworldLayer.LIGHT && temperatureSouth == OverworldLayer.LIGHT && temperatureWest == OverworldLayer.LIGHT) {
				return OverworldLayer.MODERATE;
			}
			return temperature;
		}
	},
	STRONG {
		@Override
		public int apply(BigContext<?> context, Area temperatureArea, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.MODERATE && temperatureEast == OverworldLayer.MODERATE && temperatureSouth == OverworldLayer.MODERATE && temperatureWest == OverworldLayer.MODERATE) {
				return context.nextRandom(2) == 0 ? OverworldLayer.STRONG : temperature;
			}
			return temperature;
		}
	},
	MONSOON {
		@Override
		public int apply(BigContext<?> context, Area temperatureArea, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.STRONG && temperatureEast == OverworldLayer.STRONG && temperatureSouth == OverworldLayer.STRONG && temperatureWest == OverworldLayer.STRONG) {
				return context.nextRandom(5) == 0 ? OverworldLayer.MONSOON : temperature;
			}
			return temperature;
		}
	};
	
}
