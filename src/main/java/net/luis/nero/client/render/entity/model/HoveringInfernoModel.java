package net.luis.nero.client.render.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.config.ModConfig.Type;

@Config(type = Type.CLIENT)
public class HoveringInfernoModel extends EntityModel<HoveringInfernoEntity> {
	
	@ConfigValue
	private static final Boolean RENDER_HOVERING_INFERNO_HELMET = true;
	
	private final ModelRenderer head;
	private final ModelRenderer helmet; // TODO: fix helme rendering
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
		
		this.helmet = new ModelRenderer(this);
		this.helmet.setPos(0.0F, 24.0F, 0.0F);
		this.helmet.texOffs(16, 46).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		
		this.shieldNorth = new ModelRenderer(this);
		this.shieldNorth.setPos(0.0F, 10.0F, 0.0F);
		this.shieldNorth.texOffs(26, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldWest = new ModelRenderer(this);
		this.shieldWest.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldWest, 0.0F, 0.0F, 0.0F);
		this.shieldWest.texOffs(26, 0).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldSouth = new ModelRenderer(this);
		this.shieldSouth.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldSouth, 0.0F, 0.0F, 0.0F);
		this.shieldSouth.texOffs(0, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.shieldEast = new ModelRenderer(this);
		this.shieldEast.setPos(0.0F, 10.0F, 0.0F);
		this.setRotationAngle(this.shieldEast, 0.0F, 0.0F, 0.0F);
		this.shieldEast.texOffs(26, 23).addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F, 0.0F, false);

		this.body = new ModelRenderer(this);
		this.body.setPos(0.0F, 8.0F, 0.0F);
		this.body.texOffs(0, 46).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 21.0F, 4.0F, 0.0F, false);
		
	}
	
	protected void setRotationAngle(ModelRenderer modelRenderer, float xRot, float yRot, float zRot) {
		modelRenderer.xRot = xRot;
		modelRenderer.yRot = yRot;
		modelRenderer.zRot = zRot;
	}
	
	@Override
	public void setupAnim(HoveringInfernoEntity hoveringInferno, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
		this.head.yRot = (float) (headYaw * (Math.PI / 180));
		this.head.xRot = (float) (headPitch * (Math.PI / 180));
		this.helmet.yRot = (float) (headYaw * (Math.PI / 180));
		this.helmet.xRot = (float) (headPitch * (Math.PI / 180));
	}
	
	@Override
	public void prepareMobModel(HoveringInfernoEntity hoveringInferno, float limbSwing, float limbSwingAmount, float partialTick) {
		
	}
	

	@Override
	public void renderToBuffer(MatrixStack matrix, IVertexBuilder vertexBuilder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrix.pushPose();
		this.head.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.body.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldNorth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldEast.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldSouth.render(matrix, vertexBuilder, packedLight, packedOverlay);
		this.shieldWest.render(matrix, vertexBuilder, packedLight, packedOverlay);
		matrix.popPose();
		matrix.pushPose();
		matrix.scale(1.1f, 1.1f, 1.1f);
		this.helmet.render(matrix, vertexBuilder, packedLight, packedOverlay);
		matrix.popPose();
	}
	
	public ModelRenderer getNorthShield() {
		return this.shieldNorth;
	}
	
	public ModelRenderer getEastShield() {
		return this.shieldEast;
	}
	
	public ModelRenderer getSouthShield() {
		return this.shieldSouth;
	}
	
	public ModelRenderer getWestShield() {
		return this.shieldWest;
	}
	
	public ModelRenderer getShield(Direction direction) {
		switch (direction) {
		case NORTH: return this.getNorthShield();
		case EAST: return this.getEastShield();
		case SOUTH: return this.getSouthShield();
		case WEST: return this.getWestShield();
		default: break;
		}
		throw new IllegalArgumentException("No shield for direction: " + direction);
	}
	
}