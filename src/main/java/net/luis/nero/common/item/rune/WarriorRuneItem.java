package net.luis.nero.common.item.rune;

import net.luis.nero.api.common.item.AbstractRuneItem;
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
public class WarriorRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer WARRIOR_RUNE_STRENGTH_DURATION = 1200;
	
	public WarriorRuneItem(Properties properties) {
		super(RuneType.WARRIOR, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, WARRIOR_RUNE_STRENGTH_DURATION, 1, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		return false;
	}

}
