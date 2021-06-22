package net.luis.nero.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.luis.nero.Nero;
import net.luis.nero.api.client.render.ISoulFireEntityRenderer;
import net.luis.nero.common.entity.SoulBlazeEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.BlazeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class SoulBlazeEntityRenderer extends MobRenderer<SoulBlazeEntity, BlazeModel<SoulBlazeEntity>> implements ISoulFireEntityRenderer<SoulBlazeEntity> {
	
	private static final ResourceLocation SOUL_BLAZE_LOCATION = new ResourceLocation(Nero.MOD_ID, "textures/entity/soul_blaze.png");

	public SoulBlazeEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new BlazeModel<>(), 0.5F);
	}
	
	@Override
	protected int getBlockLightLevel(SoulBlazeEntity soulBlaze, BlockPos pos) {
		return 15;
	}

	@Override
	public ResourceLocation getTextureLocation(SoulBlazeEntity p_110775_1_) {
		return SOUL_BLAZE_LOCATION;
	}
	
	@Override
	public void render(SoulBlazeEntity soulBlaze, float entityYaw, float partialTicks, MatrixStack matrix, IRenderTypeBuffer renderBuffer, int packedLight) {
		super.render(soulBlaze, entityYaw, partialTicks, matrix, renderBuffer, packedLight);
		if (soulBlaze.displaySoulFireAnimation()) {
			this.renderSoulFire(soulBlaze, matrix, renderBuffer);
		}
	}
	
}
