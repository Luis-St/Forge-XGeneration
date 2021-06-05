package net.luis.nero.core;

import net.luis.nero.Nero;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {

	private static final String version = "1";
	@SuppressWarnings("unused")
	private static int id = 0;
	public static SimpleChannel simpleChannel;

	public static void init() {
		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(Nero.MOD_ID, "simple_chnanel"),
				() -> version, version::equals, version::equals);
	}

}
