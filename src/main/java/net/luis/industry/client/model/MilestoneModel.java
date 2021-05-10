package net.luis.industry.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MilestoneModel extends Model {
	
	private final ModelRenderer milestone;
	private final ModelRenderer inner;
	private final ModelRenderer outer;
	private final ModelRenderer north;
	private final ModelRenderer east;
	private final ModelRenderer south;
	private final ModelRenderer west;

	public MilestoneModel() {
		
		super(RenderType::entitySolid);
		
		this.texWidth = 128;
		this.texHeight = 128;

		this.milestone = new ModelRenderer(this);
		this.milestone.setPos(-8.0F, -5.0F, -8.0F);
		
		this.inner = new ModelRenderer(this);
		this.inner.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(inner);
		this.inner.texOffs(0, 48).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);
		
		this.outer = new ModelRenderer(this);
		this.outer.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(outer);
		this.outer.texOffs(48, 0).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 5.0F, 12.0F, 0.0F, false);

		this.north = new ModelRenderer(this);
		this.north.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(north);
		this.north.texOffs(24, 30).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		this.east = new ModelRenderer(this);
		this.east.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(east);
		this.setRotationAngle(east, 0.0F, 0.7854F, 0.0F);
		this.east.texOffs(0, 24).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		this.south = new ModelRenderer(this);
		this.south.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(south);
		this.setRotationAngle(south, 0.0F, 1.5708F, 0.0F);
		this.south.texOffs(24, 6).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		this.west = new ModelRenderer(this);
		this.west.setPos(0.0F, 0.0F, 0.0F);
		this.milestone.addChild(west);
		this.setRotationAngle(west, 0.0F, -0.7854F, 0.0F);
		this.west.texOffs(0, 0).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);
	}
	
	public void rotationRender(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float rotation) {
		this.milestone.yRot = rotation;
		this.milestone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	@Deprecated
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		throw new UnsupportedOperationException();
	}
	
	protected void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot= x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

}