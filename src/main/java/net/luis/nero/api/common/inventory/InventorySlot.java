package net.luis.nero.api.common.inventory;

import net.minecraft.item.ItemStack;

public class InventorySlot {
	
	private final ItemStack itemStack;
	private final int slot;
	
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
