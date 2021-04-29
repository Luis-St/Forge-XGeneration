package net.luis.industry.api.recipe.item;

import java.util.concurrent.ThreadLocalRandom;

import net.luis.industry.api.util.Chance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResultItemStack {
	
	protected final ItemStack itemStack;
	protected final Chance chance;
	
	public static final ResultItemStack DUMMY = new ResultItemStack(ItemStack.EMPTY, Chance.DUMMY);
	
	public ResultItemStack(Item item, int chance) {
		this(new ItemStack(item, 1), chance);
	}
	
	public ResultItemStack(Item item, int count, int chance) {
		this(new ItemStack(item, count), chance);
	}
	
	public ResultItemStack(Item item, int min, int max, int chance) {
		this(new ItemStack(item, ThreadLocalRandom.current().nextInt(min, max + 1)), chance);
	}
	
	public ResultItemStack(ItemStack itemStack, int chance) {
		this(itemStack, new Chance(chance));
	}
	
	protected ResultItemStack(ItemStack itemStack, Chance chance) {
		this.itemStack = itemStack;
		this.chance = chance;
	}
	
	protected Chance getChance() {
		return this.chance;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public boolean isResult() {
		return this.chance.getChance();
	}
	
	public boolean equals(ResultItemStack resultStack, boolean ignoreTags, boolean ignoreChance) {
		if (resultStack.getItemStack().getItem() == this.getItemStack().getItem()) {
			if (resultStack.getItemStack().getCount() == this.getItemStack().getCount() || ignoreTags) {
				return resultStack.getChance().equals(this.getChance()) || ignoreChance;
			}
		}
		return false;
	}

}
