package net.luis.nero.common.world.gen.layer;

import java.util.function.LongFunction;

import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.area.LazyArea;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;

// TODO: find out how BetterEnd BiomeMap works -> and recreate
// TODO: if finished: create/add more biomes

public class DeepslateBiomeLayer {

	public static <T extends Area, C extends BigContext<T>> AreaFactory<T> createBaseLayer(LongFunction<C> function) {
		AreaFactory<T> areaFactory = BaseLayer.INSTANCE.run(function.apply(0L));
		return areaFactory;
	}

	public static ModLayer createLayer(long seed) {
		AreaFactory<LazyArea> factory = createBaseLayer((seedModifier) -> {
			return new LazyAreaContext(25, seedModifier, seed);
		});
		return new ModLayer(factory);
	}

	protected enum BaseLayer implements AreaTransformer0 {
		INSTANCE;
		
		@Override
		public int applyPixel(Context rng, int x, int z) {
			return -1;
		}
	}

}