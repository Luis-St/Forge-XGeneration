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
public class SeerRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer SEER_RUNE_NIGHT_VISION_DURATION = 1200;
	@ConfigValue
	private static Integer SEER_RUNE_BLINDNESS_DURATION = 600;
	
	public SeerRuneItem(Properties properties) {
		super(RuneType.SEER, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.NIGHT_VISION, SEER_RUNE_NIGHT_VISION_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.addEffect(new EffectInstance(Effects.BLINDNESS, SEER_RUNE_BLINDNESS_DURATION, 0, true, true, true));
		return true;
	}

}
