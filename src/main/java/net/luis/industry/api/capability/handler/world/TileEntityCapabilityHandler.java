package net.luis.industry.api.capability.handler.world;

import net.luis.industry.api.capability.interfaces.world.ITileEntityCapability;
import net.minecraft.nbt.CompoundNBT;

public class TileEntityCapabilityHandler implements ITileEntityCapability {
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		
	}

}