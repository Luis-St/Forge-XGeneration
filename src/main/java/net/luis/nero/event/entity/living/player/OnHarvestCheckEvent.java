package net.luis.nero.event.entity.living.player;

import net.luis.nero.Nero;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnHarvestCheckEvent {
	
	@SubscribeEvent
	public static void harvestCheck(PlayerEvent.HarvestCheck event) {
		Player player = event.getPlayer();
		if (player.hasEffect(ModEffects.HARVEST.get()) && !event.canHarvest()) {
			Item mainHand = player.getMainHandItem().getItem();
			int effectAmplifier = player.getEffect(ModEffects.HARVEST.get()).getAmplifier() + 1;
			if (mainHand instanceof TieredItem) {
				TieredItem tieredItem = (TieredItem) mainHand;
				int blockLevel = event.getTargetBlock().getHarvestLevel();
				int toolLevel = tieredItem.getTier().getLevel();
				if (toolLevel + effectAmplifier >= blockLevel) {
					event.setCanHarvest(true);
				}
			}
		} else if (player.hasEffect(ModEffects.HARVEST_FATIGUE.get())) {
			Item mainHand = player.getMainHandItem().getItem();
			int effectAmplifier = player.getEffect(ModEffects.HARVEST_FATIGUE.get()).getAmplifier();
			if (mainHand instanceof TieredItem) {
				TieredItem tieredItem = (TieredItem) mainHand;
				int blockLevel = event.getTargetBlock().getHarvestLevel();
				int toolLevel = tieredItem.getTier().getLevel();
				if (toolLevel > blockLevel + effectAmplifier) {
					event.setCanHarvest(true);
				} else {
					event.setCanHarvest(false);
				}
			}
		}
	}

}