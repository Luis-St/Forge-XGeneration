package net.luis.industry.api.capability;

import net.luis.industry.api.capability.interfaces.IBloodOrbCapability;
import net.luis.industry.init.ModCapabilities;
import net.minecraft.item.ItemStack;

public class CapabilityUtil {
	
	// TODO: getter for client side (impl. without SynchronizedCapability)
	
	public static IBloodOrbCapability getBloodOrbCapability(ItemStack itemStack) {
		return itemStack.getCapability(ModCapabilities.BLOOD_ORB, null).orElseThrow(NullPointerException::new);
	}
	
}
