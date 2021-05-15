package net.luis.industry.api.capability.provider.entity;

import net.luis.industry.api.capability.handler.entity.LivingEntityCapabilityHandler;
import net.luis.industry.init.ModCapabilities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LivingEntityCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	
	private LivingEntityCapabilityHandler handler = new LivingEntityCapabilityHandler();
	private LazyOptional<LivingEntityCapabilityHandler> optional = LazyOptional.of(() ->  this.handler);

	@Override
	@SuppressWarnings("unchecked")
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == ModCapabilities.LIVING_ENTITY ? (LazyOptional<T>) this.optional : LazyOptional.empty();
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
