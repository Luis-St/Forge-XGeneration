package net.luis.industry.init;

import net.luis.industry.api.capability.interfaces.IItemStackCapability;
import net.luis.industry.api.capability.interfaces.entity.IEntityCapability;
import net.luis.industry.api.capability.interfaces.entity.ILivingEntityCapability;
import net.luis.industry.api.capability.interfaces.entity.IPlayerCapability;
import net.luis.industry.api.capability.interfaces.world.IChunkCapability;
import net.luis.industry.api.capability.interfaces.world.ITileEntityCapability;
import net.luis.industry.api.capability.interfaces.world.IWorldCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapabilities {
	
	@CapabilityInject(IChunkCapability.class)
	public static Capability<IChunkCapability> CHUNK = null;
	@CapabilityInject(IWorldCapability.class)
	public static Capability<IWorldCapability> WORLD = null;
	@CapabilityInject(ITileEntityCapability.class)
	public static Capability<ITileEntityCapability> TILE_ENTITY = null;
	@CapabilityInject(IEntityCapability.class)
	public static Capability<IEntityCapability> ENTITY = null;
	@CapabilityInject(ILivingEntityCapability.class)
	public static Capability<ILivingEntityCapability> LIVING_ENTITY = null;
	@CapabilityInject(IPlayerCapability.class)
	public static Capability<IPlayerCapability> PLAYER = null;
	@CapabilityInject(IItemStackCapability.class)
	public static Capability<IItemStackCapability> ITEM_STACK = null;

}
