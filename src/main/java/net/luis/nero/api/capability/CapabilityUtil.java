package net.luis.nero.api.capability;

import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.init.ModCapabilities;
import net.minecraft.item.ItemStack;

public class CapabilityUtil {
	
	// TODO: getter for client side (impl. without SynchronizedCapability)
	
	public static IBloodOrbCapability getBloodOrbCapability(ItemStack itemStack) {
		return itemStack.getCapability(ModCapabilities.BLOOD_ORB, null).orElseThrow(NullPointerException::new);
	}
	
}
