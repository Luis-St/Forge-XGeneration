package net.luis.nero.api.common.nbt;

import net.minecraft.nbt.CompoundNBT;

public interface CapabilitySerializableNBT {
	
	CompoundNBT serializeNBT();

	void deserializeNBT(CompoundNBT nbt);
	
}
