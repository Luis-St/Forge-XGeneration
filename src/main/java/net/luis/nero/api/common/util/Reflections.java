package net.luis.nero.api.common.util;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

// TODO: use SRG names
public class Reflections {
	
	public static void addDimensionRenderInfos(Map<ResourceLocation, DimensionSpecialEffects> renderInfos) {
		Object2ObjectMap<ResourceLocation, DimensionSpecialEffects> effects = Util.make(new Object2ObjectArrayMap<>(), (map) -> {
			DimensionSpecialEffects.OverworldEffects overworldRenderInfo = new DimensionSpecialEffects.OverworldEffects();
			map.defaultReturnValue(overworldRenderInfo);
			map.put(DimensionType.OVERWORLD_EFFECTS, overworldRenderInfo);
			map.put(DimensionType.NETHER_EFFECTS, new DimensionSpecialEffects.NetherEffects());
			map.put(DimensionType.END_EFFECTS, new DimensionSpecialEffects.EndEffects());
			map.putAll(renderInfos);
		});
		ObfuscationReflectionHelper.setPrivateValue(DimensionSpecialEffects.class, null, effects, "EFFECTS");
	}
	
	// TODO: fix adding default structures
/*	public static void addStructureSetting(StructureSettings structuresSettings, StructureFeature<?> structure) {
		Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = new HashMap<>(structuresSettings.structureConfig());
		structureMap.putIfAbsent(structure, StructureSettings.DEFAULTS.get(structure));
		ObfuscationReflectionHelper.setPrivateValue(StructureSettings.class, structuresSettings, structureMap, "structureConfig");
	}
	
	public static void addDefaultStructure(StructureFeature<?> structure, StructureFeatureConfiguration settings) {
		ImmutableMap<StructureFeature<?>, StructureFeatureConfiguration> defaultStructureSettings = ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
				.putAll(StructureSettings.DEFAULTS).put(structure, settings).build();
		ObfuscationReflectionHelper.setPrivateValue(StructureSettings.class, null, defaultStructureSettings, "DEFAULTS");
	}
	
	public static void addNoiseStructure(StructureFeature<?> structure) {
		ImmutableList<StructureFeature<?>> noiseStructure = ImmutableList.<StructureFeature<?>>builder().addAll(StructureFeature.NOISE_AFFECTING_FEATURES).add(structure).build();
		ObfuscationReflectionHelper.setPrivateValue(StructureFeature.class, null, noiseStructure, "NOISE_AFFECTING_FEATURES");
	}*/
	
}
