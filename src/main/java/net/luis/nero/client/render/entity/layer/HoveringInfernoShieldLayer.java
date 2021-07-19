package net.luis.nero.client.render.entity.layer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.luis.nero.client.render.entity.model.HoveringInfernoModel;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;

// TODO: create anim for shields
// TODO: 3 positons of the shields
// - 1: normal
// - 2: cover
// - 3: attack
// TODO: create enum for shield positons
public class HoveringInfernoShieldLayer extends LayerRenderer<HoveringInfernoEntity, HoveringInfernoModel> {

	public HoveringInfernoShieldLayer(IEntityRenderer<HoveringInfernoEntity, HoveringInfernoModel> entityRenderer) {
		super(entityRenderer);
	}
	
	@Override
	public void render(MatrixStack matrix, IRenderTypeBuffer renderBuffer, int packedLight, HoveringInfernoEntity hoveringInferno, float limbSwing, 
			float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
		matrix.pushPose();
		this.renderShield(hoveringInferno, partialTicks);
		matrix.popPose();
	}
	
	protected void renderShield(HoveringInfernoEntity hoveringInferno, float partialTicks) {
		float[] offsets = new float[] { 0F, 1.5708F, 3.14159F, 4.71239F};
 		for (int i = 0; i < 4; i++) {
			Direction direction = Direction.from2DDataValue(i);
			this.renderShieldYRotation(this.getParentModel().getShield(direction), hoveringInferno, partialTicks, direction, offsets[i]);
			this.renderShieldXRotation(this.getParentModel().getShield(direction), hoveringInferno, partialTicks, direction);
		}
	}
	
	protected void renderShieldYRotation(ModelRenderer shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction, float offset) {
		float yRotO = hoveringInferno.getShieldPos(direction).yRotO * (hoveringInferno.attacking ? 1.45875f : 1.45875f);
		float yRot = hoveringInferno.getShieldPos(direction).yRot * (hoveringInferno.attacking ? 1.45875f : 1.45875f);
		shield.yRot = MathHelper.lerp(partialTicks, yRotO, yRot) + offset;
	}
	
	protected void renderShieldXRotation(ModelRenderer shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction) {
		float xRotO = hoveringInferno.getShieldPos(direction).xRotO;
		float xRot = hoveringInferno.getShieldPos(direction).xRot;
		shield.xRot = MathHelper.lerp(partialTicks, xRotO, xRot);
	}
	
	protected void renderShieldAttackRotation(ModelRenderer shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction) {
		
	}
	
}