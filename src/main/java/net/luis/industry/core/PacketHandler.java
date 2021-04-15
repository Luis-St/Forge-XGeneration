package net.luis.industry.core;

import net.luis.industry.Industry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {

	private static final String version = "1";
	private static int id = 0;
	public static SimpleChannel simpleChannel;

	public static void init() {

		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(Industry.MOD_ID, "simple_chnanel"),
				() -> version, version::equals, version::equals);

	}

}
