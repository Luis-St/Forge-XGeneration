package net.luis.nero.api.common.capability.provider;

import net.luis.nero.api.common.capability.handler.BloodOrbCapabilityHandler;
import net.luis.nero.init.capability.ModCapabilities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class BloodOrbCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	
	private BloodOrbCapabilityHandler handler = new BloodOrbCapabilityHandler();
	private LazyOptional<BloodOrbCapabilityHandler> optional = LazyOptional.of(() ->  this.handler);
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == ModCapabilities.BLOOD_ORB ? (LazyOptional<T>) this.optional : LazyOptional.empty();
	}

	@Override
	public CompoundNBT serializeNBT() {
		return this.handler.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		 this.handler.deserializeNBT(nbt);
	}

}
