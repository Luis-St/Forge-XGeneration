package net.luis.nero.common.tileentity;

import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BridgeTileEntity extends TileEntity implements ITickableTileEntity {
	
	protected int timeExist = 0;
	
	public BridgeTileEntity() {
		super(ModTileEntityTypes.BRIDGE.get());
	}

	@Override
	public void tick() {
		if (this.timeExist > 0) {
			this.timeExist--;
			if (this.timeExist == 0) {
				this.getLevel().setBlockAndUpdate(this.getBlockPos(), Blocks.AIR.defaultBlockState());
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
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = super.getUpdateTag();
		nbt.putInt("timeExist", this.timeExist);
		return nbt;
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = super.serializeNBT();
		nbt.putInt("timeExist", this.timeExist);
		return nbt;
	}
	
	@Override
	public void deserializeNBT(BlockState state, CompoundNBT nbt) {
		super.deserializeNBT(state, nbt);
		this.timeExist = nbt.getInt("timeExist");
	}
	
}
