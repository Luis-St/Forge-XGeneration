package net.luis.nero.common.world.levelgen.layer;

import java.util.function.LongFunction;

import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class DeepslateBiomeLayer {
	
	protected static final int DEEPSLATE = getBiomeId(ModBiomeKeys.DEEPSLATE.location()); // y0-512
	protected static final int DEEPSLATE_OCEAN = getBiomeId(ModBiomeKeys.DEEPSLATE_OCEAN.location()); // y244-288
	protected static final int DEEPSLATE_LAVA_LAKE = getBiomeId(ModBiomeKeys.DEEPSLATE_LAVA_LAKE.location()); // y64-160
	protected static final int LUSH_CAVES = getBiomeId(ModBiomeKeys.LUSH_CAVES.location()); // y320-480
	protected static final int DRIPSTONE_CAVE = getBiomeId(ModBiomeKeys.DRIPSTONE_CAVE.location()); // y64-320
	protected static final int DEEPDARK = getBiomeId(ModBiomeKeys.DEEPDARK.location()); // y0-64
	
	public static int getBiomeId(ResourceLocation location) {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES).getID(location);
	}
	
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getDefaultLayer(LongFunction<C> function) {
		AreaFactory<T> areaFactory = BaseLayer.INSTANCE.run(function.apply(0L));
		areaFactory = CaveLayer.INSTANCE.run(function.apply(1L), areaFactory);
		for (int i = 0; i < 6; i++) {
			areaFactory = ZoomLayer.NORMAL.run(function.apply(2L + i), areaFactory);
		}
		return areaFactory;
	}
	
	public static Layer getDefaultLayer(long seed) {
		return new Layer(getDefaultLayer((seedModifier) -> {
			return new LazyAreaContext(25, seedModifier, seed);
		}));
	}
	
	
	protected enum BaseLayer implements AreaTransformer0 {
		INSTANCE;
		
		@Override
		public int applyPixel(Context context, int x, int y) {
			return DEEPSLATE;
		}
	}
	
	protected enum CaveLayer implements AreaTransformer {
		INSTANCE;
		
		@Override
		public int applyPixel(BigContext<?> context, Area area, int x, int y) {
			int rng = context.nextRandom(30);
			if (rng == 0) {
				return DEEPSLATE_OCEAN;
			}
			rng = context.nextRandom(40);
			if (rng == 0) {
				return DEEPSLATE_LAVA_LAKE;
			}
			rng = context.nextRandom(70);
			if (rng == 0) {
				return LUSH_CAVES;
			} else if (rng == 1) {
				return DRIPSTONE_CAVE;
			}
			rng = context.nextRandom(300);
			if (rng == 0) {
				return DEEPDARK;
			}
			return DEEPSLATE;
		}
	}
	
}
