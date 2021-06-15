package net.luis.nero.api.capability.interfaces;

import java.util.List;

import net.luis.nero.api.nbt.CapabilitySerializableNBT;
import net.luis.nero.init.world.ModDimensions;
import net.minecraft.block.PortalInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Dimension;

public interface IPortalCapability extends CapabilitySerializableNBT {
	
	public static final ResourceLocation OVERWORLD = Dimension.OVERWORLD.location();
	public static final ResourceLocation NETHER = Dimension.NETHER.location();
	public static final ResourceLocation END = Dimension.END.location();
	public static final ResourceLocation DEEPSLATE = ModDimensions.DEEPSLATE.location();
	
	List<PortalInfo> getOverworld();
	
	List<PortalInfo> getNether();
	
	List<PortalInfo> getEnd();
	
	List<PortalInfo> getDeepslate();
	
	List<PortalInfo> get(ResourceLocation dimension);
	
	PortalInfo getNext(ResourceLocation dimension, BlockPos pos);
	
	void add(ResourceLocation dimension, PortalInfo portalInfo);
	
}
