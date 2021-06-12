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
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(NullPointerException::new);
		List<ItemStack> orbItems = new ArrayList<ItemStack>();
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			ItemStack itemStack = itemHandler.getStackInSlot(i);
			if (itemStack.getItem() instanceof OrbItem) {
				orbItems.add(itemStack);
			}
		}
		if (orbItems.isEmpty()) {
			this.sendMessage(player, "You need a Blood Orb");
			return ItemStack.EMPTY;
		} else if (orbItems.size() > 1) {
			this.sendMessage(player, "You can only use one Blood Orb");
			return ItemStack.EMPTY;
		}
		return orbItems.get(0);
	}
	
	protected boolean hasBloodOrShouldDamage(PlayerEntity player, ItemStack orbStack, int bloodCost, RuneUseType useType) {
		IBloodOrbCapability bloodOrbHandler = CapabilityUtil.getBloodOrbCapability(orbStack);
		if (bloodCost > 0) {
			if (bloodOrbHandler.shouldDamage(this, useType)) {
				bloodOrbHandler.reduceBlood(bloodCost, true);
			} else {
				float f = bloodCost;
				player.hurt(ModDamageSources.RUNE, f / 100);
			}
		}
		return true;
	}
	
	protected void sendMessage(PlayerEntity player, String message) {
		if (player instanceof ServerPlayerEntity) {
			player.sendMessage(new StringTextComponent(message), player.getUUID());
		}
	}
	
	protected ActionResult<ItemStack> success(PlayerEntity player, Hand hand) {
		return ActionResult.success(player.getItemInHand(hand));
	}
	
	protected ActionResult<ItemStack> pass(PlayerEntity player, Hand hand) {
		return ActionResult.pass(player.getItemInHand(hand));
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
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
		if (attacker instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) attacker;
			ItemStack orbStack = this.getOrbItem(player);
			if (!orbStack.isEmpty()) {
				if (this.hasBloodOrShouldDamage(player, orbStack, this.runeType.getHitCost(), RuneUseType.HIT)) {
					this.hurtEnemyWithRune(itemStack, target, player, orbStack);
				}
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected abstract boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, PlayerEntity attacker, ItemStack orbStack);

}
