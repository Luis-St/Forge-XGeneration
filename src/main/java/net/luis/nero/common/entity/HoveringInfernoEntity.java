package net.luis.nero.common.entity;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.nero.client.render.entity.EntityRenderPos;
import net.luis.nero.common.entity.goal.FireballRingAttackGoal;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class HoveringInfernoEntity extends Blaze {
	
	private static final EntityDataAccessor<Integer> DATA = SynchedEntityData.defineId(HoveringInfernoEntity.class, EntityDataSerializers.INT);
	
	public EntityRenderPos shieldNorth = new EntityRenderPos();
	public EntityRenderPos shieldEast = new EntityRenderPos();
	public EntityRenderPos shieldSouth = new EntityRenderPos();
	public EntityRenderPos shieldWest = new EntityRenderPos();
	public List<EntityRenderPos> shields = Lists.newArrayList(this.shieldNorth, this.shieldEast, this.shieldSouth, this.shieldWest);
	
	public boolean attacking = false;
	
	public HoveringInfernoEntity(Level level, int x, int y, int z) {
		this(level, (double) x, (double) y, (double) z);
	}
	
	public HoveringInfernoEntity(Level level, double x, double y, double z) {
		this(ModEntityTypes.HOVERING_INFERNO.get(), level);
		this.setPos(x, y, z);
	}
	
	public HoveringInfernoEntity(EntityType<? extends HoveringInfernoEntity> entityType, Level level) {
		super(entityType, level);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(4, new FireballRingAttackGoal(this));
		this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isClientSide()) {
			this.level.addParticle(ParticleTypes.FLAME, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA, 0);
	}
	
	@Override
	public boolean isOnFire() {
		boolean flag = this.level != null && this.level.isClientSide;
		return !this.fireImmune() && (this.getRemainingFireTicks() > 0 || flag && this.getSharedFlag(0));
	}
	
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public ItemStack getItemBySlot(EquipmentSlot slotType) {
		return slotType == EquipmentSlot.HEAD ? new ItemStack(Items.NETHERITE_HELMET) : ItemStack.EMPTY;
	}
	
	@Override
	public boolean canAttack(LivingEntity livingEntity) {
		return super.canAttack(livingEntity) && this.areShieldsActive();
	}
	
	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		amount *= 1 - 0.25;
		boolean useAxe = false;
		if (damageSource.getEntity() instanceof LivingEntity) {
			LivingEntity attacker = (LivingEntity) damageSource.getEntity();
			if (attacker.getMainHandItem().getItem() instanceof AxeItem) {
				useAxe = true;
				amount /= 3;
				this.setShieldActiveTime(0);
			}
		}
		if (this.areShieldsActive()) {
			return false;
		}
		boolean hurt = super.hurt(damageSource, amount);
		if (hurt && !useAxe) {
			this.setShieldActiveTime(Mth.nextInt(this.random, 100, 300) + this.random.nextInt(150));
		}
		return hurt;
	}
	
	@Override
	public void tick() {
		super.tick();
		this.updateShields();
		if (this.areShieldsActive()) {
			this.setShieldActiveTime(this.getShieldActiveTime() - 1);
		}
	}
	
	private void updateShields() {
		if (this.isClientSide()) {
			this.shields.forEach(shield -> {
				shield.yRotO = shield.yRot;
				shield.yRot += 0.017453292F;
			});
			if (this.areShieldsActive()) {
				this.shields.forEach(shield -> {
					if (shield.xRot == -0.27F || shield.xRot == -0.26F) {
						shield.xRotO = -0.26F;
						shield.xRot = -0.26F;
					} else if (shield.xRot > -0.26F && 0.0F >= shield.xRot) {
						shield.xRotO = shield.xRot;
						shield.xRot = this.floorRot(shield.xRot, -0.01F);
					}
				});
			} else {
				this.shields.forEach(shield -> {
					if (shield.xRot == 0.0F || shield.xRot == 0.1F) {
						shield.xRotO = 0.0F;
						shield.xRot = 0.0F;
					} else if (shield.xRot >= -0.26f && 0.0F > shield.xRot) {
						shield.xRotO = shield.xRot;
						shield.xRot = this.floorRot(shield.xRot, 0.01F);
					}
				});
			}
		}
	}
	
	private final float floorRot(float f0, float g0) {
		float f1 = Math.round(f0 * 100);
		int f2 = (int) f1;
		
		float g1 = g0 * 100;
		int g2 = (int) g1;
		
		int h0 = f2 + g2;
		float h1 = h0;
		float h2 = h1 / 100;
		return h2;
	}
	
	public EntityRenderPos getShieldPos(Direction direction) {
		if (this.isClientSide()) {
			switch (direction) {
			case NORTH: return this.shieldNorth;
			case EAST: return this.shieldEast;
			case SOUTH: return this.shieldSouth;
			case WEST: return this.shieldWest;
			default: break;
			}
		}
		throw new IllegalArgumentException("No shield position for direction: " + direction);
	}
	
	public boolean isClientSide() {
		return this.level.isClientSide;
	}
		
	public boolean areShieldsActive() {
		return this.entityData.get(DATA) > 0;
	}
	
	public int getShieldActiveTime() {
		return this.entityData.get(DATA);
	}
	
	public void setShieldActiveTime(int shieldActiveTime) {
		this.entityData.set(DATA, Mth.clamp(shieldActiveTime, 0, 600));
	}
	
	public static AttributeSupplier registerAttributes() {
	      return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 10.0)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.FOLLOW_RANGE, 64.0)
	    		  .add(Attributes.KNOCKBACK_RESISTANCE, 0.5).add(Attributes.MAX_HEALTH, 40.0).build();
	}
	
}
