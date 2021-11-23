package net.luis.nero.event.entity.living.player;

import java.util.ArrayList;

import com.google.common.annotations.VisibleForTesting;

import net.luis.nero.Nero;
import net.luis.nero.common.util.annotation.NotTested;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnHarvestCheckEvent {
	
	@NotTested
	@SubscribeEvent
	public static void harvestCheck(PlayerEvent.HarvestCheck event) {
		Player player = event.getPlayer();
		if (player.hasEffect(ModEffects.HARVEST.get()) && !event.canHarvest()) {
			Item mainHand = player.getMainHandItem().getItem();
			int effectAmplifier = player.getEffect(ModEffects.HARVEST.get()).getAmplifier() + 1;
			if (mainHand instanceof TieredItem) {
				TieredItem tieredItem = (TieredItem) mainHand;
				int blockLevel = getBlockLevel(event.getTargetBlock());
				int toolLevel = getTierLevel(tieredItem);
				if (toolLevel + effectAmplifier >= blockLevel) {
					event.setCanHarvest(true);
				}
			}
		} else if (player.hasEffect(ModEffects.HARVEST_FATIGUE.get())) {
			Item mainHand = player.getMainHandItem().getItem();
			int effectAmplifier = player.getEffect(ModEffects.HARVEST_FATIGUE.get()).getAmplifier();
			if (mainHand instanceof TieredItem) {
				TieredItem tieredItem = (TieredItem) mainHand;
				int blockLevel = getBlockLevel(event.getTargetBlock());
				int toolLevel = getTierLevel(tieredItem);
				if (toolLevel > blockLevel + effectAmplifier) {
					event.setCanHarvest(true);
				} else {
					event.setCanHarvest(false);
				}
			}
		}
	}
	
	protected static int getTierLevel(TieredItem tieredItem) {
		Tier tier = tieredItem.getTier();
		ArrayList<Tier> tiers = new ArrayList<>();
		tiers.addAll(TierSortingRegistry.getSortedTiers());
		return tiers.indexOf(tier);
	}
	
	protected static int getBlockLevel(BlockState state) {
		ArrayList<Tier> tiers = new ArrayList<>();
		tiers.addAll(TierSortingRegistry.getSortedTiers());
		for (int i = 0; i < tiers.size(); i++) {
			Tier tier = tiers.get(i);
			if (state.is(tier.getTag())) {
				int nextIndex = Math.max(i + 1, tiers.size() - 1);
				boolean nextMineable = state.is(tiers.get(nextIndex).getTag());
				if (!nextMineable) {
					return i;
				} else if (nextIndex == tiers.size() - 1) {
					return i;
				}
			}
		}
		return 0;
	}
	
	@VisibleForTesting
	protected static ArrayList<Tier> getTiersBefore(ArrayList<Tier> tiers, Tier tier) {
		ArrayList<Tier> tiersBefore = new ArrayList<>();
		int index = tiers.indexOf(tier);
		for (int i = 0; i < index; i++) {
			tiersBefore.add(tiers.get(i));
		}
		return tiersBefore;
	}
	
	@VisibleForTesting
	protected static ArrayList<Tier> getTiersAfter(ArrayList<Tier> tiers, Tier tier) {
		ArrayList<Tier> tiersAfter = new ArrayList<>();
		int index = tiers.indexOf(tier);
		for (int i = index + 1; i < tiers.size(); i++) {
			tiersAfter.add(tiers.get(i));
		}
		return tiersAfter;
	}

}