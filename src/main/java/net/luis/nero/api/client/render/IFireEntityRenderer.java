package net.luis.nero.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.resources.ResourceLocation;
import com.mojang.math.Vector3f;

public interface IFireEntityRenderer<T extends Entity> {
	
	public static final Material FIRE_0 = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("block/fire_0"));
	public static final Material FIRE_1 = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("block/fire_1"));
	
	@SuppressWarnings("resource")
	default void renderFire(T entity, PoseStack matrix, MultiBufferSource renderBuffer) {
		TextureAtlasSprite fireSprite0 = FIRE_0.sprite();
		TextureAtlasSprite fireSprite1 = FIRE_1.sprite();
		matrix.pushPose();
		float entityWidth = entity.getBbWidth() * 1.4F;
		matrix.scale(entityWidth, entityWidth, entityWidth);
		float x = 0.5F;
		float entityHeight = entity.getBbHeight() / entityWidth;
		float f4 = 0.0F;
		matrix.mulPose(Vector3f.YP.rotationDegrees(-Minecraft.getInstance().getEntityRenderDispatcher().camera.getYRot()));
		matrix.translate(0.0D, 0.0D, (double) (-0.3F + (float) ((int) entityHeight) * 0.02F));
		float f5 = 0.0F;
		int i = 0;
		VertexConsumer vertexBuilder = renderBuffer.getBuffer(Sheets.cutoutBlockSheet());

		for (PoseStack.Pose matrixEntry = matrix.last(); entityHeight > 0.0F; ++i) {
			TextureAtlasSprite fireSprite = i % 2 == 0 ? fireSprite0 : fireSprite1;
			float u0 = fireSprite.getU0();
			float v0 = fireSprite.getV0();
			float u1 = fireSprite.getU1();
			float v1 = fireSprite.getV1();
			if (i / 2 % 2 == 0) {
				float f = u1;
				u1 = u0;
				u0 = f;
			}

			fireVertex(matrixEntry, vertexBuilder, x - 0.0F, 0.0F - f4, f5, u1, v1);
			fireVertex(matrixEntry, vertexBuilder, -x - 0.0F, 0.0F - f4, f5, u0, v1);
			fireVertex(matrixEntry, vertexBuilder, -x - 0.0F, 1.4F - f4, f5, u0, v0);
			fireVertex(matrixEntry, vertexBuilder, x - 0.0F, 1.4F - f4, f5, u1, v0);
			entityHeight -= 0.45F;
			f4 -= 0.45F;
			x *= 0.9F;
			f5 += 0.03F;
		}
		matrix.popPose();
	}
	
	static void fireVertex(PoseStack.Pose matrixEntry, VertexConsumer vertexBuilder, float x, float y, float z, float u, float v) {
		vertexBuilder.vertex(matrixEntry.pose(), x, y, z).color(255, 255, 255, 255).uv(u, v).overlayCoords(0, 10)
				.uv2(240).normal(matrixEntry.normal(), 0.0F, 1.0F, 0.0F).endVertex();
	}
	
}
