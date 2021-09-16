package net.luis.nero.api.common.world.biome.util;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BiomeUtil {
	
	public static Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> makeModFeaturesMap() {
		return Util.make(Maps.newHashMap(), map -> {
			for (Decoration decoration : Decoration.values()) {
				map.put(decoration, Lists.newArrayList());
			}
		});
	}
	
	public static Map<Carving, List<Supplier<ConfiguredWorldCarver<?>>>> makeModCarversMap() {
		return Util.make(Maps.newHashMap(), map -> {
			for (Carving carving : Carving.values()) {
				map.put(carving, Lists.newArrayList());
			}
		});
	}
	
}
