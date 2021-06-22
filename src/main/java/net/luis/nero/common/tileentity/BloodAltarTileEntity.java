package net.luis.nero.common.tileentity;

import net.luis.nero.api.tileentity.IAnimatedTileEntity;
import net.luis.nero.api.tileentity.IEnergy;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BloodAltarTileEntity extends TileEntity implements ITickableTileEntity, IAnimatedTileEntity, IEnergy<BloodAltarTileEntity> {
	
	protected int blood = 0;
	protected int currentBlood = 0;
	protected int previousBlood = 0;
	
	public BloodAltarTileEntity() {
		super(ModTileEntityTypes.BLOOD_ALTAR.get());
	}

	@Override
	public float getCurrent() {
		return (float) this.currentBlood / (float) this.getEnergyMultiplier();
	}

	@Override
	public float getPrevious() {
		return (float) this.previousBlood / (float) this.getEnergyMultiplier();
	}

	@Override
	public void tick() {
		this.currentBlood = blood;
		this.previousBlood = this.currentBlood;
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
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.worldPosition, -1, this.saveData());
	}
	
	@Override
	public void onDataPacket(NetworkManager networkManager, SUpdateTileEntityPacket packet) {
		if (this.getLevel() != null) {
			if (this.getLevel().isAreaLoaded(this.getBlockPos(), 1)) {
				this.loadData(packet.getTag());
			}
		}
	}
	
	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		nbt.put("blood_altar", this.saveData());
		return nbt;
	}
	
	public CompoundNBT saveData() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("blood", this.blood);
		nbt.putInt("currentBlood", this.currentBlood);
		nbt.putInt("previousBlood", this.previousBlood);
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.loadData(nbt.getCompound("blood_altar"));
	}
	
	public void loadData(CompoundNBT nbt) {
		this.blood = nbt.getInt("blood");
		this.currentBlood = nbt.getInt("currentBlood");
		this.previousBlood = nbt.getInt("previousBlood");
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
	
	public static class BloodAltarRecipes {
//		public static final List<BloodAltarRecipe> RECIPES = new ArrayList<BloodAltarRecipe>();
//		
//		
//		private static BloodAltarRecipe register(RegistryObject<? extends Item> input, RegistryObject<? extends Item> output, int time, int blood) {
//			return register(input.get(), output.get(), time, blood);
//		}
//		
//		private static BloodAltarRecipe register(Item input, Item output, int time, int blood) {
//			BloodAltarRecipe recipe = new BloodAltarRecipe(input, output, time, blood);
//			RECIPES.add(recipe);
//			return recipe;
//		}
	}

}
