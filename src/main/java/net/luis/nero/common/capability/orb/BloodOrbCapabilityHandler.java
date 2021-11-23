package net.luis.nero.common.capability.orb;

import net.luis.nero.common.enums.RuneUseType;
import net.luis.nero.common.item.AbstractRuneItem;
import net.luis.nero.common.item.OrbItem;
import net.minecraft.nbt.CompoundTag;

public class BloodOrbCapabilityHandler implements IBloodOrbCapability {
	
	private int blood = 0;

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
		return orbItem.getOrbType().getBloodCapacity();
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
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag tag = new CompoundTag();
		tag.putInt("blood", this.blood);
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundTag tag) {
		this.blood = tag.getInt("blood");
	}

}
