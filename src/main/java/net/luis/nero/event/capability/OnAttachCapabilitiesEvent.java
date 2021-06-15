package net.luis.nero.event.capability;

import net.luis.nero.Nero;
import net.luis.nero.api.capability.provider.PortalCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void attachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event) {
		
	}
	
	@SubscribeEvent
	public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		
	}
	
	@SubscribeEvent
	public static void attachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
		
	}
	
	@SubscribeEvent
	public static void attachTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		
	}
	
	@SubscribeEvent
	public static void attachWorldCapabilities(AttachCapabilitiesEvent<World> event) {
		if (event.getObject() instanceof ServerWorld) {
			event.addCapability(new ResourceLocation(Nero.MOD_ID, "portal"), new PortalCapabilityProvider());
		}
	}

}