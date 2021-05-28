package net.luis.industry.api.capability.provider.entity;

import net.luis.industry.api.capability.handler.entity.PlayerCapabilityHandler;
import net.luis.industry.init.ModCapabilities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	
	private PlayerCapabilityHandler handler = new PlayerCapabilityHandler();
	private LazyOptional<PlayerCapabilityHandler> optional = LazyOptional.of(() ->  this.handler);

	@Override
	@SuppressWarnings("unchecked")
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == ModCapabilities.PLAYER ? (LazyOptional<T>) this.optional : LazyOptional.empty();
	}

	@Override
	public CompoundNBT serializeNBT() {
		return  this.handler.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		 this.handler.deserializeNBT(nbt);
	}

}
