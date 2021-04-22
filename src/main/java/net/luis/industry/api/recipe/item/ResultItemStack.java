package net.luis.industry.api.recipe.item;

import net.luis.industry.api.util.Chance;
import net.minecraft.item.ItemStack;

public class ResultItemStack {
	
	private ItemStack itemStack;
	private Chance chance;
	
	public static final ResultItemStack DUMMY = new ResultItemStack(ItemStack.EMPTY, 0);
	
	public ResultItemStack(ItemStack itemStack, int chance) {
		this(itemStack, new Chance(chance));
	}
	
	public ResultItemStack(ItemStack itemStack, Chance chance) {
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
