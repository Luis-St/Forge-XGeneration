package net.luis.nero.api.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public interface ISoulFireEntityRenderer<T extends Entity> {
	
	public static final RenderMaterial SOUL_FIRE_0 = new RenderMaterial(PlayerContainer.BLOCK_ATLAS, new ResourceLocation("block/soul_fire_0"));
	public static final RenderMaterial SOUL_FIRE_1 = new RenderMaterial(PlayerContainer.BLOCK_ATLAS, new ResourceLocation("block/soul_fire_1"));
	
	@SuppressWarnings("resource")
	default void renderSoulFire(T entity, MatrixStack matrix, IRenderTypeBuffer renderBuffer) {
		TextureAtlasSprite soulFireSprite0 = SOUL_FIRE_0.sprite();
		TextureAtlasSprite soulFireSprite1 = SOUL_FIRE_1.sprite();
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
		IVertexBuilder vertexBuilder = renderBuffer.getBuffer(Atlases.cutoutBlockSheet());

		for (MatrixStack.Entry matrixEntry = matrix.last(); entityHeight > 0.0F; ++i) {
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
	
	static void fireVertex(MatrixStack.Entry matrixEntry, IVertexBuilder vertexBuilder, float x, float y, float z, float u, float v) {
		vertexBuilder.vertex(matrixEntry.pose(), x, y, z).color(255, 255, 255, 255).uv(u, v).overlayCoords(0, 10)
				.uv2(240).normal(matrixEntry.normal(), 0.0F, 1.0F, 0.0F).endVertex();
	}

}
