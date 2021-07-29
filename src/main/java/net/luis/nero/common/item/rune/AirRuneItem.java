package net.luis.nero.common.item.rune;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

@Config
public class AirRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Double AIR_RUNE_Y_MOTION = 1.3; 
	
	public AirRuneItem(Properties properties) {
		super(RuneType.AIR, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level world, Player player, InteractionHand hand, ItemStack orbStack) {
		double xMotion = player.getViewVector(1.0F).x();
		double yMotion = AIR_RUNE_Y_MOTION;
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
