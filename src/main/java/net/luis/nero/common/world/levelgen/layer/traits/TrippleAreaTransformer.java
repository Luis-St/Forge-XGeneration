package net.luis.nero.common.world.levelgen.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;

public interface TrippleAreaTransformer {
	
	default <R extends Area> AreaFactory<R> run(BigContext<R> context, AreaFactory<R> biomeFactory, AreaFactory<R> temperatureFactory, AreaFactory<R> rainfallFactory) {
		return () -> {
			R biomeArea = biomeFactory.make();
			R temperatureArea = temperatureFactory.make();
			R rainfallArea = rainfallFactory.make();
			return context.createResult((x, z) -> {
				context.initRandom((long) x, (long) z);
				return this.apply(context, biomeArea, temperatureArea, rainfallArea, x, z);
			});
		};
	}

	int apply(BigContext<?> context, Area biomeArea, Area temperatureArea, Area rainfallArea, int x, int z);
	
}
