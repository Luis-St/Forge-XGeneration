package net.luis.industry.client.render.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.luis.industry.Industry;
import net.luis.industry.client.model.BloodAltarModel;
import net.luis.industry.common.tileentity.BloodAltarTileEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class BloodAltarTileEntityRenderer extends TileEntityRenderer<BloodAltarTileEntity> {
	
	public static final RenderMaterial TEXTURE_LOCATION = new RenderMaterial(PlayerContainer.BLOCK_ATLAS, new ResourceLocation(Industry.MOD_ID, "entity/blood"));
	private final BloodAltarModel altarModel = new BloodAltarModel();
	
	public BloodAltarTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcher) {
		super(rendererDispatcher);
	}

	@Override
	public void render(BloodAltarTileEntity bloodAltarTileEntity, float partialTicks, MatrixStack matrix, IRenderTypeBuffer renderBuffer, int light, int overlay) {
		matrix.pushPose();
		matrix.translate(1, 1, 1);
		IVertexBuilder vertexBuilder = TEXTURE_LOCATION.buffer(renderBuffer, RenderType::entitySolid);
		float bloodHeigth = MathHelper.lerp(partialTicks, bloodAltarTileEntity.getPrevious(), bloodAltarTileEntity.getCurrent());
		this.altarModel.renderBlood(matrix, vertexBuilder, light, overlay, bloodHeigth);
		matrix.popPose();
	}

}
