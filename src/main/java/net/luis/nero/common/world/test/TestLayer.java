package net.luis.nero.common.world.test;

import java.util.function.LongFunction;

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

public class TestLayer {
	
	public static int getBiomeId(ResourceLocation location) {
		return ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES).getID(location);
	}
	
	protected static <T extends Area, C extends BigContext<T>> AreaFactory<T> getDefaultLayer(LongFunction<C> function) {
		AreaFactory<T> areaFactory = BaseLayer.INSTANCE.run(function.apply(0L));
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
			return 0;
		}
	}
	
}