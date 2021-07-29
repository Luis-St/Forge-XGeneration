package net.luis.nero.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.nero.api.client.render.ISoulFireEntityRenderer;
import net.luis.nero.common.entity.SoulFireballEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class SoulFireballEntityRenderer extends ThrownItemRenderer<SoulFireballEntity> implements ISoulFireEntityRenderer<SoulFireballEntity> {

	public SoulFireballEntityRenderer(Context context) {
		super(context, 0.75F, true);
	}
	
	@Override
	public void render(SoulFireballEntity soulFireball, float entityYaw, float partialTicks, PoseStack matrix, MultiBufferSource renderBuffer, int packedLight) {
		super.render(soulFireball, entityYaw, partialTicks, matrix, renderBuffer, packedLight);
		if (soulFireball.displaySoulFireAnimation()) {
			this.renderSoulFire(soulFireball, matrix, renderBuffer);
		}
	}

}
