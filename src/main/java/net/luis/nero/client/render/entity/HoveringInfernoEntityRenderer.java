package net.luis.nero.client.render.entity;

import net.luis.nero.Nero;
import net.luis.nero.client.model.HoveringInfernoModel;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HoveringInfernoEntityRenderer extends MobRenderer<HoveringInfernoEntity, HoveringInfernoModel> {
	
	private static final ResourceLocation HOVERING_INFERNO_LOCATION = new ResourceLocation(Nero.MOD_ID, "textures/entity/hovering_inferno.png");
	
	public HoveringInfernoEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new HoveringInfernoModel(), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(HoveringInfernoEntity hoveringInferno) {
		return HOVERING_INFERNO_LOCATION;
	}
	
}
