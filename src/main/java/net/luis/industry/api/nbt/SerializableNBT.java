package net.luis.industry.api.nbt;

import net.minecraft.nbt.CompoundNBT;

public interface SerializableNBT {
	
	CompoundNBT serialize(CompoundNBT nbt);
	
	void deserialize(CompoundNBT nbt);

}
