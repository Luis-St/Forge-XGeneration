package net.luis.nero.common.item.rune;

import net.luis.nero.api.capability.CapabilityUtil;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RuneItem extends AbstractRuneItem {

	public RuneItem(Properties properties) {
		super(RuneType.RUNE, properties);
	}

	@Override
	public DamageSource getDamageSource() {
		return null;
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbStack);
			this.sendMessage(serverPlayer, "You have {} blood in your Orb".replace("{}", String.valueOf(bloodOrbHandler.getBlood())));
		}
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, PlayerEntity player, LivingEntity target, ItemStack orbStack) {
		return false;
	}

}
