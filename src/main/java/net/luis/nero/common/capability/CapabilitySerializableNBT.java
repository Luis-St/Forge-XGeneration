package net.luis.nero.common.capability;

import net.minecraft.nbt.CompoundTag;

public interface CapabilitySerializableNBT {
	
	CompoundTag serializeNBT();

	void deserializeNBT(CompoundTag tag);
	
}
