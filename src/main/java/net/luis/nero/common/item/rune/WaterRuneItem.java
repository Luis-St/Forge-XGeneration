package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

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
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.WATER_BREATHING, WATER_RUNE_WATER_BREATHING_DURATION, 0, false, false, false));
		player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, WATER_RUNE_DOLPHINS_GRACE_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		return false;
	}

}
