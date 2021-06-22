package net.luis.nero.common.item;

import net.luis.nero.api.capability.CapabilityUtil;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.api.capability.provider.BloodOrbCapabilityProvider;
import net.luis.nero.api.common.item.IOrbType;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
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
		double bloodCapability = this.orbType.getBloodCapability();
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
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		IBloodOrbCapability bloodCapability = CapabilityUtil.getBloodOrbCapability(player.getItemInHand(hand));
		if (this.hasMore(player)) {
			if (player instanceof ServerPlayerEntity) {
				player.sendMessage(new StringTextComponent("You can only use one Blood Orb"), player.getUUID());
			}
		} else {
			if (!bloodCapability.hasMaxBlood(this)) {
				if (player.isCreative()) {
					bloodCapability.addBlood(this, this.orbType.getBloodCapability());
				} else {
					bloodCapability.addBlood(this, 500);
					player.hurt(ModDamageSources.ORB, 2.0F);
				}
				return ActionResult.success(player.getItemInHand(hand));
			}
		}
		return super.use(world, player, hand);
	}
	
	protected boolean hasMore(PlayerEntity player) {
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
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
		return new BloodOrbCapabilityProvider();
	}
	
}
