package net.luis.nero.common.item.rune;

import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HasteRuneItem extends AbstractRuneItem {

	public HasteRuneItem(Properties properties) {
		super(RuneType.HASTE, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.DIG_SPEED, 1200, 1, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 600, 1, true, true, true));
		return true;
	}

}
