package net.luis.nero.init.capability;

import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapabilities {
	
	@CapabilityInject(IBloodOrbCapability.class)
	public static Capability<IBloodOrbCapability> BLOOD_ORB = null;

}
