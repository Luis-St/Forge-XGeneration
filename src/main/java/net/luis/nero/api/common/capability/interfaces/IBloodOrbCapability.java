package net.luis.nero.api.common.capability.interfaces;

import net.luis.nero.api.common.item.AbstractRuneItem;
import net.luis.nero.api.common.nbt.CapabilitySerializableNBT;
import net.luis.nero.common.enums.RuneUseType;
import net.luis.nero.common.item.OrbItem;

public interface IBloodOrbCapability extends CapabilitySerializableNBT {
	
	int getBlood();
	
	void setBlood(int blood);
	
	int getBloodCapability(OrbItem orbItem);
	
	int getBloodForMax(OrbItem orbItem);
	
	void addBlood(OrbItem orbItem, int blood);
	
	boolean canBloodAdd(OrbItem orbItem, int blood);
	
	int reduceBlood(int blood, boolean onlyIfAll);
	
	boolean hasBlood();
	
	boolean hasBlood(int blood);
	
	boolean hasMaxBlood(OrbItem orbItem);
	
	boolean shouldDamage(AbstractRuneItem runeItem, RuneUseType useType);
	
}
