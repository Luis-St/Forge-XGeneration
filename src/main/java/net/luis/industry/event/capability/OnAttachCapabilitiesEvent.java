package net.luis.industry.event.capability;

import net.luis.industry.Industry;
import net.luis.industry.api.capability.provider.ItemStackCapabilityProvider;
import net.luis.industry.api.capability.provider.entity.EntityCapabilityProvider;
import net.luis.industry.api.capability.provider.entity.LivingEntityCapabilityProvider;
import net.luis.industry.api.capability.provider.entity.PlayerCapabilityProvider;
import net.luis.industry.api.capability.provider.world.ChunkCapabilityProvider;
import net.luis.industry.api.capability.provider.world.TileEntityCapabilityProvider;
import net.luis.industry.api.capability.provider.world.WorldCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void attachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event) {
		event.addCapability(new ResourceLocation(Industry.MOD_ID, "chunk"), new ChunkCapabilityProvider());
	}
	
	@SubscribeEvent
	public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		event.addCapability(new ResourceLocation(Industry.MOD_ID, "entity"), new EntityCapabilityProvider());
		if (event.getObject() instanceof LivingEntity) {
			event.addCapability(new ResourceLocation(Industry.MOD_ID, "living_entity"), new LivingEntityCapabilityProvider());
		}
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(Industry.MOD_ID, "player"), new PlayerCapabilityProvider());
		}
	}
	
	@SubscribeEvent
	public static void attachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
		event.addCapability(new ResourceLocation(Industry.MOD_ID, "item_stack"), new ItemStackCapabilityProvider());
	}
	
	@SubscribeEvent
	public static void attachTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		event.addCapability(new ResourceLocation(Industry.MOD_ID, "tile_entity"), new TileEntityCapabilityProvider());
	}
	
	@SubscribeEvent
	public static void attachWorldCapabilities(AttachCapabilitiesEvent<World> event) {
		event.addCapability(new ResourceLocation(Industry.MOD_ID, "world"), new WorldCapabilityProvider());
	}

}