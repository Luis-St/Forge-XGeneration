package net.luis.nero.common.entity;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

// TODO: finish

public class HoveringInfernoEntity extends BlazeEntity {
	
	// TODO: config value for Attributes
	
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
	protected void defineSynchedData() {
		super.defineSynchedData();
		
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
	
	public static AttributeModifierMap registerAttributes() {
	      return MonsterEntity.createMonsterAttributes()
	    		  .add(Attributes.ATTACK_DAMAGE, 10.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.3)
	    		  .add(Attributes.FOLLOW_RANGE, 64.0D)
	    		  .add(Attributes.KNOCKBACK_RESISTANCE, 0.1D)
	    		  .add(Attributes.MAX_HEALTH, 40.0D).build();
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
}
