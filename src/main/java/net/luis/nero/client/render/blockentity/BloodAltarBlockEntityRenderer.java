package net.luis.nero.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.luis.nero.Nero;
import net.luis.nero.client.model.BloodAltarModel;
import net.luis.nero.client.model.ModModelLayers;
import net.luis.nero.common.block.entity.BloodAltarBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;

public class BloodAltarBlockEntityRenderer implements BlockEntityRenderer<BloodAltarBlockEntity> {
	
	public static final Material TEXTURE_LOCATION = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(Nero.MOD_ID, "entity/blood"));
	private final BloodAltarModel altarModel;
	
	public BloodAltarBlockEntityRenderer(Context context) {
		this.altarModel = new BloodAltarModel(context.bakeLayer(ModModelLayers.BLOOD));
	}
	
	@Override
	public void render(BloodAltarBlockEntity bloodAltarBlockEntity, float partialTicks, PoseStack pose, MultiBufferSource bufferSource, int light, int overlay) {
		pose.pushPose();
		pose.translate(1, 1, 1);
		VertexConsumer vertexBuilder = TEXTURE_LOCATION.buffer(bufferSource, RenderType::entitySolid);
		float bloodHeigth = Mth.lerp(partialTicks, bloodAltarBlockEntity.getPrevious(), bloodAltarBlockEntity.getCurrent());
		this.altarModel.renderBlood(pose, vertexBuilder, light, overlay, bloodHeigth);
		pose.popPose();
	}

}
