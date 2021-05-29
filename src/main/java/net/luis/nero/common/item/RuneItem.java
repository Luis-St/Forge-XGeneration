package net.luis.nero.common.item;

import java.util.ArrayList;
import java.util.List;

import net.luis.nero.api.capability.CapabilityUtil;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.item.IRuneType;
import net.luis.nero.api.item.RuneUseType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public abstract class RuneItem extends Item {
	
	private final IRuneType runeType;

	public RuneItem(IRuneType runeType, Properties properties) {
		super(properties);
		this.runeType = runeType;
	}

	public IRuneType getRuneType() {
		return this.runeType;
	}
	
	protected List<ItemStack> getOrbs(ServerPlayerEntity serverPlayer) {
		IItemHandler itemHandler = serverPlayer.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(NullPointerException::new);
		List<ItemStack> orbs = new ArrayList<ItemStack>();
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			ItemStack itemStack = itemHandler.getStackInSlot(i);
			if (itemStack.getItem() instanceof OrbItem) {
				orbs.add(itemStack);
			}
		}
		return orbs;
	}
	
	public abstract DamageSource getDamageSource();
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			List<ItemStack> orbs = this.getOrbs(serverPlayer);
			if (orbs.isEmpty() || orbs.size() > 1) {
				
			} else {
				IBloodOrbCapability bloodHandler = CapabilityUtil.getBloodOrbCapability(orbs.get(0));
				if (!bloodHandler.shouldDamage(this, RuneUseType.USE)) {
					bloodHandler.reduceBlood(this.runeType.getUseCost(), true);
					return this.useRune(world, serverPlayer, hand);
				} else {
					float f = this.runeType.getUseCost();
					serverPlayer.hurt(this.getDamageSource(), f / 100);
					return this.useRune(world, serverPlayer, hand);
				}
			}
		}
		return super.use(world, player, hand);
	}
	
	protected abstract ActionResult<ItemStack> useRune(World world, ServerPlayerEntity player, Hand hand);
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
		if (attacker instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) attacker;
			List<ItemStack> orbs = this.getOrbs(serverPlayer);
			if (orbs.isEmpty() || orbs.size() > 1) {
				
			} else {
				IBloodOrbCapability bloodHandler = CapabilityUtil.getBloodOrbCapability(orbs.get(0));
				if (!bloodHandler.shouldDamage(this, RuneUseType.HIT)) {
					bloodHandler.reduceBlood(this.runeType.getHitCost(), true);
					return this.hurtEnemyWithRune(itemStack, serverPlayer, target);
				} else {
					float f = this.runeType.getHitCost();
					serverPlayer.hurt(this.getDamageSource(), f / 100);
					return this.hurtEnemyWithRune(itemStack, serverPlayer, target);
				}
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected abstract boolean hurtEnemyWithRune(ItemStack itemStack, ServerPlayerEntity attacker, LivingEntity target);

}
