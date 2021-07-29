package net.luis.nero.common.tileentity;

import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BridgeTileEntity extends BlockEntity {
	
	protected int timeExist = 0;
	
	public BridgeTileEntity(BlockPos pos, BlockState state) {
		super(ModTileEntityTypes.BRIDGE.get(), pos, state);
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BridgeTileEntity bridgeTileEntity) {
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
		CompoundTag nbt = super.getUpdateTag();
		nbt.putInt("timeExist", this.timeExist);
		return nbt;
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = super.serializeNBT();
		nbt.putInt("timeExist", this.timeExist);
		return nbt;
	}
	
	@Override
	public void deserializeNBT(CompoundTag nbt) {
		super.deserializeNBT(nbt);
		this.timeExist = nbt.getInt("timeExist");
	}
	
}
