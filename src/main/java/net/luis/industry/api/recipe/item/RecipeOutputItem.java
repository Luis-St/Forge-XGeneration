package net.luis.industry.api.recipe.item;

import net.luis.industry.api.util.Chance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeOutputItem {
	
	private final ItemStack stack;
	private final Chance chance;
	
	public RecipeOutputItem(Item item, int count, int chance) {
		
		this.stack = new ItemStack(item, count);
		this.chance = new Chance(chance);
		
	}
	
	public RecipeOutputItem(ItemStack itemStack, int chance) {
		
		this.stack = itemStack;
		this.chance = new Chance(chance);
		
	}

	public ItemStack getStack() {
		
		return stack;
		
	}

	public Chance getChance() {
		
		return this.chance;
		
	}

}
