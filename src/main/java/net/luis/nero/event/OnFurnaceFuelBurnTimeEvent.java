package net.luis.nero.event;

import net.luis.nero.Nero;
import net.luis.nero.init.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnFurnaceFuelBurnTimeEvent {
	
	@SubscribeEvent
	public static void furnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
		Item item = event.getItemStack().getItem();
		if (item == ModItems.HEATED_OBSIDIAN_POWDER.get()) {
			event.setBurnTime(60000);
		}
	}

}
