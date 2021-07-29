package net.luis.nero.api.common.nbt;

import net.minecraft.nbt.CompoundTag;

public interface CapabilitySerializableNBT {
	
	CompoundTag serializeNBT();

	void deserializeNBT(CompoundTag nbt);
	
}
