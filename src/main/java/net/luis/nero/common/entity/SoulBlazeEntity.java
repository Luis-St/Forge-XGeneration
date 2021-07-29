package net.luis.nero.common.entity;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.common.entity.goal.SoulFireballAttackGoal;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

@Config
public class SoulBlazeEntity extends Blaze implements ISoulFireEntity {
	
	@ConfigValue
	private static Double SOUL_BLAZE_ATTACK_DAMAGE = 6.0;
	@ConfigValue
	private static Double SOUL_BLAZE_MOVEMENT_SPEED = 0.23;
	@ConfigValue
	private static Double SOUL_BLAZE_FOLLOW_RANGE = 48.0;
	
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Blaze.class, EntityDataSerializers.BYTE);
	
	public SoulBlazeEntity(Level world, int x, int y, int z) {
		this(world, (double) x, (double) y, (double) z);
	}
	
	public SoulBlazeEntity(Level world, double x, double y, double z) {
		this(ModEntityTypes.SOUL_BLAZE.get(), world);
		this.setPos(x, y, z);
	}
	
	public SoulBlazeEntity(EntityType<? extends Blaze> entityType, Level world) {
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
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0, 0.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
	}

	public boolean isCharged() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}
	
	public void setCharge(boolean charged) {
		byte b = this.entityData.get(DATA_FLAGS_ID);
		if (charged) {
			b = (byte) (b | 1);
		} else {
			b = (byte) (b & -2);
		}
		this.entityData.set(DATA_FLAGS_ID, b);
	}
	
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	public static AttributeSupplier registerAttributes() {
	      return Monster.createMonsterAttributes()
	    		  .add(Attributes.ATTACK_DAMAGE, SOUL_BLAZE_ATTACK_DAMAGE)
	    		  .add(Attributes.MOVEMENT_SPEED, SOUL_BLAZE_MOVEMENT_SPEED)
	    		  .add(Attributes.FOLLOW_RANGE, SOUL_BLAZE_FOLLOW_RANGE).build();
	}
	
}
