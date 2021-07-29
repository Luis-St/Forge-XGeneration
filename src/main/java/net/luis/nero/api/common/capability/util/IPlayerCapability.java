package net.luis.nero.api.common.capability.util;

import net.minecraft.world.entity.player.Player;

public interface IPlayerCapability {
	
	Player getPlayer();
	
	boolean isServerPlayer();
	
	boolean isClientPlayer();

}
