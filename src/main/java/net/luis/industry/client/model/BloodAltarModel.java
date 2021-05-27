package net.luis.industry.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class BloodAltarModel extends Model {
	
	private final ModelRenderer blood;

	public BloodAltarModel() {
		super(RenderType::entitySolid);
		this.texWidth = 32;
		this.texHeight = 32;
		this.blood = new ModelRenderer(this);
		this.blood.setPos(-8.0F, 6.0F, -8.0F);
		this.blood.texOffs(0, 0).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);
	}
	
	public void renderBlood(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float bloodHeigth) {
		this.blood.y = MathHelper.clamp(bloodHeigth + 6, 6.0F, 9.75F);
		this.blood.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	
	@Override
	@Deprecated
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		throw new UnsupportedOperationException();
	}

}