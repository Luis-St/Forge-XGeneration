package net.luis.nero.common.item.rune;

import java.util.ArrayList;
import java.util.List;

import net.luis.nero.api.capability.CapabilityUtil;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.item.IRuneType;
import net.luis.nero.api.item.RuneUseType;
import net.luis.nero.common.item.OrbItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public abstract class AbstractRuneItem extends Item {
	
	private final IRuneType runeType;

	public AbstractRuneItem(IRuneType runeType, Properties properties) {
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
	
	protected void sendMessage(ServerPlayerEntity serverPlayer, String message) {
		serverPlayer.sendMessage(new StringTextComponent(message), serverPlayer.getUUID());
	}
	
	public abstract DamageSource getDamageSource();
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			List<ItemStack> orbs = this.getOrbs(serverPlayer);
			if (orbs.isEmpty()) {
				this.sendMessage(serverPlayer, "You need a Blood Orb");
			} else if (orbs.size() > 1) {
				this.sendMessage(serverPlayer, "You can only use one Blood Orb");
			} else {
				IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbs.get(0));
				if (this.runeType.getUseCost() > 0) {
					if (!bloodOrbHandler.shouldDamage(this, RuneUseType.USE)) {
						bloodOrbHandler.reduceBlood(this.runeType.getUseCost(), true);
						return this.useRune(world, serverPlayer, hand, orbs.get(0));
					} else {
						float f = this.runeType.getUseCost();
						serverPlayer.hurt(this.getDamageSource(), f / 100);
						return this.useRune(world, serverPlayer, hand, orbs.get(0));
					}
				} else {
					return this.useRune(world, serverPlayer, hand, orbs.get(0));
				}
			}
		}
		return super.use(world, player, hand);
	}
	
	protected abstract ActionResult<ItemStack> useRune(World world, ServerPlayerEntity serverPlayer, Hand hand, ItemStack orbStack);
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
		if (attacker instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) attacker;
			List<ItemStack> orbs = this.getOrbs(serverPlayer);
			if (orbs.isEmpty()) {
				this.sendMessage(serverPlayer, "You need a Blood Orb");
			} else if (orbs.size() > 1) {
				this.sendMessage(serverPlayer, "You can only use one Blood Orb");
			} else {
				IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbs.get(0));
				if (this.runeType.getHitCost() > 0) {
					if (!bloodOrbHandler.shouldDamage(this, RuneUseType.HIT)) {
						bloodOrbHandler.reduceBlood(this.runeType.getHitCost(), true);
						return this.hurtEnemyWithRune(itemStack, serverPlayer, target, orbs.get(0));
					} else {
						float f = this.runeType.getHitCost();
						serverPlayer.hurt(this.getDamageSource(), f / 100);
						return this.hurtEnemyWithRune(itemStack, serverPlayer, target, orbs.get(0));
					}
				} else {
					return this.hurtEnemyWithRune(itemStack, serverPlayer, target, orbs.get(0));
				}
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected abstract boolean hurtEnemyWithRune(ItemStack itemStack, ServerPlayerEntity attacker, LivingEntity target, ItemStack orbStack);

}
