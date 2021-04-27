package net.luis.industry.client.render.tileentity;

import static net.luis.industry.Industry.MOD_ID;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.luis.industry.client.model.MilestoneModel;
import net.luis.industry.common.tileentity.MilestoneTileEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;

public class MilestoneTileEntityRenderer extends TileEntityRenderer<MilestoneTileEntity> {
	
	public static final RenderMaterial TEXTURE_LOCATION = new RenderMaterial(PlayerContainer.BLOCK_ATLAS, new ResourceLocation(MOD_ID, "entity/mile"));
	protected final MilestoneModel milestone = new MilestoneModel();
	
	public MilestoneTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcher) {
		super(rendererDispatcher);
	}

	@Override
	public void render(MilestoneTileEntity milestoneTileEntity, float partialTicks, MatrixStack matrix, IRenderTypeBuffer renderBuffer, int light, int overlay) {
		matrix.pushPose();
		matrix.translate(1, 1, 1);
		IVertexBuilder vertexBuilder = TEXTURE_LOCATION.buffer(renderBuffer, RenderType::entitySolid);
		this.milestone.rotationRender(matrix, vertexBuilder, light, overlay, milestoneTileEntity.isProgressing() ? 10 : 0);
		matrix.popPose();
	}
	
}
