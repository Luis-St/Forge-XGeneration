package net.luis.nero.common.entity.goal;

import java.util.EnumSet;

import net.luis.nero.common.entity.SoulBlazeEntity;
import net.luis.nero.common.entity.SoulFireballEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;

public class SoulFireballAttackGoal extends Goal {

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
		LivingEntity livingEntity = this.blaze.getTarget();
		return livingEntity != null && livingEntity.isAlive() && this.blaze.canAttack(livingEntity);
	}
	
	@Override
	public void start() {
		this.attackStep = 0;
	}
	
	@Override
	public void stop() {
		this.blaze.setCharge(false);
		this.lastSeen = 0;
	}
	
	@Override
	public void tick() {
		--this.attackTime;
		LivingEntity target = this.blaze.getTarget();
		if (target != null) {
			boolean canSee = this.blaze.getSensing().hasLineOfSight(target);
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
						this.blaze.setCharge(true);
					} else if (this.attackStep <= 4) {
						this.attackTime = 6;
					} else {
						this.attackTime = 100;
						this.attackStep = 0;
						this.blaze.setCharge(false);
					}
					if (this.attackStep > 1) {
						float distanceSqrt = (float) (Math.sqrt(Math.sqrt(distance)) * 0.5F);
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