package net.luis.nero.common.entity;

import net.luis.nero.api.common.entity.ISoulFireEntity;
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

//TODO: fix
public class SoulFireballEntity extends Fireball implements ISoulFireEntity {

	public SoulFireballEntity(Level world, LivingEntity shooter, double x, double y, double z) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), shooter, x, y, z, world);
	}

	public SoulFireballEntity(Level world, double x, double y, double z, double xPower, double yPower, double zPower) {
		super(ModEntityTypes.SOUL_FIREBALL.get(), x, y, z, xPower, yPower, zPower, world);
	}

	public SoulFireballEntity(EntityType<? extends SoulFireballEntity> entityType, Level world) {
		super(entityType, world);
	}
	
	@Override
	protected void onHitEntity(EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (!this.level.isClientSide) {
			Entity entity = hitResult.getEntity();
			Entity entity1 = this.getOwner();
			entity.hurt(DamageSource.fireball(this, entity1), 6.0F);
			if (entity1 instanceof LivingEntity) {
				this.doEnchantDamageEffects((LivingEntity) entity1, entity);
			}

		}
	}
	
	@Override
	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level.isClientSide) {
			boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
			this.level.explode(null, this.getX(), this.getY(), this.getZ(), 1.0f, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
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
