package net.luis.nero.common.entity.goal;

import java.util.EnumSet;

import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraftforge.common.util.Constants;

public class FireballRingAttackGoal extends Goal {

	private final HoveringInfernoEntity hoveringInferno;
	private int attackStep;
	private int attackTime;
	private int firedRecentlyTimer;

	public FireballRingAttackGoal(HoveringInfernoEntity hoveringInferno) {
		this.hoveringInferno = hoveringInferno;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}
	
	@Override
	public boolean canUse() {
		LivingEntity livingentity = this.hoveringInferno.getTarget();
		return livingentity != null && livingentity.isAlive() && this.hoveringInferno.canAttack(livingentity);
	}

	@Override
	public void start() {
		this.attackStep = 0;
	}

	@Override
	public void stop() {
//		this.hoveringInferno.setOnFire(false);
//		this.hoveringInferno.setShielding(false);
//		this.hoveringInferno.setAttacking(false);
		this.firedRecentlyTimer = 0;
	}

	@Override
	public void tick() {
		--this.attackTime;
		LivingEntity target = this.hoveringInferno.getTarget();
//		this.hoveringInferno.setAttacking(false);
		if (target != null) {
			boolean canSee = this.hoveringInferno.getSensing().canSee(target);
			if (canSee) {
				this.firedRecentlyTimer = 0;
			} else {
				++this.firedRecentlyTimer;
			}
			double distance = this.hoveringInferno.distanceToSqr(target);
			if (distance < 4.0D) {
//				this.hoveringInferno.setOnFire(true);
				if (this.attackTime <= 0) {
//					this.hoveringInferno.setAttacking(true);
					this.attackTime = 5;
					this.hoveringInferno.doHurtTarget(target);
//					target.setFire(4);
				}
				this.hoveringInferno.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
			} else if (distance < this.getFollowDistance() * this.getFollowDistance() && canSee) {
				double distanceX = target.getX() - this.hoveringInferno.getX();
				double distanceY = target.getY(0.5D) - this.hoveringInferno.getY(0.5D);
				double distanceZ = target.getZ() - this.hoveringInferno.getZ();
				float health = (this.hoveringInferno.getMaxHealth() - this.hoveringInferno.getHealth()) / 2;
				float healthPercent = this.hoveringInferno.getHealth() / this.hoveringInferno.getMaxHealth();
				int maxAttackSteps = 3;
				if (distance < 36.0D) {
					++maxAttackSteps;
				}
				if (healthPercent < 0.6) {
					++maxAttackSteps;
				}
				if (this.attackTime <= 0) {
//					this.hoveringInferno.setShielding(false);
					++this.attackStep;
					if (this.attackStep == 1) {
						this.attackTime = (int) (40 * healthPercent + 20);
//						this.hoveringInferno.setOnFire(true);
					} else if (this.attackStep <= maxAttackSteps) {
						this.attackTime = (int) (25 * healthPercent + 5);
					} else {
						this.attackTime = 200;
						this.attackStep = 0;
//						this.hoveringInferno.setOnFire(false);
//						this.hoveringInferno.setAttacking(false);
					}
					if (this.attackStep > 1) {
//						this.hoveringInferno.setAttacking(true);
						if (!this.hoveringInferno.isSilent()) {
							this.hoveringInferno.level.levelEvent(null, Constants.WorldEvents.BLAZE_SHOOT_SOUND, this.hoveringInferno.blockPosition(), 0);
						}
						distanceX = target.getX() - this.hoveringInferno.getX();
						distanceY = target.getY(0.5D) - this.hoveringInferno.getY(0.5D);
						distanceZ = target.getZ() - this.hoveringInferno.getZ();
						for (int i = 0; i <= (17 - 1); ++i) {
							double angle = (i - ((10 - 1) / 2)) * toRadians(4.0);
							double x = distanceX * Math.cos(angle) + distanceZ * Math.sin(angle);
							double y = distanceY;
							double z = -distanceX * Math.sin(angle) + distanceZ * Math.cos(angle);
							double maxDepressAngle = Math.abs((Math.atan2(distanceY, Math.sqrt((distanceX * distanceX) + (distanceZ * distanceZ)))));
							if (maxDepressAngle > toRadians(50.0)) {
								y = -Math.tan(toRadians(50.0)) * (Math.sqrt((distanceX * distanceX) + (distanceZ * distanceZ)));
							}
							SmallFireballEntity fireballEntity = new SmallFireballEntity(this.hoveringInferno.level, this.hoveringInferno, x, y, z);
							fireballEntity.setPos(fireballEntity.getX(), this.hoveringInferno.getY(0.5D), fireballEntity.getZ());
							this.hoveringInferno.level.addFreshEntity(fireballEntity);
						}
					}
				} else if (this.attackTime < 160 + health && this.attackTime > 90 - health) {
//					this.hoveringInferno.setShielding(true);
				} else if (this.attackTime >= 30 && this.attackTime >= 50) {
//					this.hoveringInferno.setShielding(false);
//					this.hoveringInferno.shieldDisabled = false;
				}
//				this.hoveringInferno.setInvulnerable(this.hoveringInferno.getShielding());
				this.hoveringInferno.getLookControl().setLookAt(hoveringInferno, 10.0F, 10.0F);
			} else if (this.firedRecentlyTimer < 5) {
				this.hoveringInferno.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
			}
			super.tick();
		}
	}

	private double getFollowDistance() {
		return this.hoveringInferno.getAttributeValue(Attributes.FOLLOW_RANGE);
	}
	
	private double toRadians(double degree) {
		return (degree / 180) * Math.PI;
	}

}
