package net.luis.industry.api.capability.interfaces.entity;

import java.util.List;

import net.luis.industry.api.capability.SynchronizedCapability;
import net.luis.industry.api.item.RuneUseType;
import net.luis.industry.api.nbt.CapabilitySerializableNBT;
import net.luis.industry.common.item.OrbItem;
import net.luis.industry.common.item.RuneItem;
import net.minecraft.entity.player.ServerPlayerEntity;

public interface IBloodCapability extends CapabilitySerializableNBT, SynchronizedCapability {
	
	List<OrbItem> getOrbs(ServerPlayerEntity player);
	
	boolean hasOrbs(ServerPlayerEntity player);
	
	int getBlood();
	
	int getMaxBlood(ServerPlayerEntity player);
	
	int getBloodForMax(ServerPlayerEntity player);
	
	void addBlood(ServerPlayerEntity player, int blood);
	
	boolean canBloodAdd(ServerPlayerEntity player, int blood);
	
	int reduceBlood(int blood, boolean onlyIfAll);
	
	boolean hasBlood();
	
	boolean hasBlood(int blood);
	
	boolean hasMaxBlood(List<OrbItem> orbItems);
	
	boolean shouldDamage(RuneItem runeItem, RuneUseType useType);
	
}
