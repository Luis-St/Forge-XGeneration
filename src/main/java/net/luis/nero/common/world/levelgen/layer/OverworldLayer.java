package net.luis.nero.common.world.levelgen.layer;

import java.util.function.LongFunction;

import net.luis.nero.common.world.levelgen.layer.climate.ClimateBaseLayer;
import net.luis.nero.common.world.levelgen.layer.climate.rainfall.RainfallLayer;
import net.luis.nero.common.world.levelgen.layer.climate.temperature.FixTemperatureLayer;
import net.luis.nero.common.world.levelgen.layer.climate.temperature.HotIceLayer;
import net.luis.nero.common.world.levelgen.layer.climate.temperature.TemperatureLayer;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

@SuppressWarnings("removal")
public class OverworldLayer {
	
	public static final int CLIMATE_ICY = ModBiomes.CLIMATE_ICY.id();
	public static final int CLIMATE_COLD = ModBiomes.CLIMATE_COLD.id();
	public static final int CLIMATE_MEDIUM = ModBiomes.CLIMATE_MEDIUM.id();
	public static final int CLIMATE_WARM = ModBiomes.CLIMATE_WARM.id();
	public static final int CLIMATE_HOT = ModBiomes.CLIMATE_HOT.id();
	
	public static final int CLIMATE_DRIZZLE = ModBiomes.CLIMATE_DRIZZLE.id();
	public static final int CLIMATE_LIGHT = ModBiomes.CLIMATE_LIGHT.id();
	public static final int CLIMATE_MODERATE = ModBiomes.CLIMATE_MODERATE.id();
	public static final int CLIMATE_STRONG = ModBiomes.CLIMATE_STRONG.id();
	public static final int CLIMATE_MONSOON = ModBiomes.CLIMATE_MONSOON.id();
	
	public static int getBiomeId(ResourceLocation location) {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES).getID(location);
	}
	
	public static Layer getSurfaceLayer(long seed) {
		return new Layer(getSurfaceLayer((seedModifier) -> {
			return new LazyAreaContext(25, seedModifier, seed);
		}));
	}
	
	@SuppressWarnings("unused")
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getSurfaceLayer(LongFunction<C> function) {
		AreaFactory<T> temperatureFactory = getTemperatureLayer(function);
		AreaFactory<T> rainfallFactory = getRainfallLayer(function);
		return rainfallFactory;
	}
	
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getTemperatureLayer(LongFunction<C> function) {
		AreaFactory<T> temperatureFactory = ClimateBaseLayer.TEMPERATURE.run(function.apply(10L));
		temperatureFactory = TemperatureLayer.WARM.run(function.apply(20L), temperatureFactory);
		temperatureFactory = TemperatureLayer.COLD.run(function.apply(30L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(40L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(50L), temperatureFactory);
		temperatureFactory = HotIceLayer.INSTANCE.run(function.apply(60L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(70L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(80L), temperatureFactory);
		temperatureFactory = FixTemperatureLayer.INSTANCE.run(function.apply(90L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(100L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(110L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(120L), temperatureFactory);
		temperatureFactory = ZoomLayer.NORMAL.run(function.apply(130L), temperatureFactory);
		return temperatureFactory;
	}
	
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getRainfallLayer(LongFunction<C> function) {
		AreaFactory<T> rainfallFactory = ClimateBaseLayer.RAINFALL.run(function.apply(1L));
		rainfallFactory = RainfallLayer.LIGHT.run(function.apply(2L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(4L), rainfallFactory);
		rainfallFactory = RainfallLayer.LIGHT.run(function.apply(8L), rainfallFactory);
		rainfallFactory = RainfallLayer.MODERATE.run(function.apply(16L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(32L), rainfallFactory);
		rainfallFactory = RainfallLayer.MODERATE.run(function.apply(64L), rainfallFactory);
		rainfallFactory = RainfallLayer.STRONG.run(function.apply(128L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(256L), rainfallFactory);
		rainfallFactory = RainfallLayer.STRONG.run(function.apply(512L), rainfallFactory);
		rainfallFactory = RainfallLayer.MONSOON.run(function.apply(1024L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(2048L), rainfallFactory);
		rainfallFactory = RainfallLayer.MONSOON.run(function.apply(8192L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(8192L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(16384L), rainfallFactory);
		rainfallFactory = RainfallLayer.MONSOON.run(function.apply(32768L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(65536L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(131072L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(262144L), rainfallFactory);
		rainfallFactory = ZoomLayer.NORMAL.run(function.apply(524288L), rainfallFactory);
		return rainfallFactory;
	}
	
}
