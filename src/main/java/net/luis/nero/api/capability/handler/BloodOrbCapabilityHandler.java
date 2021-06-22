package net.luis.nero.api.capability.handler;

import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.common.item.RuneUseType;
import net.luis.nero.common.item.OrbItem;
import net.luis.nero.common.item.rune.AbstractRuneItem;
import net.minecraft.nbt.CompoundNBT;

public class BloodOrbCapabilityHandler implements IBloodOrbCapability {
	
	private int blood = 0;
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("blood", this.blood);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.blood = nbt.getInt("blood");
	}

	@Override
	public int getBlood() {
		return this.blood;
	}
	
	@Override
	public void setBlood(int blood) {
		this.blood = blood;
	}

	@Override
	public int getBloodCapability(OrbItem orbItem) {
		return orbItem.getOrbType().getBloodCapability();
	}
	
	@Override
	public int getBloodForMax(OrbItem orbItem) {
		return this.getBloodCapability(orbItem) - this.getBlood();
	}
	
	@Override
	public void addBlood(OrbItem orbItem, int blood) {
		int addedBlood = Math.min(this.getBloodCapability(orbItem) - this.blood, blood);
		this.blood += addedBlood;
	}

	@Override
	public boolean canBloodAdd(OrbItem orbItem, int blood) {
		int maxBlood = this.getBloodCapability(orbItem);
		return maxBlood >= this.getBlood() + blood;
	}

	@Override
	public int reduceBlood(int blood, boolean onlyIfAll) {
		int reducedBlood = Math.min(this.getBlood(), blood);
		if (onlyIfAll && reducedBlood >= blood) {
			this.blood -= blood;
			return blood;
		} else if (onlyIfAll && blood > reducedBlood) {
			return 0;
		} else {
			this.blood -= reducedBlood;
			return reducedBlood;
		}
	}
	
	@Override
	public boolean hasBlood() {
		return this.blood > 0;
	}
	
	@Override
	public boolean hasBlood(int blood) {
		return this.blood >= blood;
	}
	
	@Override
	public boolean hasMaxBlood(OrbItem orbItem) {
		return this.getBlood() >= this.getBloodCapability(orbItem);
	}
	
	@Override
	public boolean shouldDamage(AbstractRuneItem runeItem, RuneUseType useType) {
		switch (useType) {
		case HIT: {
			return this.hasBlood(runeItem.getRuneType().getHitCost());
		}
		case USE: {
			return this.hasBlood(runeItem.getRuneType().getUseCost());
		}
		default: {
			throw new IllegalArgumentException("RuneUseType can't be null!");
		}
		}
	}

}
