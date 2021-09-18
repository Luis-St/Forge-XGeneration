package net.luis.nero.common.world.levelgen.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;

public interface BaseTransformer {
	
	default <R extends Area> AreaFactory<R> run(BigContext<R> context) {
		return () -> {
			return context.createResult((x, z) -> {
				context.initRandom((long) x, (long) z);
				return this.apply(context, x, z);
			});
		};
	}

	int apply(BigContext<?> context, int x, int z);
	
}
