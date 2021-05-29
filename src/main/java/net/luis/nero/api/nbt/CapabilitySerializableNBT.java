package net.luis.nero.api.nbt;

import net.minecraft.nbt.CompoundNBT;

public interface CapabilitySerializableNBT {
	
	CompoundNBT serializeNBT();

	void deserializeNBT(CompoundNBT nbt);
	
}
