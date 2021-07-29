package net.luis.nero.common.block.magic;

import net.luis.nero.common.tileentity.BloodAltarTileEntity;
import net.luis.nero.init.items.ModItems;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BloodAltarBlock extends /*BaseEntity*/Block {

	public BloodAltarBlock(Properties properties) {
		super(properties);
	}
	
//	@Override
//	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//		return new BloodAltarTileEntity(pos, state);
//	}
//	
//	@Override
//	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> blockEntityType) {
//		return world.isClientSide ? null : createTickerHelper(blockEntityType, ModTileEntityTypes.BLOOD_ALTAR.get(), BloodAltarTileEntity::serverTick);
//	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
		if (player instanceof ServerPlayer) {
			ServerPlayer serverPlayer = (ServerPlayer) player;
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
						return InteractionResult.SUCCESS;
					}
				} else if (itemStack.getItem() == ModItems.BLOOD_BUCKET.get()) {
					int bloodBucket = BloodAltarTileEntity.BloodAltarConstants.BLOOD_BUCKET;
					if (bloodAltarTileEntity.canReceive()) {
						bloodAltarTileEntity.receiveEnergy(bloodBucket, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.setItemInHand(hand, new ItemStack(Items.BUCKET));
						}
						return InteractionResult.SUCCESS;
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
						return InteractionResult.SUCCESS;
					}
				} else {
					bloodAltarTileEntity.update();
				}
			}
		}
		return InteractionResult.PASS;
	}

}
