package net.luis.nero.client.render.entity.model;

import java.util.Map;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class ModEntityModelSet {
	
	private final Map<ModelLayerLocation, LayerDefinition> layerDefinitions;
	
	public ModEntityModelSet() {
		this.layerDefinitions = ModLayerDefinitions.createLayerDefinitions();
	}
	
	public ModelPart bakeLayer(ModelLayerLocation modelLayer) {
		LayerDefinition layerDefinition = this.layerDefinitions.get(modelLayer);
		if (layerDefinition == null) {
			throw new IllegalArgumentException("No model for layer " + modelLayer);
		} else {
			return layerDefinition.bakeRoot();
		}
	}
	
}
