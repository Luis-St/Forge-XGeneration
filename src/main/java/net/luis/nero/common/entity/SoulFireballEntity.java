package net.luis.nero.common.entity;

import net.luis.nero.init.entity.ModEntityTypes;
import net.luis.nero.init.items.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class SoulFireballEntity extends Fireball implements ISoulFireEntity {

	public SoulFireballEntity(Level level, LivingEntity shooter, double x, double y, double z) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), shooter, x, y, z, level);
	}

	public SoulFireballEntity(Level level, double x, double y, double z, double xPower, double yPower, double zPower) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), x, y, z, xPower, yPower, zPower, level);
	}

	public SoulFireballEntity(EntityType<? extends SoulFireballEntity> entityType, Level level) {
		super(entityType, level);
	}
	
	@Override
	protected void onHitEntity(EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (!this.level.isClientSide) {
			Entity entity = hitResult.getEntity();
			Entity owner = this.getOwner();
			entity.hurt(DamageSource.fireball(this, owner), 6.0F);
			if (owner instanceof LivingEntity) {
				this.doEnchantDamageEffects((LivingEntity) owner, entity);
			}

		}
	}
	
	@Override
	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level.isClientSide) {
			boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
			this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1.0F, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
			this.discard();
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
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
