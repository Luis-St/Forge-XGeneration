package net.luis.industry.core.messages;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class SyncPlayerCapability {
	
	public static void encode(SyncPlayerCapability message, PacketBuffer buffer) {
		
	}

	public static SyncPlayerCapability decode(PacketBuffer buffer) {
		return new SyncPlayerCapability();
	}

	public static void handle(SyncPlayerCapability message, Supplier<Context> networkContext) {
		networkContext.get().enqueueWork(() -> {
			
		});
		networkContext.get().setPacketHandled(true);
	}

}
