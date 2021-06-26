package net.luis.nero.api.common.inventory;

import net.minecraft.item.ItemStack;

public class InventorySlot {
	
	protected final ItemStack itemStack;
	protected final int slot;
	
	public InventorySlot(ItemStack itemStack, int slot) {
		this.itemStack = itemStack;
		this.slot = slot;
	}
	
	public ItemStack getItemStack() {
		return itemStack;
	}
	
	public int getSlot() {
		return slot;
	}

}
