package net.luis.industry.api.capability.handler.world;

import net.luis.industry.api.capability.interfaces.world.IChunkCapability;
import net.minecraft.nbt.CompoundNBT;

public class ChunkCapabilityHandler implements IChunkCapability {
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
	}

}
