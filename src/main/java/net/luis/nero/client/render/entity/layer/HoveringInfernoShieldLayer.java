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
// - 3: large ring with 8 shields 
// TODO: create enum for shield positons
public class HoveringInfernoShieldLayer extends LayerRenderer<HoveringInfernoEntity, HoveringInfernoModel>{

	public HoveringInfernoShieldLayer(IEntityRenderer<HoveringInfernoEntity, HoveringInfernoModel> entityRenderer) {
		super(entityRenderer);
	}
	
	@Override
	public void render(MatrixStack matrix, IRenderTypeBuffer renderBuffer, int packedLight, HoveringInfernoEntity hoveringInferno, float limbSwing, 
			float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch) {
		matrix.pushPose();
		ModelRenderer shieldNorth = this.getParentModel().getNorthShield();
		this.renderShield(shieldNorth, hoveringInferno, partialTicks, Direction.NORTH, 0F);
		ModelRenderer shieldEast = this.getParentModel().getEastShield();
		this.renderShield(shieldEast, hoveringInferno, partialTicks, Direction.EAST, 1.5708F);
		ModelRenderer shieldSouth = this.getParentModel().getSouthShield();
		this.renderShield(shieldSouth, hoveringInferno, partialTicks, Direction.SOUTH, 3.14159F);
		ModelRenderer shieldWest = this.getParentModel().getWestShield();
		this.renderShield(shieldWest, hoveringInferno, partialTicks, Direction.WEST, 4.71239F);
		matrix.popPose();
	}
	
	// TODO: higher rot speed if shields cover
	protected void renderShield(ModelRenderer shield, HoveringInfernoEntity hoveringInferno, float partialTicks, Direction direction, float offset) {
		float oldRot = hoveringInferno.getShieldRotOld(direction) / 20;
		float newRot = hoveringInferno.getShieldRot(direction) / 20;
		shield.yRot = (MathHelper.lerp(partialTicks, oldRot, newRot) % 360) + offset;
	}
	
	/*
	 * shields far away from the entity: 
	 * this.shieldNorth.y = 8; 
	 * this.shieldNorth.z = -10; this.shieldEast.y = 8; 
	 * this.shieldEast.x = -10; 
	 * this.shieldSouth.y = 8; 
	 * this.shieldSouth.z = 10; 
	 * this.shieldWest.y = 8; 
	 * this.shieldWest.x = 10;
	 */
	
}