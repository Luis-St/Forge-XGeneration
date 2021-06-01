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

public class WaterRuneItem extends AbstractRuneItem {

	public WaterRuneItem(Properties properties) {
		super(RuneType.WATER, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 1200, 0, false, false, false));
		player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 1200, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, PlayerEntity player, LivingEntity target, ItemStack orbStack) {
		return false;
	}

}
