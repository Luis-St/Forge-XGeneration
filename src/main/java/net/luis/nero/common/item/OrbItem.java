package net.luis.nero.common.item;

import net.luis.nero.api.common.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.common.capability.provider.BloodOrbCapabilityProvider;
import net.luis.nero.api.common.capability.util.CapabilityUtil;
import net.luis.nero.api.common.item.IOrbType;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class OrbItem extends Item {
	
	private final IOrbType orbType;
	
	public OrbItem(IOrbType orbType, Properties properties) {
		super(properties);
		this.orbType = orbType;
	}
	
	public IOrbType getOrbType() {
		return this.orbType;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		double blood = CapabilityUtil.getBloodOrbCapability(stack).getBlood();
		double bloodCapability = this.orbType.getBloodCapacity();
		return 1 - (blood / bloodCapability);
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		boolean isOrbItem = stack.getItem() instanceof OrbItem;
		boolean isNotEmpty = CapabilityUtil.getBloodOrbCapability(stack).hasBlood();
		return isOrbItem && isNotEmpty;
	}
	
	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return 11796480;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		IBloodOrbCapability bloodCapability = CapabilityUtil.getBloodOrbCapability(player.getItemInHand(hand));
		if (this.hasMore(player)) {
			if (player instanceof ServerPlayer) {
				player.sendMessage(new TextComponent("You can only use one Blood Orb"), player.getUUID());
			}
		} else {
			if (!bloodCapability.hasMaxBlood(this)) {
				if (player.isCreative()) {
					bloodCapability.addBlood(this, this.orbType.getBloodCapacity());
				} else {
					bloodCapability.addBlood(this, 500);
					player.hurt(ModDamageSources.ORB, 2.0F);
				}
				return InteractionResultHolder.success(player.getItemInHand(hand));
			}
		}
		return super.use(level, player, hand);
	}
	
	protected boolean hasMore(Player player) {
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(NullPointerException::new);
		int orbItems = 0;
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			Item item = itemHandler.getStackInSlot(i).getItem();
			if (item instanceof OrbItem) {
				orbItems++;
			}
		}
		return orbItems > 1;
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
		return new BloodOrbCapabilityProvider();
	}
	
}
