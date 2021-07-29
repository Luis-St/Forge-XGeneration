package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Config
public class HarvestRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer HARVEST_RUNE_HARVEST_DURATION = 1200;
	@ConfigValue
	private static Integer HARVEST_RUNE_HARVEST_FATIGUE_DURATION = 600;
	
	public HarvestRuneItem(Properties properties) {
		super(RuneType.HARVEST, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		player.addEffect(new MobEffectInstance(ModEffects.HARVEST.get(), HARVEST_RUNE_HARVEST_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		target.addEffect(new MobEffectInstance(ModEffects.HARVEST_FATIGUE.get(), HARVEST_RUNE_HARVEST_FATIGUE_DURATION, 1, true, true, true));
		return true;
	}

}
