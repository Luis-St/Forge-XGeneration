package net.luis.nero.common.item;

import net.luis.nero.init.util.ModItemGroups;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;

public class GlassShardItem extends Item {
	
	private final DyeColor color;
	
	public GlassShardItem(DyeColor color) {
		super(new Item.Properties().tab(ModItemGroups.MISC));
		this.color = color;
	}

	public DyeColor getColor() {
		return color;
	}

}