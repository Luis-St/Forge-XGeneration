package net.luis.nero.event.registery;

import net.luis.nero.Nero;
import net.luis.nero.common.command.NoiseCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnRegisterCommandsEvent {
	
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		NoiseCommand.register(event.getDispatcher());
	}
}
