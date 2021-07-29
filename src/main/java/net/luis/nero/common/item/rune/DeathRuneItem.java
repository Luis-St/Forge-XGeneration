package net.luis.nero.common.item.rune;

import java.util.List;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.enums.RuneType;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

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
	protected InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack) {
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		AABB alignedBB = new AABB(x - DEATH_RUNE_ENTITY_AREA_X, y - DEATH_RUNE_ENTITY_AREA_Y, z - DEATH_RUNE_ENTITY_AREA_Z, 
				x + DEATH_RUNE_ENTITY_AREA_X, y + DEATH_RUNE_ENTITY_AREA_Y, z + DEATH_RUNE_ENTITY_AREA_Z);
		List<LivingEntity> livingEntities = level.getEntitiesOfClass(LivingEntity.class, alignedBB, EntitySelector.NO_CREATIVE_OR_SPECTATOR);
		livingEntities.removeIf(livingEntity -> livingEntity == player);
		for (LivingEntity livingEntity : livingEntities) {
			float damage = livingEntity instanceof Player ? livingEntity.getHealth() / 4 : Float.MAX_VALUE;
			livingEntity.hurt(ModDamageSources.DEATH_RUNE, damage);
		}
		return this.success(player, hand);
	}

	@Override
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack) {
		float damage = target instanceof Player ? target.getHealth() / 4 : Float.MAX_VALUE;
		target.hurt(ModDamageSources.DEATH_RUNE, damage);
		return true;
	}

}
