package net.luis.industry.common.item;

import net.luis.industry.api.capability.CapabilityUtil;
import net.luis.industry.api.capability.interfaces.entity.IBloodCapability;
import net.luis.industry.api.item.IRuneType;
import net.luis.industry.api.item.RuneUseType;
import net.luis.industry.init.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RuneItem extends Item {
	
	private final IRuneType runeType;

	public RuneItem(IRuneType runeType, Properties properties) {
		super(properties);
		this.runeType = runeType;
	}

	public IRuneType getRuneType() {
		return this.runeType;
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			IBloodCapability bloodHandler = CapabilityUtil.getBloodCapability(serverPlayer);
			if (!bloodHandler.shouldDamage(this, RuneUseType.USE)) {
				bloodHandler.reduceBlood(this.runeType.getUseCost(), true);
				return this.useRune(world, serverPlayer, hand);
			} else {
				float f = this.runeType.getUseCost();
				serverPlayer.hurt(ModDamageSources.RUNE, f / 100);
				return this.useRune(world, serverPlayer, hand);
			}
		}
		return super.use(world, player, hand);
	}
	
	protected ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand) {
		return ActionResult.pass(player.getItemInHand(hand));
	}
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
		if (attacker instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) attacker;
			IBloodCapability bloodHandler = CapabilityUtil.getBloodCapability(serverPlayer);
			if (!bloodHandler.shouldDamage(this, RuneUseType.HIT)) {
				bloodHandler.reduceBlood(this.runeType.getHitCost(), true);
				return this.hurtEnemyWithRune(itemStack, attacker, target);
			} else {
				float f = this.runeType.getHitCost();
				serverPlayer.hurt(ModDamageSources.RUNE, f / 100);
				return this.hurtEnemyWithRune(itemStack, attacker, target);
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
		return false;
	}

}
