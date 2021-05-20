package net.luis.industry.common.item;

import net.luis.industry.Industry;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;

public class GlassShardItem extends Item {
	
	private final DyeColor color;
	
	public GlassShardItem(DyeColor color) {
		super(new Item.Properties().tab(Industry.MISC));
		this.color = color;
	}

	public DyeColor getColor() {
		return color;
	}

}
