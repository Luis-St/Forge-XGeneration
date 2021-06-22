package net.luis.nero.api.common.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityStorage<T> implements IStorage<T> {

	@Override
	public INBT writeNBT(Capability<T> capability, T instance, Direction side) {
		throw new UnsupportedOperationException("Forge doesn't use the CapabilityStorage, therefore it's deprecated, so don't call this methode!");
	}

	@Override
	public void readNBT(Capability<T> capability, T instance, Direction side, INBT nbt) {
		throw new UnsupportedOperationException("Forge doesn't use the CapabilityStorage, therefore it's deprecated, so don't call this methode!");
	}

}
