package net.luis.nero.api.common.util;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class Reflections {
	
	public static void addDimensionRenderInfos(Map<ResourceLocation, DimensionSpecialEffects> specialEffects) {
		Object2ObjectMap<ResourceLocation, DimensionSpecialEffects> effects = Util.make(new Object2ObjectArrayMap<>(), (map) -> {
			DimensionSpecialEffects.OverworldEffects overworldEffects = new DimensionSpecialEffects.OverworldEffects();
			map.defaultReturnValue(overworldEffects);
			map.put(DimensionType.OVERWORLD_EFFECTS, overworldEffects);
			map.put(DimensionType.NETHER_EFFECTS, new DimensionSpecialEffects.NetherEffects());
			map.put(DimensionType.END_EFFECTS, new DimensionSpecialEffects.EndEffects());
			map.putAll(specialEffects);
		});
		ObfuscationReflectionHelper.setPrivateValue(DimensionSpecialEffects.class, null, effects, "field_239208_a_");
	}
	
	// TODO: fix adding default structures
	public static void addStructureSetting(StructureSettings structuresSettings, StructureFeature<?> structure) {
		Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = new HashMap<>(structuresSettings.structureConfig());
		structureMap.putIfAbsent(structure, StructureSettings.DEFAULTS.get(structure));
		ObfuscationReflectionHelper.setPrivateValue(StructureSettings.class, structuresSettings, structureMap, "field_236193_d_");
	}
	
	public static void addDefaultStructure(StructureFeature<?> structure, StructureFeatureConfiguration structureConfig) {
		ImmutableMap<StructureFeature<?>, StructureFeatureConfiguration> defaultStructureSettings = ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
				.putAll(StructureSettings.DEFAULTS).put(structure, structureConfig).build();
		ObfuscationReflectionHelper.setPrivateValue(StructureSettings.class, null, defaultStructureSettings, "field_236191_b_");
	}
	
	public static void addNoiseStructure(StructureFeature<?> structure) {
		ImmutableList<StructureFeature<?>> noiseStructure = ImmutableList.<StructureFeature<?>>builder().addAll(StructureFeature.NOISE_AFFECTING_FEATURES).add(structure).build();
		ObfuscationReflectionHelper.setPrivateValue(StructureFeature.class, null, noiseStructure, "field_236384_t_");
	}
	
}
