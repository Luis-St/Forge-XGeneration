package net.luis.nero.common.item.rune;

import net.luis.nero.common.enums.RuneType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
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
	@SuppressWarnings("resource")
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		ClientPlayerEntity clientPlayer = Minecraft.getInstance().player;
		double xMotion = clientPlayer.getViewVector(1.0F).x();
		double yMotion = 1.3;
		double zMotion = clientPlayer.getViewVector(1.0F).z();
		Vector3d vector = new Vector3d(xMotion, yMotion, zMotion);
		clientPlayer.setDeltaMovement(vector);
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, PlayerEntity player, LivingEntity target, ItemStack orbStack) {
		return false;
	}

}
