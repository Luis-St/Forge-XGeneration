package net.luis.nero.api.common.util;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class Reflections {
	
	public static void addDimensionRenderInfos(Map<ResourceLocation, DimensionRenderInfo> renderInfos) {
		Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effects = Util.make(new Object2ObjectArrayMap<>(), (map) -> {
			DimensionRenderInfo.Overworld overworldRenderInfo = new DimensionRenderInfo.Overworld();
			map.defaultReturnValue(overworldRenderInfo);
			map.put(DimensionType.OVERWORLD_EFFECTS, overworldRenderInfo);
			map.put(DimensionType.NETHER_EFFECTS, new DimensionRenderInfo.Nether());
			map.put(DimensionType.END_EFFECTS, new DimensionRenderInfo.End());
			map.putAll(renderInfos);
		});
		ObfuscationReflectionHelper.setPrivateValue(DimensionRenderInfo.class, null, effects, "field_239208_a_");
	}
	
	public static void addStructureSetting(DimensionStructuresSettings structuresSettings, Structure<?> structure) {
		Map<Structure<?>, StructureSeparationSettings> structureMap = new HashMap<>(structuresSettings.structureConfig());
		structureMap.putIfAbsent(structure, DimensionStructuresSettings.DEFAULTS.get(structure));
		ObfuscationReflectionHelper.setPrivateValue(DimensionStructuresSettings.class, structuresSettings, structureMap, "field_236193_d_");
	}
	
	public static void addDefaultStructure(Structure<?> structure, StructureSeparationSettings settings) {
		ImmutableMap<Structure<?>, StructureSeparationSettings> defaultStructureSettings = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
				.putAll(DimensionStructuresSettings.DEFAULTS).put(structure, settings).build();
		ObfuscationReflectionHelper.setPrivateValue(DimensionStructuresSettings.class, null, defaultStructureSettings, "field_236191_b_");
	}
	
	public static void addNoiseStructure(Structure<?> structure) {
		ImmutableList<Structure<?>> noiseStructure = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
		ObfuscationReflectionHelper.setPrivateValue(Structure.class, null, noiseStructure, "field_236384_t_");
	}
	
}
