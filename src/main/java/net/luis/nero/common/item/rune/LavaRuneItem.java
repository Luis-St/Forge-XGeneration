package net.luis.nero.common.item.rune;

import java.util.Random;

import net.luis.nero.api.common.item.AbstractRuneItem;
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

public class LavaRuneItem extends AbstractRuneItem {
	
	public LavaRuneItem(Properties properties) {
		super(RuneType.LAVA, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		target.setSecondsOnFire(Mth.nextInt(new Random(), 5, 10));
		return true;
	}

}
