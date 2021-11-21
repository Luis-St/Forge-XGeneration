package net.luis.nero.core;

import net.luis.nero.Nero;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class NetworkHandler {
	
	private static final String version = "1";
	@SuppressWarnings("unused")
	private static int id = 0;
	public static SimpleChannel simpleChannel;

	public static void init() {
		NetworkRegistry.newSimpleChannel(new ResourceLocation(Nero.MOD_ID, "simple_chnanel"), () -> version, version::equals, version::equals);
	}

}
