package net.luis.industry.api.capability.handler.entity;

import net.luis.industry.api.capability.interfaces.entity.IPlayerCapability;
import net.minecraft.nbt.CompoundNBT;

public class PlayerCapabilityHandler implements IPlayerCapability {
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
	}

}