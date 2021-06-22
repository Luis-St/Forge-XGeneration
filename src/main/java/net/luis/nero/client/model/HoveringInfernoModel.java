package net.luis.nero.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// TODO: finish
public class HoveringInfernoModel<T extends Entity> extends EntityModel<T> {
	
	private final ModelRenderer head;
	private final ModelRenderer shieldNorth;
	private final ModelRenderer shieldWest;
	private final ModelRenderer shieldSouth;
	private final ModelRenderer shieldEast;
	private final ModelRenderer body;

	public HoveringInfernoModel() {
		this.texWidth = 128;
		this.texHeight = 128;

		this.head = new ModelRenderer(this);
		this.head.setPos(0.0F, 8.0F, 0.0F);
		this.head.texOffs(44, 38).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		
		this.body = new ModelRenderer(this);
		this.body.setPos(0.0F, 8.0F, 0.0F);
		this.body.texOffs(0, 46).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 21.0F, 4.0F, 0.0F, false);
		
		this.shieldNorth = new ModelRenderer(this);
		this.shieldNorth.setPos(0.0F, 8.0F, 0.0F);
		this.setRotationAngle(shieldNorth, -0.1745F, -0.7854F, 0.0F);
		this.shieldNorth.texOffs(26, 23).addBox(-6.0F, -5.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldWest = new ModelRenderer(this);
		this.shieldWest.setPos(0.0F, 8.0F, 0.0F);
		this.setRotationAngle(shieldWest, -0.1745F, -2.3562F, 0.0F);
		this.shieldWest.texOffs(26, 0).addBox(-6.0F, -5.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldSouth = new ModelRenderer(this);
		this.shieldSouth.setPos(0.0F, 8.0F, 0.0F);
		this.setRotationAngle(shieldSouth, -0.1745F, 2.3562F, 0.0F);
		this.shieldSouth.texOffs(0, 23).addBox(-6.0F, -5.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldEast = new ModelRenderer(this);
		this.shieldEast.setPos(0.0F, 8.0F, 0.0F);
		this.setRotationAngle(shieldEast, -0.1745F, 0.7854F, 0.0F);
		this.shieldEast.texOffs(26, 23).addBox(-6.0F, -5.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder vertexBuilder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

	}
	
	public void render(T entity, MatrixStack matrix, IVertexBuilder vertexBuilder, float partialTicks, int packedLight, int packedOverlay) {
		this.renderStatic(entity, matrix, vertexBuilder, partialTicks, packedLight, packedOverlay);
		this.renderAnimated(entity, matrix, vertexBuilder, partialTicks, packedLight, packedOverlay);
	}
	
	protected void renderStatic(T entity, MatrixStack matrix, IVertexBuilder vertexBuilder, float partialTicks, int packedLight, int packedOverlay) {
		this.head.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.body.render(matrix, vertexBuilder, packedLight, packedOverlay);
	}
	
	protected void renderAnimated(T entity, MatrixStack matrix, IVertexBuilder vertexBuilder, float partialTicks, int packedLight, int packedOverlay) {
		this.shieldNorth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldWest.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldSouth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldEast.render(matrix, vertexBuilder, packedLight, packedOverlay);
	}
	
}
