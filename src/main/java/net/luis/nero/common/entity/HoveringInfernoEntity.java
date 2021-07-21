package net.luis.nero.common.entity;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.client.render.entity.EntityRenderPos;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

// TODO: custom attack goal
// TODO: order values/methods, remove uneeded things
// TODO: EntitySpawnPlacementRegistry
@Config
public class HoveringInfernoEntity extends BlazeEntity {
	
	private static final DataParameter<Integer> DATA = EntityDataManager.defineId(HoveringInfernoEntity.class, DataSerializers.INT);
	
	@ConfigValue private static Double HOVERING_INFERNO_ATTACK_DAMAGE = 10.0;
	@ConfigValue private static Double HOVERING_INFERNO_MOVEMENT_SPEED = 0.3;
	@ConfigValue private static Double HOVERING_INFERNO_FOLLOW_RANGE = 64.0;
	@ConfigValue private static Double HOVERING_INFERNO_MAX_HEALTH = 40.0;
	@ConfigValue private static Double HOVERING_INFERNO_KNOCKBACK_RESISTANCE = 0.5;
	@ConfigValue private static Double HOVERING_INFERNO_DAMAGE_RESISTANCE = 0.25;
	
	public EntityRenderPos shieldNorth = new EntityRenderPos();
	public EntityRenderPos shieldEast = new EntityRenderPos();
	public EntityRenderPos shieldSouth = new EntityRenderPos();
	public EntityRenderPos shieldWest = new EntityRenderPos();
	public List<EntityRenderPos> shields = Lists.newArrayList(this.shieldNorth, this.shieldEast, this.shieldSouth, this.shieldWest);
	
	public boolean attacking = false;
	
	public HoveringInfernoEntity(World world, int x, int y, int z) {
		this(world, (double) x, (double) y, (double) z);
	}
	
	public HoveringInfernoEntity(World world, double x, double y, double z) {
		this(ModEntityTypes.HOVERING_INFERNO.get(), world);
		this.setPos(x, y, z);
	}
	
	public HoveringInfernoEntity(EntityType<? extends BlazeEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
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
				shield.yRot += 0.017453292;
			});
			if (this.areShieldsActive()) {
				this.shields.forEach(shield -> {
					if (shield.xRot == -0.27f || shield.xRot == -0.26f) {
						shield.xRotO = -0.26f;
						shield.xRot = -0.26f;
					} else if (shield.xRot > -0.26f && 0.0f >= shield.xRot) {
						shield.xRotO = shield.xRot;
						shield.xRot = this.floorRot(shield.xRot, -0.01f);
					}
				});
			} else {
				this.shields.forEach(shield -> {
					if (shield.xRot == 0.0f || shield.xRot == 0.1f) {
						shield.xRotO = 0.0f;
						shield.xRot = 0.0f;
					} else if (shield.xRot >= -0.26f && 0.0f > shield.xRot) {
						shield.xRotO = shield.xRot;
						shield.xRot = this.floorRot(shield.xRot, 0.01f);
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
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		amount *= 1 - HOVERING_INFERNO_DAMAGE_RESISTANCE;
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
			this.setShieldActiveTime(MathHelper.nextInt(this.random, 100, 300) + this.random.nextInt(150));
		}
		return hurt;
	}
	
	public boolean isClientSide() {
		return this.level.isClientSide;
	}
	
	@Override
	public ItemStack getItemBySlot(EquipmentSlotType slotType) {
		return slotType == EquipmentSlotType.HEAD ? new ItemStack(Items.NETHERITE_HELMET) : ItemStack.EMPTY;
	}
	
	public boolean areShieldsActive() {
		return this.entityData.get(DATA) > 0;
	}
	
	public int getShieldActiveTime() {
		return this.entityData.get(DATA);
	}
	
	public void setShieldActiveTime(int shieldActiveTime) {
		this.entityData.set(DATA, MathHelper.clamp(shieldActiveTime, 0, 600));
	}
	
	public static AttributeModifierMap registerAttributes() {
	      return MonsterEntity.createMonsterAttributes()
	    		  .add(Attributes.ATTACK_DAMAGE, HOVERING_INFERNO_ATTACK_DAMAGE)
	    		  .add(Attributes.MOVEMENT_SPEED, HOVERING_INFERNO_MOVEMENT_SPEED)
	    		  .add(Attributes.FOLLOW_RANGE, HOVERING_INFERNO_FOLLOW_RANGE)
	    		  .add(Attributes.KNOCKBACK_RESISTANCE, HOVERING_INFERNO_KNOCKBACK_RESISTANCE)
	    		  .add(Attributes.MAX_HEALTH, HOVERING_INFERNO_MAX_HEALTH).build();
	}
	
}
