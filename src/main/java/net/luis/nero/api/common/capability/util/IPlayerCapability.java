package net.luis.nero.api.common.capability.util;

import net.minecraft.entity.player.PlayerEntity;

public interface IPlayerCapability {
	
	PlayerEntity getPlayer();
	
	boolean isServerPlayer();
	
	boolean isClientPlayer();

}
