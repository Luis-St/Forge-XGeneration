package net.luis.industry.common.world.dimension.biome.layer;

import java.util.function.LongFunction;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class DeepslateBiomeLayer {
	
	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createDeepslateBiomeLayer(LongFunction<C> function) {
		IAreaFactory<T> areaFactory = DeepslateLayer.INSTANCE.run(function.apply(0L));
		return areaFactory;
	}
	
	public static ModLayer createLayer(long seed) {
		IAreaFactory<LazyArea> factory = createDeepslateBiomeLayer((seedModifier) -> {
			return new LazyAreaLayerContext(1, seedModifier, seed);
		});
		return new ModLayer(factory);
	}
	
	public enum DeepslateLayer implements IAreaTransformer0 {
		INSTANCE;
		
		public int applyPixel(INoiseRandom random, int x, int z) {
			return -1;
		}
	}

}
