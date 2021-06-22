package net.luis.nero.api.recipe.item;

import java.util.concurrent.ThreadLocalRandom;

import net.luis.nero.api.util.Chance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResultItemStack {
	
	protected final Item item;
	protected final int min;
	protected final int max;
	protected final Chance chance;
	
	public static final ResultItemStack EMPTY = new ResultItemStack(ItemStack.EMPTY, Chance.NULL);
	
	public ResultItemStack(Item item, int chance) {
		this(item, 1, chance);
	}
	
	public ResultItemStack(Item item, int min, int max, int chance) {
		this(item, min, max, new Chance(chance));
	}
	
	public ResultItemStack(Item item, int count, int chance) {
		this(item, count, count, new Chance(chance));
	}
	
	public ResultItemStack(ItemStack itemStack, int chance) {
		this(itemStack, new Chance(chance));
	}
	
	public ResultItemStack(ItemStack itemStack, Chance chance) {
		this(itemStack.getItem(), itemStack.getCount(), itemStack.getCount(), chance);
	}
	
	protected ResultItemStack(Item item, int min, int max, Chance chance) {
		this.item = item;
		this.min = min;
		this.max = max;
		this.chance = chance;
	}
	
	protected Chance getChance() {
		return this.chance;
	}
	
	protected int getMin() {
		return this.min;
	}
	
	protected int getMax() {
		return this.max;
	}

	public ItemStack getItemStack() {
		int count = this.max > this.min ? ThreadLocalRandom.current().nextInt(this.min, this.max + 1) : min;
		return new ItemStack(this.item, count);
	}

	public boolean isResult() {
		return this.chance.getChance();
	}
	
	public boolean equals(ResultItemStack resultStack, boolean ignoreTags, boolean ignoreChance) {
		if (resultStack.getItemStack().getItem() == this.getItemStack().getItem()) {
			if (resultStack.getItemStack().getCount() >= this.getItemStack().getCount() || ignoreTags) {
				return resultStack.getChance().equals(this.getChance()) || ignoreChance;
			}
		}
		return false;
	}

}
