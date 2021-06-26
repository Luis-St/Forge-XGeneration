package net.luis.nero.api.common.util;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class Reflections {
	
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
