package net.luis.industry.api.capability.interfaces;

import net.luis.industry.api.item.RuneUseType;
import net.luis.industry.api.nbt.CapabilitySerializableNBT;
import net.luis.industry.common.item.OrbItem;
import net.luis.industry.common.item.RuneItem;

public interface IBloodOrbCapability extends CapabilitySerializableNBT {
	
	int getBlood();
	
	int getBloodCapability(OrbItem orbItem);
	
	int getBloodForMax(OrbItem orbItem);
	
	void addBlood(OrbItem orbItem, int blood);
	
	boolean canBloodAdd(OrbItem orbItem, int blood);
	
	int reduceBlood(int blood, boolean onlyIfAll);
	
	boolean hasBlood();
	
	boolean hasBlood(int blood);
	
	boolean hasMaxBlood(OrbItem orbItem);
	
	boolean shouldDamage(RuneItem runeItem, RuneUseType useType);
	
}
