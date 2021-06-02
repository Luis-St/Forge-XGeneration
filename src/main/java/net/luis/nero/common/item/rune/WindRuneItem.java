package net.luis.nero.common.item.rune;

import java.util.List;
import java.util.Random;

import net.luis.nero.common.enums.RuneType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class WindRuneItem extends AbstractRuneItem {

	public WindRuneItem(Properties properties) {
		super(RuneType.WIND, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		AxisAlignedBB alignedBB = new AxisAlignedBB(x - 15, y - 5, z - 15, x + 15, y + 5, z + 15);
		List<LivingEntity> livingEntities = world.getEntitiesOfClass(LivingEntity.class, alignedBB, EntityPredicates.NO_CREATIVE_OR_SPECTATOR);
		livingEntities.removeIf(livingEntity -> livingEntity == player);
		for (LivingEntity livingEntity : livingEntities) {
			livingEntity.yRot = new Random().nextFloat() * 360.0F;
			double windXMotion = livingEntity.getViewVector(1.0F).x() * -1;
			double windYMotion = livingEntity instanceof PlayerEntity ? 1.5 : 1.0;
			double windZMotion = livingEntity.getViewVector(1.0F).z() * -1;
			livingEntity.setDeltaMovement(windXMotion, windYMotion, windZMotion);
		}
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, PlayerEntity player, LivingEntity target, ItemStack orbStack) {
		return false;
	}

}
