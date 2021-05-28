package net.luis.industry.init;

import net.luis.industry.api.capability.interfaces.entity.IBloodCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapabilities {
	
	@CapabilityInject(IBloodCapability.class)
	public static Capability<IBloodCapability> BLOOD = null;

}
