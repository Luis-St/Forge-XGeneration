package net.luis.industry.init;

import net.luis.industry.api.capability.interfaces.IBloodOrbCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapabilities {
	
	@CapabilityInject(IBloodOrbCapability.class)
	public static Capability<IBloodOrbCapability> BLOOD_ORB = null;

}
