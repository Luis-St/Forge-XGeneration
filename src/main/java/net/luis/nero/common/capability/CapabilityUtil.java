package net.luis.nero.common.capability;

import net.luis.nero.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.init.capability.ModCapabilities;
import net.minecraft.world.item.ItemStack;

public class CapabilityUtil {
	
	public static IBloodOrbCapability getBloodOrbCapability(ItemStack itemStack) {
		return itemStack.getCapability(ModCapabilities.BLOOD_ORB, null).orElseThrow(NullPointerException::new);
	}
	
}
