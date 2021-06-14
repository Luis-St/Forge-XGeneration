package net.luis.nero.common.item.rune;

import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MiningRuneItem extends AbstractRuneItem {

	public MiningRuneItem(Properties properties) {
		super(RuneType.MINING, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.DIG_SPEED, 2400, 1, false, false, false));
		player.addEffect(new EffectInstance(ModEffects.HARVEST.get(), 2400, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 1200, 1, true, true, true));
		target.addEffect(new EffectInstance(ModEffects.HARVEST_FATIGUE.get(), 1200, 1, true, true, true));
		return true;
	}

}
