package net.luis.nero.api.common.recipe;

import net.luis.nero.init.items.ModItems;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ItemHelper {
	
	public static Item glassBlockFromColor(DyeColor color) {
		switch (color) {
		case BLACK: return Items.BLACK_STAINED_GLASS;
		case BLUE: return Items.BLUE_STAINED_GLASS;
		case BROWN: return Items.BROWN_STAINED_GLASS;
		case CYAN: return Items.CYAN_STAINED_GLASS;
		case GRAY: return Items.GRAY_STAINED_GLASS;
		case GREEN: return Items.GREEN_STAINED_GLASS;
		case LIGHT_BLUE: return Items.LIGHT_BLUE_STAINED_GLASS;
		case LIGHT_GRAY: return Items.LIGHT_GRAY_STAINED_GLASS;
		case LIME: return Items.LIME_STAINED_GLASS;
		case MAGENTA: return Items.MAGENTA_STAINED_GLASS;
		case ORANGE: return Items.ORANGE_STAINED_GLASS;
		case PINK: return Items.PINK_STAINED_GLASS;
		case PURPLE: return Items.PURPLE_STAINED_GLASS;
		case RED: return Items.RED_STAINED_GLASS;
		case WHITE: return Items.WHITE_STAINED_GLASS;
		case YELLOW: return Items.YELLOW_STAINED_GLASS;
		default: throw new IllegalArgumentException();
		}
	}
	
	public static Item glassPaneFromColor(DyeColor color) {
		switch (color) {
		case BLACK: return Items.BLACK_STAINED_GLASS_PANE;
		case BLUE: return Items.BLUE_STAINED_GLASS_PANE;
		case BROWN: return Items.BROWN_STAINED_GLASS_PANE;
		case CYAN: return Items.CYAN_STAINED_GLASS_PANE;
		case GRAY: return Items.GRAY_STAINED_GLASS_PANE;
		case GREEN: return Items.GREEN_STAINED_GLASS_PANE;
		case LIGHT_BLUE: return Items.LIGHT_BLUE_STAINED_GLASS_PANE;
		case LIGHT_GRAY: return Items.LIGHT_GRAY_STAINED_GLASS_PANE;
		case LIME: return Items.LIME_STAINED_GLASS_PANE;
		case MAGENTA: return Items.MAGENTA_STAINED_GLASS_PANE;
		case ORANGE: return Items.ORANGE_STAINED_GLASS_PANE;
		case PINK: return Items.PINK_STAINED_GLASS_PANE;
		case PURPLE: return Items.PURPLE_STAINED_GLASS_PANE;
		case RED: return Items.RED_STAINED_GLASS_PANE;
		case WHITE: return Items.WHITE_STAINED_GLASS_PANE;
		case YELLOW: return Items.YELLOW_STAINED_GLASS_PANE;
		default: throw new IllegalArgumentException();
		}
	}
	
	public static Item glassShardFromColor(DyeColor color) {
		switch (color) {
		case BLACK: return ModItems.BLACK_GLASS_SHARD.get();
		case BLUE: return ModItems.BLUE_GLASS_SHARD.get();
		case BROWN: return ModItems.BROWN_GLASS_SHARD.get();
		case CYAN: return ModItems.CYAN_GLASS_SHARD.get();
		case GRAY: return ModItems.GRAY_GLASS_SHARD.get();
		case GREEN: return ModItems.GREEN_GLASS_SHARD.get();
		case LIGHT_BLUE: return ModItems.LIGHT_BLUE_GLASS_SHARD.get();
		case LIGHT_GRAY: return ModItems.LIGHT_GRAY_GLASS_SHARD.get();
		case LIME: return ModItems.LIME_GLASS_SHARD.get();
		case MAGENTA: return ModItems.MAGENTA_GLASS_SHARD.get();
		case ORANGE: return ModItems.ORANGE_GLASS_SHARD.get();
		case PINK: return ModItems.PINK_GLASS_SHARD.get();
		case PURPLE: return ModItems.PURPLE_GLASS_SHARD.get();
		case RED: return ModItems.RED_GLASS_SHARD.get();
		case WHITE: return ModItems.WHITE_GLASS_SHARD.get();
		case YELLOW: return ModItems.YELLOW_GLASS_SHARD.get();
		default: throw new IllegalArgumentException();
		}
	}

}
