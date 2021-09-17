package net.luis.nero.event.capability;

import net.luis.nero.Nero;
import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Nero.MOD_ID)
public class OnRegisterCapabilitiesEvent {
	
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.register(IBloodOrbCapability.class);
	}

}
