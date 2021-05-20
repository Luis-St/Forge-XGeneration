package net.luis.industry.api.world;

import net.luis.industry.init.items.ModItems;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class GlassHelper {
	
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
		default: return Items.GLASS;
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
		default: return ModItems.GLASS_SHARD.get();
		}
	}

}
