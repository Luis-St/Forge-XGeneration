package net.luis.nero.common.item;

import java.util.List;
import java.util.Random;

import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class WindRuneItem extends AbstractRuneItem {
	
	public WindRuneItem(Properties properties) {
		super(RuneType.WIND, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		if (!level.isClientSide()) {
			double x = player.getX();
			double y = player.getY();
			double z = player.getZ();
			AABB alignedBB = new AABB(x - 15, y - 30, z - 15, x + 15, y + 30, z + 15);
			List<LivingEntity> livingEntities = level.getEntitiesOfClass(LivingEntity.class, alignedBB, EntitySelector.NO_CREATIVE_OR_SPECTATOR);
			livingEntities.removeIf(livingEntity -> livingEntity == player);
			for (LivingEntity livingEntity : livingEntities) {
				livingEntity.yHeadRot = new Random().nextFloat() * 360.0F;
				double windXMotion = livingEntity.getViewVector(1.0F).x() * -1;
				double windYMotion = livingEntity instanceof Player ? 1.5 : 1.0;
				double windZMotion = livingEntity.getViewVector(1.0F).z() * -1;
				livingEntity.setDeltaMovement(windXMotion, windYMotion, windZMotion);
			}
		}
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		return false;
	}

}
