package net.luis.nero.core;

import java.util.Optional;

import net.luis.nero.Nero;
import net.luis.nero.core.messages.SyncPlayerCapability;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

	private static final String version = "1";
	private static int id = 0;
	public static SimpleChannel simpleChannel;

	public static void init() {
		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(Nero.MOD_ID, "simple_chnanel"),
				() -> version, version::equals, version::equals);
		simpleChannel.registerMessage(id++, SyncPlayerCapability.class, SyncPlayerCapability::encode, SyncPlayerCapability::decode, 
				SyncPlayerCapability::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
	}

}
