package net.luis.nero.common.entity;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.entity.goal.SoulFireballAttackGoal;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
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
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
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
		this.goalSelector.addGoal(4, new SoulFireballAttackGoal(this));
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
	
}
