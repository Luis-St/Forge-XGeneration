package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Config
public class HarvestRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer HARVEST_RUNE_HARVEST_DURATION = 1200;
	@ConfigValue
	private static Integer HARVEST_RUNE_HARVEST_FATIGUE_DURATION = 600;
	
	public HarvestRuneItem(Properties properties) {
		super(RuneType.HARVEST, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(ModEffects.HARVEST.get(), HARVEST_RUNE_HARVEST_DURATION, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.addEffect(new EffectInstance(ModEffects.HARVEST_FATIGUE.get(), HARVEST_RUNE_HARVEST_FATIGUE_DURATION, 1, true, true, true));
		return true;
	}

}
