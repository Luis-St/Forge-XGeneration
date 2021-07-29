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
public class IceRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer ICE_RUNE_ICE_DURATION = 200;
	
	public IceRuneItem(Properties properties) {
		super(RuneType.ICE, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level world, Player player, InteractionHand hand, ItemStack orbStack) {
		return this.pass(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		target.addEffect(new MobEffectInstance(ModEffects.ICE.get(), ICE_RUNE_ICE_DURATION, target instanceof Player ? 1 : 0, true, true, true));
		return true;
	}

}
