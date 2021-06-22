package net.luis.nero.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.luis.nero.api.client.render.ISoulFireEntityRenderer;
import net.luis.nero.common.entity.SoulFireballEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;

public class SoulFireballRenderer extends SpriteRenderer<SoulFireballEntity> implements ISoulFireEntityRenderer<SoulFireballEntity> {

	public SoulFireballRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, Minecraft.getInstance().getItemRenderer(), 0.75F, true);
	}
	
	@Override
	public void render(SoulFireballEntity soulFireball, float entityYaw, float partialTicks, MatrixStack matrix, IRenderTypeBuffer renderBuffer, int packedLight) {
		super.render(soulFireball, entityYaw, partialTicks, matrix, renderBuffer, packedLight);
		if (soulFireball.displaySoulFireAnimation()) {
			this.renderSoulFire(soulFireball, matrix, renderBuffer);
		}
	}

}
