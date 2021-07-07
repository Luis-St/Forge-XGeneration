package net.luis.nero.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.model.ModelRenderer;

// TODO: use LayerRenderer to render the shields
// TODO: 3 positons of the shields
// - 1: normal
// - 2: cover
// - 3: large ring with 8 shields 
// TODO: create enum for shield positons
// TODO: add custom HeadLayer to HoveringInfernoEntity 
public class HoveringInfernoModel extends EntityModel<HoveringInfernoEntity> implements IHasHead {
	
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
		this.head.setPos(0.0F, 2.0F, 0.0F);
		this.head.texOffs(44, 38).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		this.shieldNorth = new ModelRenderer(this);
		this.shieldNorth.setPos(0.0F, 10.0F, 0.0F);
		this.shieldNorth.texOffs(26, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldWest = new ModelRenderer(this);
		this.shieldWest.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldWest, 0.0F, -1.5708F, 0.0F);
		this.shieldWest.texOffs(26, 0).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldSouth = new ModelRenderer(this);
		this.shieldSouth.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldSouth, 0.0F, 3.1416F, 0.0F);
		this.shieldSouth.texOffs(0, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldEast = new ModelRenderer(this);
		this.shieldEast.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldEast, 0.0F, 1.5708F, 0.0F);
		this.shieldEast.texOffs(26, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.body = new ModelRenderer(this);
		this.body.setPos(0.0F, 8.0F, 0.0F);
		this.body.texOffs(0, 46).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 21.0F, 4.0F, 0.0F, false);
		
	}
	
	protected void setRotationAngle(ModelRenderer modelRenderer, double xRot, double yRot, double zRot) {
		modelRenderer.xRot = (float) xRot;
		modelRenderer.yRot = (float) yRot;
		modelRenderer.zRot = (float) zRot;
	}
	
	protected void setRotations180(ModelRenderer modelRenderer, double xRot, double yRot, double zRot) {
		this.setXRotation180(modelRenderer, xRot);
		this.setYRotation180(modelRenderer, yRot);
		this.setZRotation180(modelRenderer, zRot);
	}
	
	protected void setXRotation180(ModelRenderer modelRenderer, double rot) {
		if (modelRenderer.xRot != rot && rot > 0) {
			modelRenderer.xRot = (float) (rot * (Math.PI / 180));
		}
	}
	
	protected void setYRotation180(ModelRenderer modelRenderer, double rot) {
		if (modelRenderer.yRot != rot && rot > 0) {
			modelRenderer.yRot = (float) (rot * (Math.PI / 180));
		}
	}
	
	protected void setZRotation180(ModelRenderer modelRenderer, double rot) {
		if (modelRenderer.zRot != rot && rot > 0) {
			modelRenderer.zRot = (float) (rot * (Math.PI / 180));
		}
	}
	
	@Override
	public void setupAnim(HoveringInfernoEntity hoveringInferno, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
		this.head.yRot = (float) (headYaw * (Math.PI / 180));
		this.head.xRot = (float) (headPitch * (Math.PI / 180));
//		if (infernoEntity.areShieldsActive()) {
//			this.setXRotation180(this.shieldNorth, 355);
//			this.setZRotation180(this.shieldEast, 5);
//			this.setXRotation180(this.shieldSouth, 355);
//			this.setZRotation180(this.shieldWest, 355);
//		} else {
//
//		}
		this.setXRotation180(this.shieldNorth, 345);
		this.setZRotation180(this.shieldEast, 15);
		this.setXRotation180(this.shieldSouth, 345);
		this.setZRotation180(this.shieldWest, 345);
		this.shieldNorth.y = 6;
		this.shieldNorth.z = 1;
		this.shieldEast.y = 6;
		this.shieldEast.x = 1;
		this.shieldSouth.y = 6;
		this.shieldSouth.z = -1;
		this.shieldWest.y = 6;
		this.shieldWest.x = -1;
	}
	
	@Override
	public void prepareMobModel(HoveringInfernoEntity hoveringInferno, float limbSwing, float limbSwingAmount, float partialTick) {
		
	}
	

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder vertexBuilder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.renderStatic(matrix, vertexBuilder, packedLight, packedOverlay);
		this.renderAnimated(matrix, vertexBuilder, packedLight, packedOverlay);
	}
	
	protected void renderStatic(MatrixStack matrix, IVertexBuilder vertexBuilder, int packedLight, int packedOverlay) {
		this.head.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.body.render(matrix, vertexBuilder, packedLight, packedOverlay);
	}
	
	protected void renderAnimated(MatrixStack matrix, IVertexBuilder vertexBuilder, int packedLight, int packedOverlay) {
		this.shieldNorth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldWest.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldSouth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldEast.render(matrix, vertexBuilder, packedLight, packedOverlay);
	}

	@Override
	public ModelRenderer getHead() {
		return this.head;
	}
	
}

/*
shields far away from the entity:
this.shieldNorth.y = 8;
this.shieldNorth.z = -10;
this.shieldEast.y = 8;
this.shieldEast.x = -10;
this.shieldSouth.y = 8;
this.shieldSouth.z = 10;
this.shieldWest.y = 8;
this.shieldWest.x = 10;
 */


