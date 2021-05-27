package net.luis.industry.common.tileentity;

import net.luis.industry.api.tileentity.IAnimatedTileEntity;
import net.luis.industry.api.tileentity.IEnergy;
import net.luis.industry.init.block.util.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BloodAltarTileEntity extends TileEntity implements ITickableTileEntity, IAnimatedTileEntity, IEnergy<BloodAltarTileEntity> {
	
	protected int blood = 0;
	protected int previousBlood = 0;
	
	public BloodAltarTileEntity() {
		super(ModTileEntityTypes.BLOOD_ALTAR.get());
	}

	@Override
	public float getCurrent() {
		return (float) this.blood / (float) this.getEnergyMultiplier();
	}

	@Override
	public float getPrevious() {
		return (float) this.previousBlood / (float) this.getEnergyMultiplier();
	}

	@Override
	public void tick() {
		this.blood += 100;
		this.previousBlood = this.blood;
	}
	
	public ItemStack receivebloodBucket() {
		return null;
	}
	
	public ItemStack extractBloodBucket() {
		if (this.blood >= BloodConstants.BLOOD_BUCKET) {
			return null; // TODO: Blood Bucket
		}
		return ItemStack.EMPTY;
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
		}
		return extracted;
	}

	@Override
	public int getEnergyStored() {
		return this.blood;
	}
	
	public float getEnergyBase() {
		return 3.75F;
	}

	public int getEnergyMultiplier() {
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

	@Override
	public boolean canReceive() {
		return this.getMaxEnergyStored() > this.blood;
	}
	
	@Override
	public CompoundNBT save(CompoundNBT compoundNBT) {
		CompoundNBT nbt = super.save(compoundNBT);
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
	}
	
	public class BloodConstants {
		public static final int MAX = 37500;
		public static final int HEART = 1000;
		public static final int LEVEL_0 = 5000;
		public static final int LEVEL_1 = 10000;
		public static final int LEVEL_2 = 15000;
		public static final int LEVEL_3 = 20000;
		public static final int LEVEL_4 = 25000;
		public static final int LEVEL_5 = 30000;
		public static final int BLOOD_BUCKET = 7500;
	}

}
