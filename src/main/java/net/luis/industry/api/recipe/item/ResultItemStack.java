package net.luis.industry.api.recipe.item;

import net.luis.industry.api.util.Chance;
import net.minecraft.item.ItemStack;

public class ResultItemStack {
	
	private final ItemStack itemStack;
	private final Chance chance;
	
	public ResultItemStack(ItemStack itemStack, int chance) {
		this(itemStack, new Chance(chance));
	}
	
	public ResultItemStack(ItemStack itemStack, Chance chance) {
		this.itemStack = itemStack;
		this.chance = chance;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public boolean getChance() {
		return this.chance.getChance();
	}

}
