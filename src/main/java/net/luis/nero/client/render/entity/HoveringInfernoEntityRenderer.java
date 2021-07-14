package net.luis.nero.client.render.entity;

import net.luis.nero.Nero;
import net.luis.nero.client.model.HoveringInfernoModel;
import net.luis.nero.client.render.entity.layer.HoveringInfernoShieldLayer;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

//TODO: add custom HeadLayer to HoveringInfernoEntity 
public class HoveringInfernoEntityRenderer extends MobRenderer<HoveringInfernoEntity, HoveringInfernoModel> {
	
	private static final ResourceLocation HOVERING_INFERNO_LOCATION = new ResourceLocation(Nero.MOD_ID, "textures/entity/hovering_inferno.png");
	
	public HoveringInfernoEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new HoveringInfernoModel(), 0.6F);
		this.addLayer(new HoveringInfernoShieldLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(HoveringInfernoEntity hoveringInferno) {
		return HOVERING_INFERNO_LOCATION;
	}
	
}
