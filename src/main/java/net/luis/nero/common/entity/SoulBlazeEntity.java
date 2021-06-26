package net.luis.nero.common.entity;

import java.util.EnumSet;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

@Config
public class SoulBlazeEntity extends BlazeEntity implements ISoulFireEntity {
	
	@ConfigValue
	private static Double SOUL_BLAZE_ATTACK_DAMAGE = 6.0;
	@ConfigValue
	private static Double SOUL_BLAZE_MOVEMENT_SPEED = 0.23;
	@ConfigValue
	private static Double SOUL_BLAZE_FOLLOW_RANGE = 48.0;
	
	private static final DataParameter<Byte> DATA_FLAGS_ID = EntityDataManager.defineId(BlazeEntity.class, DataSerializers.BYTE);
	
	public SoulBlazeEntity(World world, int x, int y, int z) {
		this(world, (double) x, (double) y, (double) z);
	}
	
	public SoulBlazeEntity(World world, double x, double y, double z) {
		this(ModEntityTypes.SOUL_BLAZE.get(), world);
		this.setPos(x, y, z);
	}
	
	public SoulBlazeEntity(EntityType<? extends BlazeEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	public boolean displayFireAnimation() {
		return false;
	}
	
	@Override
	public boolean displaySoulFireAnimation() {
		return this.isOnFire() && !this.isSpectator();
	}
	
	@Override
	public boolean isOnFire() {
		return this.isCharged();
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(4, new SoulBlazeEntity.SoulFireballAttackGoal(this));
		this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0, 0.0F));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
	}

	public boolean isCharged() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	public void setCharged(boolean charged) {
		byte b = this.entityData.get(DATA_FLAGS_ID);
		if (charged) {
			b = (byte) (b | 1);
		} else {
			b = (byte) (b & -2);
		}
		this.entityData.set(DATA_FLAGS_ID, b);
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	public static AttributeModifierMap registerAttributes() {
	      return MonsterEntity.createMonsterAttributes()
	    		  .add(Attributes.ATTACK_DAMAGE, SOUL_BLAZE_ATTACK_DAMAGE)
	    		  .add(Attributes.MOVEMENT_SPEED, SOUL_BLAZE_MOVEMENT_SPEED)
	    		  .add(Attributes.FOLLOW_RANGE, SOUL_BLAZE_FOLLOW_RANGE).build();
	}
	
	public static class SoulFireballAttackGoal extends Goal {
		
		private final SoulBlazeEntity blaze;
		private int attackStep;
		private int attackTime;
		private int lastSeen;

		public SoulFireballAttackGoal(SoulBlazeEntity soulBlaze) {
			this.blaze = soulBlaze;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}
		
		@Override
		public boolean canUse() {
			LivingEntity livingentity = this.blaze.getTarget();
			return livingentity != null && livingentity.isAlive() && this.blaze.canAttack(livingentity);
		}
		
		@Override
		public void start() {
			this.attackStep = 0;
		}
		
		@Override
		public void stop() {
			this.blaze.setCharged(false);
			this.lastSeen = 0;
		}
		
		@Override
		public void tick() {
			--this.attackTime;
			LivingEntity target = this.blaze.getTarget();
			if (target != null) {
				boolean canSee = this.blaze.getSensing().canSee(target);
				if (canSee) {
					this.lastSeen = 0;
				} else {
					++this.lastSeen;
				}
				double distance = this.blaze.distanceToSqr(target);
				if (distance < 4.0D) {
					if (!canSee) {
						return;
					}
					if (this.attackTime <= 0) {
						this.attackTime = 20;
						this.blaze.doHurtTarget(target);
					}
					this.blaze.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
				} else if (distance < this.getFollowDistance() * this.getFollowDistance() && canSee) {
					double distanceX = target.getX() - this.blaze.getX();
					double distanceY = target.getY(0.5D) - this.blaze.getY(0.5D);
					double distanceZ = target.getZ() - this.blaze.getZ();
					if (this.attackTime <= 0) {
						++this.attackStep;
						if (this.attackStep == 1) {
							this.attackTime = 60;
							this.blaze.setCharged(true);
						} else if (this.attackStep <= 4) {
							this.attackTime = 6;
						} else {
							this.attackTime = 100;
							this.attackStep = 0;
							this.blaze.setCharged(false);
						}
						if (this.attackStep > 1) {
							float distanceSqrt = MathHelper.sqrt(MathHelper.sqrt(distance)) * 0.5F;
							if (!this.blaze.isSilent()) {
								this.blaze.level.levelEvent(null, 1018, this.blaze.blockPosition(), 0);
							}
							for (int i = 0; i < 1; ++i) {
								SoulFireballEntity smallfireballentity = new SoulFireballEntity(this.blaze.level, this.blaze, 
										distanceX + this.blaze.getRandom().nextGaussian() * distanceSqrt, distanceY,
										distanceZ + this.blaze.getRandom().nextGaussian() * distanceSqrt);
								smallfireballentity.setPos(smallfireballentity.getX(), this.blaze.getY(0.5D) + 0.5D, smallfireballentity.getZ());
								this.blaze.level.addFreshEntity(smallfireballentity);
							}
						}
					}

					this.blaze.getLookControl().setLookAt(target, 10.0F, 10.0F);
				} else if (this.lastSeen < 5) {
					this.blaze.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
				}
				super.tick();
			}
		}

		private double getFollowDistance() {
			return this.blaze.getAttributeValue(Attributes.FOLLOW_RANGE);
		}
		
	}
	
}
