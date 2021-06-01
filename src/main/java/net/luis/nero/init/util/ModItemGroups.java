package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroups {
	
	public static final ItemGroup BUILDING_BLOCKS = registerItemGroup("building_blocks", ModBlockItems.DEEPSLATE.get());
	public static final ItemGroup DECORATIONS = registerItemGroup("decorations", Items.PEONY);
	public static final ItemGroup REDSTONE = registerItemGroup("redstone", Items.REDSTONE);
	public static final ItemGroup TRANSPORTATION = registerItemGroup("transportation", Items.POWERED_RAIL);
	public static final ItemGroup MISC = registerItemGroup("miscellaneous", Items.LAVA_BUCKET);
	public static final ItemGroup FOOD = registerItemGroup("food", Items.APPLE);
	public static final ItemGroup COMBAT = registerItemGroup("tools", Items.IRON_AXE);
	public static final ItemGroup TOOLS = registerItemGroup("combat", Items.GOLDEN_SWORD);
	public static final ItemGroup BREWING = registerItemGroup("brewing", Items.POTION.getDefaultInstance());
	public static final ItemGroup BLOOD_MACIC = registerItemGroup("blood_magic", ModItems.APPRENTICE_BLOOD_ORB.get());
	
	private static ItemGroup registerItemGroup(String name, Item icon) {
		return registerItemGroup(name, new ItemStack(icon));
	}
	
	private static ItemGroup registerItemGroup(String name, ItemStack icon) {
		return new ItemGroup(Nero.MOD_ID + "_" + name) {
			@Override
			public ItemStack makeIcon() {
				return icon;
			}
		};
	}

}
