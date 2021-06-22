package net.luis.nero.common.entity;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.luis.nero.init.entity.ModEntityTypes;
import net.luis.nero.init.items.ModItems;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.network.NetworkHooks;

public class SoulFireballEntity extends AbstractFireballEntity implements ISoulFireEntity {

	public SoulFireballEntity(World world, LivingEntity shooter, double x, double y, double z) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), shooter, x, y, z, world);
	}

	public SoulFireballEntity(World world, double x, double y, double z, double xPower, double yPower, double zPower) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), x, y, z, xPower, yPower, zPower, world);
	}

	public SoulFireballEntity(EntityType<? extends SoulFireballEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void onHitEntity(EntityRayTraceResult entityRayTraceResult) {
		super.onHitEntity(entityRayTraceResult);
		if (!this.level.isClientSide) {
			Entity entity = entityRayTraceResult.getEntity();
			if (!entity.fireImmune()) {
				Entity owner = this.getOwner();
				int i = entity.getRemainingFireTicks();
				entity.setSecondsOnFire(5);
				boolean flag = entity.hurt(DamageSource.fireball(this, owner), 5.0F);
				if (!flag) {
					entity.setRemainingFireTicks(i);
				} else if (owner instanceof LivingEntity) {
					this.doEnchantDamageEffects((LivingEntity) owner, entity);
				}
			}

		}
	}
	
	@Override
	protected void onHitBlock(BlockRayTraceResult blockRayTraceResult) {
		super.onHitBlock(blockRayTraceResult);
		if (!this.level.isClientSide) {
			Entity entity = this.getOwner();
			if (entity == null || !(entity instanceof MobEntity) || this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || 
					ForgeEventFactory.getMobGriefingEvent(this.level, this.getEntity())) {
				BlockPos pos = blockRayTraceResult.getBlockPos().relative(blockRayTraceResult.getDirection());
				if (this.level.isEmptyBlock(pos)) {
					this.level.setBlockAndUpdate(pos, AbstractFireBlock.getState(this.level, pos));
				}
			}

		}
	}
	
	@Override
	protected void onHit(RayTraceResult rayTraceResult) {
		super.onHit(rayTraceResult);
		if (!this.level.isClientSide) {
			this.remove();
		}

	}
	
	@Override
	public boolean isPickable() {
		return false;
	}
	
	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		return false;
	}
	
	@Override
	public boolean displaySoulFireAnimation() {
		return true;
	}
	
	@Override
	public boolean displayFireAnimation() {
		return false;
	}
	
	@Override
	public ItemStack getItem() {
		return new ItemStack(ModItems.SOUL_FIRE_CHARGE.get());
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
