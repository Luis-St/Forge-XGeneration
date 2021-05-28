package net.luis.industry.api.capability.interfaces.entity;

import java.util.List;

import net.luis.industry.api.capability.SynchronizedCapability;
import net.luis.industry.api.item.OrbItem;
import net.luis.industry.api.item.RuneItem;
import net.luis.industry.api.nbt.CapabilitySerializableNBT;
import net.minecraft.entity.player.PlayerEntity;

public interface IPlayerCapability extends CapabilitySerializableNBT, SynchronizedCapability {
	
	List<OrbItem> getOrbs(PlayerEntity player);
	
	boolean hasOrbs(PlayerEntity player);
	
	int getBlood();
	
	int getMaxBlood(PlayerEntity player);
	
	int getBloodForMax(PlayerEntity player);
	
	void addBlood(PlayerEntity player, int blood);
	
	boolean canBloodAdd(PlayerEntity player, int blood);
	
	int reduceBlood(int blood);
	
	boolean hasBlood();
	
	boolean hasBlood(int blood);
	
	boolean hasMaxBlood(List<OrbItem> orbItems);
	
	boolean shouldDamage(RuneItem runeItem);
	
}
