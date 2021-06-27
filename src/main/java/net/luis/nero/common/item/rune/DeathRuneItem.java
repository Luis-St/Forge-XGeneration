package net.luis.nero.common.item.rune;

import java.util.List;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

@Config
public class DeathRuneItem extends AbstractRuneItem {
	
	@ConfigValue
	private static Integer DEATH_RUNE_ENTITY_AREA_X = 7;
	@ConfigValue
	private static Integer DEATH_RUNE_ENTITY_AREA_Y = 7;
	@ConfigValue
	private static Integer DEATH_RUNE_ENTITY_AREA_Z = 7;
	
	public DeathRuneItem(Properties properties) {
		super(RuneType.DEATH, properties);
	}

	@Override
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack) {
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		AxisAlignedBB alignedBB = new AxisAlignedBB(x - DEATH_RUNE_ENTITY_AREA_X, y - DEATH_RUNE_ENTITY_AREA_Y, z - DEATH_RUNE_ENTITY_AREA_Z, 
				x + DEATH_RUNE_ENTITY_AREA_X, y + DEATH_RUNE_ENTITY_AREA_Y, z + DEATH_RUNE_ENTITY_AREA_Z);
		List<LivingEntity> livingEntities = world.getEntitiesOfClass(LivingEntity.class, alignedBB, EntityPredicates.NO_CREATIVE_OR_SPECTATOR);
		livingEntities.removeIf(livingEntity -> livingEntity == player);
		for (LivingEntity livingEntity : livingEntities) {
			float damage = livingEntity instanceof PlayerEntity ? livingEntity.getHealth() / 4 : Float.MAX_VALUE;
			livingEntity.hurt(ModDamageSources.DEATH_RUNE, damage);
		}
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack) {
		float damage = target instanceof PlayerEntity ? target.getHealth() / 4 : Float.MAX_VALUE;
		target.hurt(ModDamageSources.DEATH_RUNE, damage);
		return true;
	}

}
