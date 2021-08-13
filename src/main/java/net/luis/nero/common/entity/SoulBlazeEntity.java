package net.luis.nero.common.entity;

import net.luis.nero.api.common.entity.ISoulFireEntity;
import net.luis.nero.common.entity.goal.SoulFireballAttackGoal;
import net.luis.nero.init.entity.ModEntityTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class SoulBlazeEntity extends Blaze implements ISoulFireEntity {
	
	
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Blaze.class, EntityDataSerializers.BYTE);
	
	public SoulBlazeEntity(Level level, int x, int y, int z) {
		this(level, (double) x, (double) y, (double) z);
	}
	
	public SoulBlazeEntity(Level level, double x, double y, double z) {
		this(ModEntityTypes.SOUL_BLAZE.get(), level);
		this.setPos(x, y, z);
	}
	
	public SoulBlazeEntity(EntityType<? extends Blaze> entityType, Level level) {
		super(entityType, level);
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
		return this.isCharge();
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

	public boolean isCharge() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}
	
	public void setCharge(boolean charge) {
		byte b = this.entityData.get(DATA_FLAGS_ID);
		if (charge) {
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
	      return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 6.0)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.23).add(Attributes.FOLLOW_RANGE, 48.0).build();
	}
	
}
