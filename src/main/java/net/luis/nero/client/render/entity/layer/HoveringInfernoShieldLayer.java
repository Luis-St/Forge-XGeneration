package net.luis.nero.client.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.nero.client.render.entity.model.HoveringInfernoModel;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;

public class HoveringInfernoShieldLayer extends RenderLayer<HoveringInfernoEntity, HoveringInfernoModel> {

	public HoveringInfernoShieldLayer(RenderLayerParent<HoveringInfernoEntity, HoveringInfernoModel> entityRenderer) {
		super(entityRenderer);
	}
	
	@Override
	public void render(PoseStack pose, MultiBufferSource bufferSource, int packedLight, HoveringInfernoEntity hoveringInferno, float limbSwing, 
			float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
		pose.pushPose();
		this.renderShield(hoveringInferno, partialTicks);
		pose.popPose();
	}
	
	protected void renderShield(HoveringInfernoEntity hoveringInferno, float partialTicks) {
		float[] offsets = new float[] { 0F, 1.5708F, 3.14159F, 4.71239F};
 		for (int i = 0; i < 4; i++) {
			Direction direction = Direction.from2DDataValue(i);
			this.renderShieldYRotation(this.getParentModel().getShield(direction), hoveringInferno, partialTicks, direction, offsets[i]);
			this.renderShieldXRotation(this.getParentModel().getShield(direction), hoveringInferno, partialTicks, direction);
		}
	}
	
	protected void renderShieldYRotation(ModelPart shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction, float offset) {
		float yRotO = hoveringInferno.getShieldPos(direction).yRotO * (hoveringInferno.attacking ? 1.45875f : 1.45875f);
		float yRot = hoveringInferno.getShieldPos(direction).yRot * (hoveringInferno.attacking ? 1.45875f : 1.45875f);
		shield.yRot = Mth.lerp(partialTicks, yRotO, yRot) + offset;
	}
	
	protected void renderShieldXRotation(ModelPart shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction) {
		float xRotO = hoveringInferno.getShieldPos(direction).xRotO;
		float xRot = hoveringInferno.getShieldPos(direction).xRot;
		shield.xRot = Mth.lerp(partialTicks, xRotO, xRot);
	}
	
}