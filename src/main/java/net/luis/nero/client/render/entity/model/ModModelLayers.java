package net.luis.nero.client.render.entity.model;

import net.luis.nero.Nero;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
	
	public static final ModelLayerLocation HOVERING_INFERNO = register("hovering_inferno");
	public static final ModelLayerLocation BLOOD = register("blood");
	
	public static ModelLayerLocation register(String entityName) {
		return new ModelLayerLocation(new ResourceLocation(Nero.MOD_ID, entityName), "main");
	}
	
}
