package net.luis.nero.api.capability.handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.luis.nero.api.capability.interfaces.IPortalCapability;
import net.luis.nero.api.util.Entry;
import net.luis.nero.init.world.ModDimensions;
import net.minecraft.block.PortalInfo;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Dimension;

public class PortalCapabilityHandler implements IPortalCapability {
	
	private final Map<ResourceLocation, List<PortalInfo>> dimensionPortals = new HashMap<ResourceLocation, List<PortalInfo>>();
	
	@Override
	public List<PortalInfo> getOverworld() {
		return this.dimensionPortals.get(OVERWORLD);
	}

	@Override
	public List<PortalInfo> getNether() {
		return this.dimensionPortals.get(NETHER);
	}

	@Override
	public List<PortalInfo> getEnd() {
		return this.dimensionPortals.get(END);
	}

	@Override
	public List<PortalInfo> getDeepslate() {
		return this.dimensionPortals.get(DEEPSLATE);
	}
	
	private void registerMap(ResourceLocation dimension) {
		if (this.getOverworld() == null) {
			this.dimensionPortals.put(dimension, new ArrayList<PortalInfo>());
		}
		if (this.getNether() == null) {
			this.dimensionPortals.put(dimension, new ArrayList<PortalInfo>());
		}
		if (this.getEnd() == null) {
			this.dimensionPortals.put(dimension, new ArrayList<PortalInfo>());
		}
		if (this.getDeepslate() == null) {
			this.dimensionPortals.put(dimension, new ArrayList<PortalInfo>());
		}
	}

	@Override
	@Nullable
	public List<PortalInfo> get(ResourceLocation dimension) {
		this.registerMap(dimension);
		if (dimension.equals(Dimension.OVERWORLD.location())) {
			return this.getOverworld();
		} else if (dimension.equals(Dimension.NETHER.location())) {
			return this.getNether();
		} else if (dimension.equals(Dimension.END.location())) {
			return this.getEnd();
		} else if (dimension.equals(ModDimensions.DEEPSLATE.location())) {
			return this.getDeepslate();
		}
		return null;
	}

	@Override
	public PortalInfo getNext(ResourceLocation dimension, BlockPos pos) {
		this.registerMap(dimension);
		List<PortalInfo> portalInfos = this.get(dimension);
		List<Entry<Double, PortalInfo>> distancePortalInfo = new ArrayList<Entry<Double, PortalInfo>>();
		for (PortalInfo portalInfo : portalInfos) {
			BlockPos portalPos = new BlockPos(portalInfo.pos);
			distancePortalInfo.add(new Entry<Double, PortalInfo>(pos.distSqr(portalPos), portalInfo));
		}
		distancePortalInfo.stream().sorted(Comparator.comparing(Entry::getKey));
		return distancePortalInfo.get(0).getValue();
	}

	@Override
	public void add(ResourceLocation dimension, PortalInfo portalInfo) {
		List<PortalInfo> portalInfos = this.dimensionPortals.get(dimension);
		if (portalInfos != null) {
			portalInfos.add(portalInfo);
		} else {
			portalInfos = new ArrayList<>();
			portalInfos.add(portalInfo);
		}
		this.dimensionPortals.put(dimension, portalInfos);
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		ResourceLocation[] dimensions = new ResourceLocation[] {OVERWORLD, NETHER, END, DEEPSLATE};
		for (int i = 0; i < dimensions.length; i++) {
			CompoundNBT dimensionNBT = new CompoundNBT();
			ResourceLocation dimension = dimensions[i];
			ListNBT listNBT = new ListNBT();
			for (PortalInfo portalInfo : this.get(dimension)) {
				listNBT.add(this.serializePortalInfo(portalInfo));
			}
			dimensionNBT.putInt("PortalInfoSize", this.get(dimension).size());
			dimensionNBT.put("PortalInfos", listNBT);
			nbt.put(dimension.toString(), dimensionNBT);
		}
//		Nero.LOGGER.debug("serializeNBT: {}", nbt);
		return nbt;
	}
	
	protected CompoundNBT serializePortalInfo(PortalInfo portalInfo) {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putDouble("posX", portalInfo.pos.x);
		nbt.putDouble("posY", portalInfo.pos.y);
		nbt.putDouble("posZ", portalInfo.pos.z);
		nbt.putDouble("speedX", portalInfo.speed.x);
		nbt.putDouble("speedY", portalInfo.speed.y);
		nbt.putDouble("speedZ", portalInfo.speed.z);
		nbt.putFloat("yRot", portalInfo.yRot);
		nbt.putFloat("xRot", portalInfo.xRot);
//		Nero.LOGGER.debug("serializePortalInfo: {}", nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		ResourceLocation[] dimensions = new ResourceLocation[] {OVERWORLD, NETHER, END, DEEPSLATE};
		for (int i = 0; i < dimensions.length; i++) {
			ResourceLocation dimension = dimensions[i];
			CompoundNBT dimensionNBT = nbt.getCompound(dimension.toString());
			int listSize = dimensionNBT.getInt("PortalInfoSize");
			ListNBT listNBT = dimensionNBT.getList("PortalInfos", 9);
			for (int j = 0; j < listSize; j++) {
				this.add(dimension, this.deserializePortalInfo(listNBT.getCompound(j)));
			}
		}
//		Nero.LOGGER.debug("deserializeNBT: {}", nbt);
	}
	
	protected PortalInfo deserializePortalInfo(CompoundNBT nbt) {
		Vector3d pos = new Vector3d(nbt.getDouble("posX"), nbt.getDouble("posY"), nbt.getDouble("posZ"));
		Vector3d speed = new Vector3d(nbt.getDouble("speedX"), nbt.getDouble("speedY"), nbt.getDouble("speedZ"));
//		Nero.LOGGER.debug("deserializePortalInfo: {}", nbt);
		return new PortalInfo(pos, speed, nbt.getFloat("yRot"), nbt.getFloat("xRot"));
	}

}
