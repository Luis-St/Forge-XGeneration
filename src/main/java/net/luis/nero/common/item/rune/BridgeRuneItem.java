package net.luis.nero.common.item.rune;

import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.potion.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BridgeRuneItem extends AbstractRuneItem {
	
	public BridgeRuneItem(Properties properties) {
		super(RuneType.BRIDGE, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		player.addEffect(new EffectInstance(ModEffects.BRIDGE.get(), 1200, 0, false, false, false));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		return false;
	}

}
