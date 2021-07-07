package net.luis.nero.common.entity;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

// TODO: finish

@Config
public class HoveringInfernoEntity extends BlazeEntity {
	
	public static final DataParameter<CompoundNBT> NBT_DATA = EntityDataManager.defineId(HoveringInfernoEntity.class, DataSerializers.COMPOUND_TAG);
	
	@ConfigValue
	private static Double HOVERING_INFERNO_ATTACK_DAMAGE = 10.0;
	@ConfigValue
	private static Double HOVERING_INFERNO_MOVEMENT_SPEED = 0.3;
	@ConfigValue
	private static Double HOVERING_INFERNO_FOLLOW_RANGE = 64.0;
	@ConfigValue
	private static Double HOVERING_INFERNO_MAX_HEALTH = 40.0;
	@ConfigValue
	private static Double HOVERING_INFERNO_KNOCKBACK_RESISTANCE = 0.5;
	@ConfigValue
	private static Double HOVERING_INFERNO_DAMAGE_RESISTANCE = 0.25;
	
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
		if (this.level.isClientSide) {
			this.level.addParticle(ParticleTypes.FLAME, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	public boolean isOnFire() {
		boolean flag = this.level != null && this.level.isClientSide;
		return !this.fireImmune() && (this.getRemainingFireTicks() > 0 || flag && this.getSharedFlag(0));
	}
	
	@Override
	public void tick() {
		super.tick();
		if (this.areShieldsActive()) {
			this.setShieldActiveTime(this.getShieldActiveTime() - 1);
		}
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("shieldActiveTime", 0);
		this.entityData.define(NBT_DATA, nbt);
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
	
	@Override
	public ItemStack getItemBySlot(EquipmentSlotType slotType) {
		return slotType == EquipmentSlotType.HEAD ? new ItemStack(Items.NETHERITE_HELMET) : ItemStack.EMPTY;
	}
	
	public boolean areShieldsActive() {
		return this.entityData.get(NBT_DATA).getInt("shieldActiveTime") > 0;
	}
	
	public int getShieldActiveTime() {
		return this.entityData.get(NBT_DATA).getInt("shieldActiveTime");
	}
	
	public void setShieldActiveTime(int shieldActiveTime) {
		CompoundNBT nbt = this.entityData.get(NBT_DATA);
		if (nbt.contains("shieldActiveTime")) {
			nbt.remove("shieldActiveTime");
		}
		nbt.putInt("shieldActiveTime", MathHelper.clamp(shieldActiveTime, 0, 600));
		this.entityData.set(NBT_DATA, nbt);
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
