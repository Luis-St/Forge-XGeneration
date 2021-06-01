package net.luis.nero.common.item.rune;

import java.util.ArrayList;
import java.util.List;

import net.luis.nero.api.capability.CapabilityUtil;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.item.IRuneType;
import net.luis.nero.api.item.RuneUseType;
import net.luis.nero.common.item.OrbItem;
import net.luis.nero.init.util.ModDamageSources;
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
	
	protected ItemStack getOrbItem(PlayerEntity player) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			IItemHandler itemHandler = serverPlayer.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(NullPointerException::new);
			List<ItemStack> orbItems = new ArrayList<ItemStack>();
			for (int i = 0; i < itemHandler.getSlots(); i++) {
				ItemStack itemStack = itemHandler.getStackInSlot(i);
				if (itemStack.getItem() instanceof OrbItem) {
					orbItems.add(itemStack);
				}
			}
			if (orbItems.isEmpty()) {
				this.sendMessage(serverPlayer, "You need a Blood Orb");
				return ItemStack.EMPTY;
			} else if (orbItems.size() > 1) {
				this.sendMessage(serverPlayer, "You can only use one Blood Orb");
				return ItemStack.EMPTY;
			} else {
				return orbItems.get(0);
			}
		} else {
			return ItemStack.EMPTY;
		}
	}
	
	protected boolean hasBloodOrShouldDamage(PlayerEntity player, ItemStack orbStack, int bloodCost, RuneUseType useType) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbStack);
			if (bloodCost > 0) {
				if (bloodOrbHandler.shouldDamage(this, useType)) {
					bloodOrbHandler.reduceBlood(bloodCost, true);
					return true;
				} else {
					float f = bloodCost;
					serverPlayer.hurt(this.getDamageSource(), f / 100);
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}
	
	protected void sendMessage(ServerPlayerEntity serverPlayer, String message) {
		serverPlayer.sendMessage(new StringTextComponent(message), serverPlayer.getUUID());
	}
	
	protected ActionResult<ItemStack> success(PlayerEntity player, Hand hand) {
		return ActionResult.success(player.getItemInHand(hand));
	}
	
	public DamageSource getDamageSource() {
		return ModDamageSources.RUNE;
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack orbStack = this.getOrbItem(player);
		if (!orbStack.isEmpty()) {
			if (this.hasBloodOrShouldDamage(player, orbStack, this.runeType.getUseCost(), RuneUseType.USE)) {
				return this.useRune(world, player, hand, orbStack);
			}
		}
		return super.use(world, player, hand);
	}
	
	protected abstract ActionResult<ItemStack> useRune(World world, PlayerEntity player, Hand hand, ItemStack orbStack);
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
		if (attacker instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) attacker;
			ItemStack orbStack = this.getOrbItem(player);
			if (!orbStack.isEmpty()) {
				if (this.hasBloodOrShouldDamage(player, orbStack, this.runeType.getHitCost(), RuneUseType.HIT)) {
					this.hurtEnemyWithRune(itemStack, player, target, orbStack);
				}
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected abstract boolean hurtEnemyWithRune(ItemStack itemStack, PlayerEntity attacker, LivingEntity target, ItemStack orbStack);

}
