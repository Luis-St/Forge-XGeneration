package net.luis.nero.common.block.magic;

import net.luis.nero.common.block.entity.BloodAltarBlockEntity;
import net.luis.nero.init.block.util.ModBlockEntityTypes;
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
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BloodAltarBlock extends BaseEntityBlock {

	public BloodAltarBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new BloodAltarBlockEntity(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntityTypes.BLOOD_ALTAR.get(), BloodAltarBlockEntity::serverTick);
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (player instanceof ServerPlayer) {
			ServerPlayer serverPlayer = (ServerPlayer) player;
			ItemStack itemStack = serverPlayer.getItemInHand(hand);
			if (level.getBlockEntity(pos) instanceof BloodAltarBlockEntity) {
				BloodAltarBlockEntity bloodAltarTileEntity = (BloodAltarBlockEntity) level.getBlockEntity(pos);
				if (itemStack.getItem() == Items.BUCKET) {
					int bloodBucket = BloodAltarBlockEntity.BloodAltarConstants.BLOOD_BUCKET;
					if (bloodAltarTileEntity.canExtract(bloodBucket)) {
						bloodAltarTileEntity.extractEnergy(bloodBucket, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.setItemInHand(hand, new ItemStack(ModItems.BLOOD_BUCKET.get()));
						}
						return InteractionResult.SUCCESS;
					}
				} else if (itemStack.getItem() == ModItems.BLOOD_BUCKET.get()) {
					int bloodBucket = BloodAltarBlockEntity.BloodAltarConstants.BLOOD_BUCKET;
					if (bloodAltarTileEntity.canReceive()) {
						bloodAltarTileEntity.receiveEnergy(bloodBucket, false);
						if (!serverPlayer.isCreative()) {
							serverPlayer.setItemInHand(hand, new ItemStack(Items.BUCKET));
						}
						return InteractionResult.SUCCESS;
					}
				} else if (itemStack.getItem() == ModItems.DAGGER.get()) {
					int bloodHeart = BloodAltarBlockEntity.BloodAltarConstants.HEART;
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
