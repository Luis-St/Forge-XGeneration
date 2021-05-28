package net.luis.industry.api.capability;

import net.luis.industry.api.capability.interfaces.entity.IBloodCapability;
import net.luis.industry.init.ModCapabilities;
import net.minecraft.entity.player.ServerPlayerEntity;

public class CapabilityUtil {
	
	// TODO: getter for client side (impl. without SynchronizedCapability)
	
	public static IBloodCapability getBloodCapability(ServerPlayerEntity serverPlayer) {
		return serverPlayer.getCapability(ModCapabilities.BLOOD, null).orElseThrow(NullPointerException::new);
	}
	
}
