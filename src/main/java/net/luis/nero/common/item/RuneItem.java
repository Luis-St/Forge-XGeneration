package net.luis.nero.common.item;

import net.luis.nero.common.capability.CapabilityUtil;
import net.luis.nero.common.capability.orb.IBloodOrbCapability;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RuneItem extends AbstractRuneItem {

	public RuneItem(Properties properties) {
		super(RuneType.RUNE, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbStack);
		this.sendMessage(player, "You have " + bloodOrbHandler.getBlood() + " Blood in your Orb");
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		return false;
	}

}
