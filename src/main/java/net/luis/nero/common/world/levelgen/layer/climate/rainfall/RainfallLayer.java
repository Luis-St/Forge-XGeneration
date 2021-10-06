package net.luis.nero.common.world.levelgen.layer.climate.rainfall;

import net.luis.nero.common.world.levelgen.layer.OverworldLayer;
import net.luis.nero.common.world.levelgen.layer.traits.PlusTransformer;
import net.minecraft.world.level.newbiome.context.BigContext;

public enum RainfallLayer implements PlusTransformer {
	LIGHT {
		@Override
		public int apply(BigContext<?> context, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.CLIMATE_DRIZZLE && temperatureEast == OverworldLayer.CLIMATE_DRIZZLE && temperatureSouth == OverworldLayer.CLIMATE_DRIZZLE && temperatureWest == OverworldLayer.CLIMATE_DRIZZLE) {
				return context.nextRandom(2) == 0 ? OverworldLayer.CLIMATE_LIGHT : temperature;
			}
			return temperature;
		}
	},
	MODERATE {
		@Override
		public int apply(BigContext<?> context, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.CLIMATE_LIGHT && temperatureEast == OverworldLayer.CLIMATE_LIGHT && temperatureSouth == OverworldLayer.CLIMATE_LIGHT && temperatureWest == OverworldLayer.CLIMATE_LIGHT) {
				return OverworldLayer.CLIMATE_MODERATE;
			}
			return temperature;
		}
	},
	STRONG {
		@Override
		public int apply(BigContext<?> context, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.CLIMATE_MODERATE && temperatureEast == OverworldLayer.CLIMATE_MODERATE && temperatureSouth == OverworldLayer.CLIMATE_MODERATE && temperatureWest == OverworldLayer.CLIMATE_MODERATE) {
				return context.nextRandom(2) == 0 ? OverworldLayer.CLIMATE_STRONG : temperature;
			}
			return temperature;
		}
	},
	MONSOON {
		@Override
		public int apply(BigContext<?> context, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature) {
			if (temperatureNorth == OverworldLayer.CLIMATE_STRONG && temperatureEast == OverworldLayer.CLIMATE_STRONG && temperatureSouth == OverworldLayer.CLIMATE_STRONG && temperatureWest == OverworldLayer.CLIMATE_STRONG) {
				return context.nextRandom(5) == 0 ? OverworldLayer.CLIMATE_MONSOON : temperature;
			}
			return temperature;
		}
	};
	
}
