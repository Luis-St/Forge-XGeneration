package net.luis.industry.api.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStackHolder {
	
	private final Item item;
	private final int count;
	
	public ItemStackHolder(Item item, int count) {
		this.item = item;
		this.count = count;
		
	}
	
	public ItemStackHolder(ItemStack itemStack) {
		this(itemStack.getItem(), itemStack.getCount());
	}
	
	public int getCount() {
		return count;
	}
	
	public Item getItem() {
		return item;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof ItemStackHolder)) {
			return false;
		}
		
		ItemStackHolder itemHolder = (ItemStackHolder) obj;
		return itemHolder.getCount() == this.getCount() && itemHolder.getItem() == this.getItem();
		
	}
	
	public static List<ItemStackHolder> fromItemStackList(List<ItemStack> itemStacks) {
		
		List<ItemStackHolder> stackHolders = new ArrayList<ItemStackHolder>();
		
		for (ItemStack itemStack : itemStacks) {
			
			ItemStackHolder itemStackHolder = new ItemStackHolder(itemStack);
			stackHolders.add(itemStackHolder);
			
		}
		
		return stackHolders;
		
	}
	
}
