package net.luis.nero.api.common.capability.util;

import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.init.capability.ModCapabilities;
import net.minecraft.item.ItemStack;

public class CapabilityUtil {
	
	public static IBloodOrbCapability getBloodOrbCapability(ItemStack itemStack) {
		return itemStack.getCapability(ModCapabilities.BLOOD_ORB, null).orElseThrow(NullPointerException::new);
	}
	
}
