package net.luis.nero.common.item.rune;

import net.luis.nero.api.common.item.AbstractRuneItem;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AirRuneItem extends AbstractRuneItem {
	
	public AirRuneItem(Properties properties) {
		super(RuneType.AIR, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		double xMotion = player.getViewVector(1.0F).x();
		double yMotion = 1.3;
		double zMotion = player.getViewVector(1.0F).z();
		Vec3 vector = new Vec3(xMotion, yMotion, zMotion);
		player.setDeltaMovement(vector);
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		return false;
	}

}
