package net.luis.nero.common.world.biome.layer;

import java.util.function.LongFunction;

import net.luis.nero.common.world.biome.layer.climate.ClimateBaseLayer;
import net.luis.nero.common.world.biome.layer.climate.rainfall.RainfallLayer;
import net.luis.nero.common.world.biome.layer.climate.temperature.FixTemperatureLayer;
import net.luis.nero.common.world.biome.layer.climate.temperature.HotIceLayer;
import net.luis.nero.common.world.biome.layer.climate.temperature.TemperatureLayer;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class OverworldLayer {
	
	public static final int ICY = getBiomeId(ModBiomes.ICY.get());
	public static final int COLD = getBiomeId(ModBiomes.COLD.get());
	public static final int MEDIUM = getBiomeId(ModBiomes.MEDIUM.get());
	public static final int WARM = getBiomeId(ModBiomes.WARM.get());
	public static final int HOT = getBiomeId(ModBiomes.HOT.get());
	
	public static final int DRIZZLE = getBiomeId(ModBiomes.DRIZZLE.get());
	public static final int LIGHT = getBiomeId(ModBiomes.LIGHT.get());
	public static final int MODERATE = getBiomeId(ModBiomes.MODERATE.get());
	public static final int STRONG = getBiomeId(ModBiomes.STRONG.get());
	public static final int MONSOON = getBiomeId(ModBiomes.MONSOON.get());
	
	public static int getBiomeId(Biome biome) {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES).getID(biome);
	}
	
	public static Layer getDefaultLayer(long seed) {
		return new Layer(getDefaultLayer((seedModifier) -> {
			return new LazyAreaContext(25, seedModifier, seed);
		}));
	}
	
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getDefaultLayer(LongFunction<C> function) {
		AreaFactory<T> temperatureFactory = getTemperatureLayer(function);
		AreaFactory<T> rainfallFactory = getRainfallLayer(function);
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
	
}
