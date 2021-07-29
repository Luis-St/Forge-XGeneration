package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Config
public class WaterRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer WATER_RUNE_WATER_BREATHING_DURATION = 1200;
	@ConfigValue
	private static Integer WATER_RUNE_DOLPHINS_GRACE_DURATION = 1200;
	
	public WaterRuneItem(Properties properties) {
		super(RuneType.WATER, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, WATER_RUNE_WATER_BREATHING_DURATION, 0, false, false, false));
		player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, WATER_RUNE_DOLPHINS_GRACE_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		return false;
	}

}
