package net.luis.nero.common.block.entity;

import net.luis.nero.init.block.util.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BridgeBlockEntity extends BlockEntity {
	
	protected int timeExist = 0;
	
	public BridgeBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.BRIDGE.get(), pos, state);
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BridgeBlockEntity bridgeTileEntity) {
		if (bridgeTileEntity.timeExist > 0) {
			bridgeTileEntity.timeExist--;
			if (bridgeTileEntity.timeExist == 0) {
				bridgeTileEntity.getLevel().setBlockAndUpdate(bridgeTileEntity.getBlockPos(), Blocks.AIR.defaultBlockState());
			}
		}
	}
	
	public int getTimeExist() {
		return timeExist;
	}
	
	public void setTimeExist(int timeExist) {
		this.timeExist = timeExist;
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
		tag.putInt("timeExist", this.timeExist);
		return tag;
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag tag = super.serializeNBT();
		tag.putInt("timeExist", this.timeExist);
		return tag;
	}
	
	@Override
	public void deserializeNBT(CompoundTag tag) {
		super.deserializeNBT(tag);
		this.timeExist = tag.getInt("timeExist");
	}
	
}
