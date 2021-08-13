package net.luis.nero.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.core.Direction;

public class HoveringInfernoModel extends EntityModel<HoveringInfernoEntity> {
	
	private final ModelPart head;
	private final ModelPart helmet; // TODO: fix helme rendering
	private final ModelPart body;
	private final ModelPart shieldNorth;
	private final ModelPart shieldWest;
	private final ModelPart shieldSouth;
	private final ModelPart shieldEast;

	public HoveringInfernoModel(ModelPart modelPart) {
		this.head = modelPart.getChild("head");
		this.helmet = modelPart.getChild("helmet");
		this.body = modelPart.getChild("body");
		this.shieldNorth = modelPart.getChild("shieldNorth");
		this.shieldEast = modelPart.getChild("shieldEast");
		this.shieldSouth = modelPart.getChild("shieldSouth");
		this.shieldWest = modelPart.getChild("shieldWest");
	}
	
	public static LayerDefinition createLayerDefinition() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 38).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		partDefinition.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(16, 46).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 21.0F, 4.0F), PartPose.offset(0.0F, 8.0F, 0.0F));
		CubeListBuilder shield = CubeListBuilder.create().addBox(-6.0F, -8.0F, -11.0F, 12.0F, 22.0F, 1.0F);
		partDefinition.addOrReplaceChild("shieldNorth", shield.texOffs(0, 0), PartPose.offset(0.0F, 10.0F, 0.0F));
		partDefinition.addOrReplaceChild("shieldEast", shield.texOffs(26, 23), PartPose.offset(0.0F, 10.0F, 0.0F));
		partDefinition.addOrReplaceChild("shieldSouth", shield.texOffs(0, 23), PartPose.offset(0.0F, 10.0F, 0.0F));
		partDefinition.addOrReplaceChild("shieldWest", shield.texOffs(26, 0), PartPose.offset(0.0F, 10.0F, 0.0F));
		return LayerDefinition.create(meshDefinition, 128, 128);
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
	public void renderToBuffer(PoseStack pose, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		pose.pushPose();
		this.head.render(pose, vertexConsumer, packedLight, packedOverlay);
		this.body.render(pose, vertexConsumer, packedLight, packedOverlay);
		this.shieldNorth.render(pose, vertexConsumer, packedLight, packedOverlay);
		this.shieldEast.render(pose, vertexConsumer, packedLight, packedOverlay);
		this.shieldSouth.render(pose, vertexConsumer, packedLight, packedOverlay);
		this.shieldWest.render(pose, vertexConsumer, packedLight, packedOverlay);
		pose.popPose();
		pose.pushPose();
		pose.scale(1.1f, 1.1f, 1.1f);
		this.helmet.render(pose, vertexConsumer, packedLight, packedOverlay);
		pose.popPose();
	}
	
	public ModelPart getNorthShield() {
		return this.shieldNorth;
	}
	
	public ModelPart getEastShield() {
		return this.shieldEast;
	}
	
	public ModelPart getSouthShield() {
		return this.shieldSouth;
	}
	
	public ModelPart getWestShield() {
		return this.shieldWest;
	}
	
	public ModelPart getShield(Direction direction) {
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
