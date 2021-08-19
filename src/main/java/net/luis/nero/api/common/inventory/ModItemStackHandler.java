package net.luis.nero.api.common.inventory;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ModItemStackHandler extends ItemStackHandler implements IModItemHandler {
	
	public ModItemStackHandler() {
		this(1);
	}
	
	public ModItemStackHandler(int size) {
		this(NonNullList.withSize(size, ItemStack.EMPTY));
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
			if (IModItemHandler.equalItemStack(ItemStack.EMPTY, itemStack)) {
				empty = true;
				break;
			}
		}
		return empty;
	}
	
	public void clearSlot(int slot) {
		this.validateSlotIndex(slot);
		this.setStackInSlot(slot, ItemStack.EMPTY);
	}
	
	public boolean hasItem(ItemStack itemStack) {
		boolean contains = false;
		for (ItemStack stack : this.stacks) {
			if (IModItemHandler.equalItemStack(stack, itemStack)) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	public boolean hasItems(List<ItemStack> itemStacks) {
		boolean contains = true;
		for (ItemStack itemStack : itemStacks) {
			if (!this.hasItem(itemStack)) {
				contains = false;
				break;
			}
		}
		return contains;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		for (ItemStack itemStack : this.stacks) {
			if (!IModItemHandler.equalItemStack(ItemStack.EMPTY, itemStack)) {
				empty = false;
			}
		}
		return empty;
	}
	
}
