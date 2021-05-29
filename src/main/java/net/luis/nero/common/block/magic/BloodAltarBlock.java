package net.luis.nero.common.block.magic;

import net.luis.nero.common.tileentity.BloodAltarTileEntity;
import net.luis.nero.init.items.ModItems;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BloodAltarBlock extends Block {

	public BloodAltarBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BloodAltarTileEntity();
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			ItemStack itemStack = serverPlayer.getItemInHand(hand);
			if (world.getBlockEntity(pos) instanceof BloodAltarTileEntity) {
				BloodAltarTileEntity bloodAltarTileEntity = (BloodAltarTileEntity) world.getBlockEntity(pos);
				if (itemStack.getItem() == Items.BUCKET) {
					int bloodBucket = BloodAltarTileEntity.BloodAltarConstants.BLOOD_BUCKET;
					if (bloodAltarTileEntity.canExtract(bloodBucket)) {
						bloodAltarTileEntity.extractEnergy(bloodBucket, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.setItemInHand(hand, new ItemStack(ModItems.BLOOD_BUCKET.get()));
						}
						return ActionResultType.SUCCESS;
					}
				} else if (itemStack.getItem() == ModItems.BLOOD_BUCKET.get()) {
					int bloodBucket = BloodAltarTileEntity.BloodAltarConstants.BLOOD_BUCKET;
					if (bloodAltarTileEntity.canReceive()) {
						bloodAltarTileEntity.receiveEnergy(bloodBucket, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.setItemInHand(hand, new ItemStack(Items.BUCKET));
						}
						return ActionResultType.SUCCESS;
					}
				} else if (itemStack.getItem() == ModItems.DAGGER.get()) {
					int bloodHeart = BloodAltarTileEntity.BloodAltarConstants.HEART;
					if (bloodAltarTileEntity.canReceive()) {
						bloodAltarTileEntity.receiveEnergy(bloodHeart, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.getItemInHand(hand).hurtAndBreak(1, serverPlayer, livingEntity -> {
								livingEntity.broadcastBreakEvent(hand);
							});
							serverPlayer.hurt(ModDamageSources.DAGGER, 4.0F);
						}
						return ActionResultType.SUCCESS;
					}
				} else {
					bloodAltarTileEntity.update();
				}
			}
		}
		return ActionResultType.PASS;
	}
	
}
