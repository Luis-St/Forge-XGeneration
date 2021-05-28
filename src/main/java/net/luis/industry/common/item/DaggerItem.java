package net.luis.industry.common.item;

import net.luis.industry.api.capability.CapabilityUtil;
import net.luis.industry.api.capability.interfaces.entity.IBloodCapability;
import net.luis.industry.common.tileentity.BloodAltarTileEntity;
import net.luis.industry.init.util.ModDamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DaggerItem extends Item {

	public DaggerItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			IBloodCapability bloodHandler = CapabilityUtil.getBloodCapability(serverPlayer);
			if (bloodHandler.canBloodAdd(serverPlayer, BloodAltarTileEntity.BloodConstants.HEART)) {
				bloodHandler.addBlood(serverPlayer, BloodAltarTileEntity.BloodConstants.HEART);
				serverPlayer.hurt(ModDamageSources.DAGGER, 1.0F);
				return ActionResult.success(player.getItemInHand(hand));
			}
		}
		return super.use(world, player, hand);
	}

}
