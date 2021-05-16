package net.luis.industry.api.capability.handler.entity;

import net.luis.industry.api.capability.interfaces.entity.ILivingEntityCapability;
import net.minecraft.nbt.CompoundNBT;

public class LivingEntityCapabilityHandler implements ILivingEntityCapability {
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
	}

}
