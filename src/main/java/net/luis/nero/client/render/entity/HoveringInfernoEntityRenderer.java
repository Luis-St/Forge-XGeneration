 package net.luis.nero.client.render.entity;

import net.luis.nero.Nero;
import net.luis.nero.client.model.HoveringInfernoModel;
import net.luis.nero.client.model.ModModelLayers;
import net.luis.nero.client.render.entity.layer.HoveringInfernoShieldLayer;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HoveringInfernoEntityRenderer extends MobRenderer<HoveringInfernoEntity, HoveringInfernoModel> {
	
	private static final ResourceLocation HOVERING_INFERNO_LOCATION = new ResourceLocation(Nero.MOD_ID, "textures/entity/hovering_inferno.png");
	
	public HoveringInfernoEntityRenderer(Context context) {
		super(context, new HoveringInfernoModel(Nero.getInstance().getModModelSet().bakeLayer(ModModelLayers.HOVERING_INFERNO)), 0.6F);
		this.addLayer(new HoveringInfernoShieldLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(HoveringInfernoEntity hoveringInferno) {
		return HOVERING_INFERNO_LOCATION;
	}
	
}
