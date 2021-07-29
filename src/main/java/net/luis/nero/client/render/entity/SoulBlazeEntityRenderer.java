package net.luis.nero.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.nero.Nero;
import net.luis.nero.api.client.render.ISoulFireEntityRenderer;
import net.luis.nero.common.entity.SoulBlazeEntity;
import net.minecraft.client.model.BlazeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class SoulBlazeEntityRenderer extends MobRenderer<SoulBlazeEntity, BlazeModel<SoulBlazeEntity>> implements ISoulFireEntityRenderer<SoulBlazeEntity> {

	private static final ResourceLocation SOUL_BLAZE_LOCATION = new ResourceLocation(Nero.MOD_ID, "textures/entity/soul_blaze.png");

	public SoulBlazeEntityRenderer(Context context) {
		super(context, new BlazeModel<>(context.bakeLayer(ModelLayers.BLAZE)), 0.5F);
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
	public void render(SoulBlazeEntity soulBlaze, float entityYaw, float partialTicks, PoseStack matrix, MultiBufferSource renderBuffer, int packedLight) {
		super.render(soulBlaze, entityYaw, partialTicks, matrix, renderBuffer, packedLight);
		if (soulBlaze.displaySoulFireAnimation()) {
			this.renderSoulFire(soulBlaze, matrix, renderBuffer);
		}
	}
	
}
