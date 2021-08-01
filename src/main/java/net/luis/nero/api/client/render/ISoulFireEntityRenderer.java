package net.luis.nero.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.resources.ResourceLocation;
import com.mojang.math.Vector3f;

public interface ISoulFireEntityRenderer<T extends Entity & ISoulFireEntity> {
	
	public static final Material SOUL_FIRE_0 = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("block/soul_fire_0"));
	public static final Material SOUL_FIRE_1 = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("block/soul_fire_1"));
	
	@SuppressWarnings("resource")
	default void renderSoulFire(T entity, PoseStack pose, MultiBufferSource bufferSource) {
		TextureAtlasSprite soulFireSprite0 = SOUL_FIRE_0.sprite();
		TextureAtlasSprite soulFireSprite1 = SOUL_FIRE_1.sprite();
		pose.pushPose();
		float entityWidth = entity.getBbWidth() * 1.4F;
		pose.scale(entityWidth, entityWidth, entityWidth);
		float x = 0.5F;
		float entityHeight = entity.getBbHeight() / entityWidth;
		float f4 = 0.0F;
		pose.mulPose(Vector3f.YP.rotationDegrees(-Minecraft.getInstance().getEntityRenderDispatcher().camera.getYRot()));
		pose.translate(0.0D, 0.0D, (double) (-0.3F + (float) ((int) entityHeight) * 0.02F));
		float f5 = 0.0F;
		int i = 0;
		VertexConsumer vertexConsumer = bufferSource.getBuffer(Sheets.cutoutBlockSheet());

		for (PoseStack.Pose poseEntry = pose.last(); entityHeight > 0.0F; ++i) {
			TextureAtlasSprite soulFireSprite = i % 2 == 0 ? soulFireSprite0 : soulFireSprite1;
			float u0 = soulFireSprite.getU0();
			float v0 = soulFireSprite.getV0();
			float u1 = soulFireSprite.getU1();
			float v1 = soulFireSprite.getV1();
			if (i / 2 % 2 == 0) {
				float f = u1;
				u1 = u0;
				u0 = f;
			}

			soulFireVertex(poseEntry, vertexConsumer, x - 0.0F, 0.0F - f4, f5, u1, v1);
			soulFireVertex(poseEntry, vertexConsumer, -x - 0.0F, 0.0F - f4, f5, u0, v1);
			soulFireVertex(poseEntry, vertexConsumer, -x - 0.0F, 1.4F - f4, f5, u0, v0);
			soulFireVertex(poseEntry, vertexConsumer, x - 0.0F, 1.4F - f4, f5, u1, v0);
			entityHeight -= 0.45F;
			f4 -= 0.45F;
			x *= 0.9F;
			f5 += 0.03F;
		}
		pose.popPose();
	}
	
	static void soulFireVertex(PoseStack.Pose matrixEntry, VertexConsumer vertexConsumer, float x, float y, float z, float u, float v) {
		vertexConsumer.vertex(matrixEntry.pose(), x, y, z).color(255, 255, 255, 255).uv(u, v).overlayCoords(0, 10)
				.uv2(240).normal(matrixEntry.normal(), 0.0F, 1.0F, 0.0F).endVertex();
	}

}
