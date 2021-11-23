package net.luis.nero.common.block.entity;

import net.luis.nero.init.block.util.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BloodAltarBlockEntity extends BlockEntity implements IAnimatedBlockEntity, IEnergyBlockEntity<BloodAltarBlockEntity> {
	
	protected int blood = 0;
	protected int currentBlood = 0;
	protected int previousBlood = 0;
	
	public BloodAltarBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.BLOOD_ALTAR.get(), pos, state);
	}

	@Override
	public float getCurrent() {
		return (float) this.currentBlood / (float) this.getEnergyMultiplier();
	}

	@Override
	public float getPrevious() {
		return (float) this.previousBlood / (float) this.getEnergyMultiplier();
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BloodAltarBlockEntity bloodAltarTileEntity) {
		bloodAltarTileEntity.currentBlood = bloodAltarTileEntity.blood;
		bloodAltarTileEntity.previousBlood = bloodAltarTileEntity.currentBlood;
	}
	
	public void update() {
		this.blood++;
		this.blood--;
		this.markUpdated();
	}

	@Override
	public int receiveEnergy(int receive, boolean simulate) {
		this.onEnergyReceive(this, receive);
		if (!this.canReceive()) {
			return 0;
		}
		int received = Math.min(this.getMaxEnergyStored() - this.getEnergyStored(), receive);
		if (!simulate) {
			this.blood += received;
			this.markUpdated();
		}
		return received;
	}

	@Override
	public int extractEnergy(int extract, boolean simulate) {
		this.onEnergyExtract(this, extract);
		if (!this.canExtract()) {
			return 0;
		}
		int extracted = Math.min(this.blood, extract);
		if (!simulate) {
			this.blood -= extracted;
			this.markUpdated();
		}
		return extracted;
	}

	@Override
	public int getEnergyStored() {
		return this.blood;
	}
	
	protected float getEnergyBase() {
		return 3.75F;
	}

	protected int getEnergyMultiplier() {
		return 10000;
	}
	
	@Override
	public int getMaxEnergyStored() {
		return (int) (this.getEnergyBase() * this.getEnergyMultiplier());
	}

	@Override
	public boolean canExtract() {
		return this.blood > 0;
	}
	
	public boolean canExtract(int blood) {
		return this.blood >= blood;
	}

	@Override
	public boolean canReceive() {
		return this.getMaxEnergyStored() > this.blood;
	}
	
	public boolean canReceive(int blood) {
		return this.getMaxEnergyStored() >= this.blood + blood;
	}
	
	protected void markUpdated() {
		if (this.getLevel() != null) {
			this.setChanged();
			this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
		}
	}
	
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return new ClientboundBlockEntityDataPacket(this.worldPosition, -1, this.saveData());
	}
	
	@Override
	public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket packet) {
		if (this.getLevel() != null) {
			if (this.getLevel().isAreaLoaded(this.getBlockPos(), 1)) {
				this.loadData(packet.getTag());
			}
		}
	}
	
	@Override
	public CompoundTag save(CompoundTag tag) {
		super.save(tag);
		tag.put("blood_altar", this.saveData());
		return tag;
	}
	
	public CompoundTag saveData() {
		CompoundTag tag = new CompoundTag();
		tag.putInt("blood", this.blood);
		tag.putInt("currentBlood", this.currentBlood);
		tag.putInt("previousBlood", this.previousBlood);
		return tag;
	}
	
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		this.loadData(tag.getCompound("blood_altar"));
	}
	
	public void loadData(CompoundTag tag) {
		this.blood = tag.getInt("blood");
		this.currentBlood = tag.getInt("currentBlood");
		this.previousBlood = tag.getInt("previousBlood");
	}
	
	public static class BloodAltarConstants {
		public static final int MAX = 37500;
		public static final int HEART = 1000;
		public static final int LEVEL_0 = 5000;
		public static final int LEVEL_1 = 10000;
		public static final int LEVEL_2 = 15000;
		public static final int LEVEL_3 = 20000;
		public static final int LEVEL_4 = 25000;
		public static final int LEVEL_5 = 30000;
		public static final int LEVEL_6 = 37500;
		public static final int BLOOD_BUCKET = 7500;
	}

}
