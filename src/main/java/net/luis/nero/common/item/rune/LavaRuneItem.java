package net.luis.nero.common.item.rune;

import java.util.Random;

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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

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
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, LAVA_RUNE_FIRE_RESISTANCE_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.setSecondsOnFire(MathHelper.nextInt(new Random(), LAVA_RUNE_TARGET_FIRE_TIME_MIN, LAVA_RUNE_TARGET_FIRE_TIME_MAX));
		return true;
	}

}
