package net.luis.industry.api.capability.handler.world;

import net.luis.industry.api.capability.interfaces.world.IWorldCapability;
import net.minecraft.nbt.CompoundNBT;

public class WorldCapabilityHandler implements IWorldCapability {
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
	}

}
