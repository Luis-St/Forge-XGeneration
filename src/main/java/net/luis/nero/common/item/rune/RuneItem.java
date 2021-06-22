package net.luis.nero.common.item.rune;

import net.luis.nero.api.common.capability.CapabilityUtil;
import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RuneItem extends AbstractRuneItem {

	public RuneItem(Properties properties) {
		super(RuneType.RUNE, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbStack);
		this.sendMessage(player, "You have {} Blood in your Orb".replace("{}", String.valueOf(bloodOrbHandler.getBlood())));
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		return false;
	}

}
