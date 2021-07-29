package net.luis.nero.common.item.rune;

import java.util.Random;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Config
public class LavaRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer LAVA_RUNE_FIRE_RESISTANCE_DURATION = 1200;
	@ConfigValue
	private static Integer LAVA_RUNE_TARGET_FIRE_TIME_MIN = 5;
	@ConfigValue
	private static Integer LAVA_RUNE_TARGET_FIRE_TIME_MAX = 10;
	
	public LavaRuneItem(Properties properties) {
		super(RuneType.LAVA, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level world, Player player, InteractionHand hand, ItemStack orbStack) {
		player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, LAVA_RUNE_FIRE_RESISTANCE_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		target.setSecondsOnFire(Mth.nextInt(new Random(), LAVA_RUNE_TARGET_FIRE_TIME_MIN, LAVA_RUNE_TARGET_FIRE_TIME_MAX));
		return true;
	}

}
