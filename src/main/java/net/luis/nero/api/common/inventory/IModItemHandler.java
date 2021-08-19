package net.luis.nero.api.common.inventory;

import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public interface IModItemHandler extends IItemHandler, IItemHandlerModifiable, INBTSerializable<CompoundTag>, Container {
	
	List<ItemStack> getStacks();
	
	boolean isSlotEmpty(int slot);
	
	boolean hasEmptySlots();
	
	default List<ItemStack> getAndClearSlots() {
		List<ItemStack> inventory = this.getStacks();
		this.clearSlots();
		return inventory;
	}
	
	default void clearSlots() {
		for (int slot = 0; slot < this.getSlots(); slot++) {
			this.setStackInSlot(slot, ItemStack.EMPTY);
		}
	}
	
	void clearSlot(int slot);
	
	boolean hasItem(ItemStack itemStack);
	
	@Override
	default void clearContent() {
		this.clearSlots();
	}
	
	@Override
	default int getContainerSize() {
		return this.getSlots();
	}
	
	boolean isEmpty();
	
	@Override
	default ItemStack getItem(int slot) {
		return this.getStackInSlot(slot);
	}

	@Override
	default ItemStack removeItem(int slot, int count) {
		return this.extractItem(slot, count, false);
	}

	@Override
	default ItemStack removeItemNoUpdate(int count) {
		throw new UnsupportedOperationException();
	}

	@Override
	default void setItem(int slot, ItemStack itemStack) {
		this.insertItem(slot, itemStack, false);
	}

	@Override
	default void setChanged() {
		throw new UnsupportedOperationException();
	}

	@Override
	default boolean stillValid(Player player) {
		return true;
	}
	
	static boolean equalItemStack(ItemStack itemStack, ItemStack toCheck) {
		if (itemStack.isEmpty()) {
			return toCheck.isEmpty();
		}
		return itemStack.getItem() == toCheck.getItem();
	}
	
}
