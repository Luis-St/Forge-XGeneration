package net.luis.industry.core.messages;

import java.util.function.Supplier;

import net.luis.industry.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class SyncPlayerCapability {
	
	public static void encode(SyncPlayerCapability message, PacketBuffer buffer) {
		
	}

	public static SyncPlayerCapability decode(PacketBuffer buffer) {
		return new SyncPlayerCapability();
	}

	@SuppressWarnings("resource")
	public static void handle(SyncPlayerCapability message, Supplier<Context> networkContext) {
		networkContext.get().enqueueWork(() -> {
			networkContext.get().getSender().getCapability(ModCapabilities.BLOOD, null).ifPresent(serverCapability -> {
				Minecraft.getInstance().player.getCapability(ModCapabilities.BLOOD, null).ifPresent(clientCapability -> {
					clientCapability.deserializeNBT(serverCapability.serializeNBT());
				});
			});
		});
		networkContext.get().setPacketHandled(true);
	}

}
