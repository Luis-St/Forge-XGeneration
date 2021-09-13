package net.luis.nero.common.world.biome.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;

public interface ClimateAreaTransformer {
	
	default <R extends Area> AreaFactory<R> run(BigContext<R> context, AreaFactory<R> biomeFactory, AreaFactory<R> climateFactory) {
		return () -> {
			R biomeArea = biomeFactory.make();
			R climateArea = climateFactory.make();
			return context.createResult((x, z) -> {
				context.initRandom((long) x, (long) z);
				return this.apply(context, biomeArea, climateArea, x, z);
			});
		};
	}

	int apply(BigContext<?> context, Area biomeArea, Area climateArea, int x, int z);
	
}
