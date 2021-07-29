package net.luis.nero.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

public class BloodAltarModel extends Model {
	
	private final ModelPart blood;

	public BloodAltarModel(ModelPart modelPart) {
		super(RenderType::entitySolid);
		this.blood = modelPart.getChild("blood");
	}
	
	public void renderBlood(PoseStack pose, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float bloodHeigth) {
		this.blood.y = Mth.clamp(bloodHeigth + 6, 6.0F, 9.75F);
		this.blood.render(pose, vertexConsumer, packedLight, packedOverlay);
	}
	
	public static LayerDefinition createLayerDefinition() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		CubeListBuilder blood = CubeListBuilder.create().addBox(-4.0F, -11.0F, -4.0F, 8.0F, 0.0F, 8.0F).texOffs(0, 0);
		partDefinition.addOrReplaceChild("blood", blood, PartPose.offset(-8.0F, 6.0F, -8.0F));
		return LayerDefinition.create(meshDefinition, 32, 32);
	}
	
	@Override
	@Deprecated
	public final void renderToBuffer(PoseStack pose, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

}