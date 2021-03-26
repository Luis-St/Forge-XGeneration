package net.luis.industry.api.recipe.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeInputItem {
	
	private final ItemStack stack;
	
	public RecipeInputItem(Item item, int count) {
		
		stack = new ItemStack(item, count);
		
	}
	
	public RecipeInputItem(ItemStack itemStack) {
		
		stack = itemStack;
		
	}

	public ItemStack getStack() {
		
		return stack;
		
	}
	
}
