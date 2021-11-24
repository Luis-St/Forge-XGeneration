package net.luis.nero.common.capability.provider;

import net.luis.nero.common.capability.handler.BloodOrbCapabilityHandler;
import net.luis.nero.init.capability.ModCapabilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class BloodOrbCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
	
	private final BloodOrbCapabilityHandler handler = new BloodOrbCapabilityHandler();
	private final LazyOptional<BloodOrbCapabilityHandler> optional = LazyOptional.of(() ->  this.handler);
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction direction) {
		return cap == ModCapabilities.BLOOD_ORB ? (LazyOptional<T>) this.optional : LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		return this.handler.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag tag) {
		 this.handler.deserializeNBT(tag);
	}

}
