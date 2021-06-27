package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

@Config
public class AirRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Double AIR_RUNE_Y_MOTION = 1.3; 
	
	public AirRuneItem(Properties properties) {
		super(RuneType.AIR, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		double xMotion = player.getViewVector(1.0F).x();
		double yMotion = AIR_RUNE_Y_MOTION;
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
