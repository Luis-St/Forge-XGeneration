package net.luis.industry.api.nbt;

import net.minecraft.nbt.CompoundNBT;

public interface CapabilitySerializableNBT {
	
	CompoundNBT serializeNBT();

	void deserializeNBT(CompoundNBT nbt);
	
}
