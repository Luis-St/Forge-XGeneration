package net.luis.nero.common.item.rune;

import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class AirRuneItem extends AbstractRuneItem {

	public AirRuneItem(Properties properties) {
		super(RuneType.AIR, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		double xMotion = player.getViewVector(1.0F).x();
		double yMotion = 1.3;
		double zMotion = player.getViewVector(1.0F).z();
		Vector3d vector = new Vector3d(xMotion, yMotion, zMotion);
		player.setDeltaMovement(vector);
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		return false;
	}

}
