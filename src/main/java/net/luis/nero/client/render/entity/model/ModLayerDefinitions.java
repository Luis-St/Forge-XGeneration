package net.luis.nero.client.render.entity.model;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import net.luis.nero.client.render.tileentity.model.BloodAltarModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class ModLayerDefinitions {
	
	public static Map<ModelLayerLocation, LayerDefinition> createLayerDefinitions() {
		Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();
		builder.put(ModModelLayers.HOVERING_INFERNO, HoveringInfernoModel.createLayerDefinition());
		builder.put(ModModelLayers.BLOOD, BloodAltarModel.createLayerDefinition());
		return builder.build();
	}
	
}
