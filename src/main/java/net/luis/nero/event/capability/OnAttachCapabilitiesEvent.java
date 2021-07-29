package net.luis.nero.event.capability;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void attachChunkCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {
		
	}
	
	@SubscribeEvent
	public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			
		}
	}
	
	@SubscribeEvent
	public static void attachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
		
	}
	
	@SubscribeEvent
	public static void attachTileEntityCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
		
	}
	
	@SubscribeEvent
	public static void attachWorldCapabilities(AttachCapabilitiesEvent<Level> event) {
		if (event.getObject() instanceof ServerLevel) {
			
		}
	}

}