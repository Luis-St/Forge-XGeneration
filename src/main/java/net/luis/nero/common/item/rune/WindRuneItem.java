package net.luis.nero.common.item.rune;

import java.util.List;
import java.util.Random;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

@Config
public class WindRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer WIND_RUNE_ENTITY_AREA_X = 15;
	@ConfigValue
	private static Integer WIND_RUNE_ENTITY_AREA_Y = 30;
	@ConfigValue
	private static Integer WIND_RUNE_ENTITY_AREA_Z = 15;
	@ConfigValue
	private static Double WIND_RUNE_PLAYER_Y_MOTION = 1.5;
	@ConfigValue
	private static Double WIND_RUNE_ENTITY_Y_MOTION = 1.0;
	
	public WindRuneItem(Properties properties) {
		super(RuneType.WIND, properties);
	}

	@Override
	protected InteractionResultHolder<ItemStack> useRune(Level world, Player player, InteractionHand hand, ItemStack orbStack) {
		if (!world.isClientSide()) {
			double x = player.getX();
			double y = player.getY();
			double z = player.getZ();
			AABB alignedBB = new AABB(x - WIND_RUNE_ENTITY_AREA_X, y - WIND_RUNE_ENTITY_AREA_Y, z - WIND_RUNE_ENTITY_AREA_Z, x + WIND_RUNE_ENTITY_AREA_X, 
					y + WIND_RUNE_ENTITY_AREA_Y, z + WIND_RUNE_ENTITY_AREA_Z);
			List<LivingEntity> livingEntities = world.getEntitiesOfClass(LivingEntity.class, alignedBB, EntitySelector.NO_CREATIVE_OR_SPECTATOR);
			livingEntities.removeIf(livingEntity -> livingEntity == player);
			for (LivingEntity livingEntity : livingEntities) {
				livingEntity.yHeadRot = new Random().nextFloat() * 360.0F;
				double windXMotion = livingEntity.getViewVector(1.0F).x() * -1;
				double windYMotion = livingEntity instanceof Player ? WIND_RUNE_PLAYER_Y_MOTION : WIND_RUNE_ENTITY_Y_MOTION;
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
