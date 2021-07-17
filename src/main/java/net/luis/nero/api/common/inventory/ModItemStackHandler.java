package net.luis.nero.api.common.inventory;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class ModItemStackHandler extends ItemStackHandler implements IInventory {
	
	public ModItemStackHandler() {
		this(1);
	}
	
	public ModItemStackHandler(int size) {
		this.stacks = NonNullList.withSize(size, ItemStack.EMPTY);
	}
	
	protected ModItemStackHandler(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}
	
	public List<ItemStack> getStacks() {
		List<ItemStack> inventory = new ArrayList<>();
		for (ItemStack itemStack : this.stacks) {
			inventory.add(itemStack);
		}
		return inventory;
	}
	
	public boolean isSlotEmpty(int slot) {
		this.validateSlotIndex(slot);
		return this.getStackInSlot(slot).isEmpty();
	}
	
	public boolean hasEmptySlots() {
		boolean empty = false;
		for (ItemStack itemStack : this.stacks) {
			if (this.equalItemStack(ItemStack.EMPTY, itemStack)) {
				empty = true;
				break;
			}
		}
		return empty;
	}
	
	public List<ItemStack> getAndClearSlots() {
		List<ItemStack> inventory = this.getStacks();
		this.clearSlots();
		return inventory;
	}
	
	public void clearSlots() {
		for (int slot = 0; slot < this.getSlots(); slot++) {
			this.setStackInSlot(slot, ItemStack.EMPTY);
		}
	}
	
	public void clearSlot(int slot) {
		this.validateSlotIndex(slot);
		this.setStackInSlot(slot, ItemStack.EMPTY);
	}
	
	public boolean hasItem(ItemStack itemStack) {
		boolean contains = false;
		for (ItemStack stack : this.stacks) {
			if (this.equalItemStack(stack, itemStack)) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	private boolean equalItemStack(ItemStack itemStack, ItemStack toCheck) {
		if (itemStack.isEmpty()) {
			return toCheck.isEmpty();
		}
		if (itemStack.getItem() == toCheck.getItem()) {
			return toCheck.getCount() >= itemStack.getCount();
		}
		return false;
	}
	// TODO: impl: methods below:
	@Override
	public void clearContent() {
		
	}

	@Override
	public int getContainerSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack getItem(int slot) {
		return null;
	}

	@Override
	public ItemStack removeItem(int slot, int count) {
		return null;
	}

	@Override
	public ItemStack removeItemNoUpdate(int count) {
		return null;
	}

	@Override
	public void setItem(int slot, ItemStack itemStack) {
		
	}

	@Override
	public void setChanged() {
		
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return true;
	}
	
}
