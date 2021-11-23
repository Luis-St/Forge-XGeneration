 package net.luis.nero.common.item;

import java.util.ArrayList;
import java.util.List;

import net.luis.nero.common.capability.CapabilityUtil;
import net.luis.nero.common.capability.orb.IBloodOrbCapability;
import net.luis.nero.common.enums.RuneUseType;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
	
	protected ItemStack getOrbItem(Player player) {
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
	
	protected boolean hasBloodOrShouldDamage(Player player, ItemStack orbStack, int bloodCost, RuneUseType useType) {
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
	
	protected void sendMessage(Player player, String message) {
		if (player instanceof ServerPlayer) {
			player.sendMessage(new TextComponent(message), player.getUUID());
		}
	}
	
	protected InteractionResultHolder<ItemStack> success(Player player, InteractionHand hand) {
		return InteractionResultHolder.success(player.getItemInHand(hand));
	}
	
	protected InteractionResultHolder<ItemStack> pass(Player player, InteractionHand hand) {
		return InteractionResultHolder.pass(player.getItemInHand(hand));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack orbStack = this.getOrbItem(player);
		if (!orbStack.isEmpty()) {
			if (this.hasBloodOrShouldDamage(player, orbStack, this.runeType.getUseCost(), RuneUseType.USE)) {
				return this.useRune(level, player, hand, orbStack);
			}
		}
		return super.use(level, player, hand);
	}
	
	protected abstract InteractionResultHolder<ItemStack> useRune(Level level, Player player, InteractionHand hand, ItemStack orbStack);
	
	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
		if (attacker instanceof Player) {
			Player player = (Player) attacker;
			ItemStack orbStack = this.getOrbItem(player);
			if (!orbStack.isEmpty()) {
				if (this.hasBloodOrShouldDamage(player, orbStack, this.runeType.getHitCost(), RuneUseType.HIT)) {
					this.hurtEnemyWithRune(itemStack, target, player, orbStack);
				}
			}
		}
		return super.hurtEnemy(itemStack, attacker, target);
	}
	
	protected abstract boolean hurtEnemyWithRune(ItemStack itemStack, LivingEntity target, Player attacker, ItemStack orbStack);

}
