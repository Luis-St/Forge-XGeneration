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
public class IceRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer ICE_RUNE_ICE_DURATION = 200;
	
	public IceRuneItem(Properties properties) {
		super(RuneType.ICE, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		return this.pass(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		target.addEffect(new EffectInstance(ModEffects.ICE.get(), ICE_RUNE_ICE_DURATION, target instanceof PlayerEntity ? 1 : 0, true, true, true));
		return true;
	}

}
