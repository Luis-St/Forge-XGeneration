package net.luis.nero.common.world.biome.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;

public interface SimpleAreaTransformer {
	
	default <R extends Area> AreaFactory<R> run(BigContext<R> context, AreaFactory<R> areaFactory) {
		return () -> {
			R area = areaFactory.make();
			return context.createResult((x, z) -> {
				context.initRandom((long) x, (long) z);
				return this.apply(context, area, x, z);
			});
		};
	}

	int apply(BigContext<?> context, Area area, int x, int z);
	
}
