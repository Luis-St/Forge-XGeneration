package net.luis.nero.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.Mob;

public abstract class SoulFireModRenderer<T extends Mob & ISoulFireEntity, M extends EntityModel<T>> extends MobRenderer<T, M> implements ISoulFireEntityRenderer<T> {

	public SoulFireModRenderer(Context context, M model, float shadowRadius) {
		super(context, model, shadowRadius);
	}
	
	@Override
	public void render(T entity, float entityYaw, float partialTicks, PoseStack pose, MultiBufferSource bufferSource, int packedLight) {
		super.render(entity, entityYaw, partialTicks, pose, bufferSource, packedLight);
		if (entity.displaySoulFireAnimation()) {
			this.renderSoulFire(entity, pose, bufferSource);
		}
	}

}
