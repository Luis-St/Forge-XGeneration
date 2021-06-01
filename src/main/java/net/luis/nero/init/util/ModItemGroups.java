package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroups {
	
	public static final ItemGroup BUILDING_BLOCKS = new ItemGroup(Nero.MOD_ID + "_building_blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlockItems.DEEPSLATE.get());
		}
	};
	public static final ItemGroup DECORATIONS = new ItemGroup(Nero.MOD_ID + "_decorations") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.PEONY);
		}
	};
	public static final ItemGroup REDSTONE = new ItemGroup(Nero.MOD_ID + "_redstone") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.REDSTONE);
		}
	};
	public static final ItemGroup TRANSPORTATION = new ItemGroup(Nero.MOD_ID + "_transportation") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.POWERED_RAIL);
		}
	};
	public static final ItemGroup MISC = new ItemGroup(Nero.MOD_ID + "_miscellaneous") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.LAVA_BUCKET);
		}
	};
	public static final ItemGroup FOOD = new ItemGroup(Nero.MOD_ID + "_food") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.APPLE);
		}
	};
	public static final ItemGroup TOOLS = new ItemGroup(Nero.MOD_ID + "_tools") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.IRON_AXE);
		}
	};
	public static final ItemGroup COMBAT = new ItemGroup(Nero.MOD_ID + "_combat") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.GOLDEN_SWORD);
		}
	};
	public static final ItemGroup BREWING = new ItemGroup(Nero.MOD_ID + "_brewing") {
		@Override
		public ItemStack makeIcon() {
			return Items.POTION.getDefaultInstance();
		}
	};
	public static final ItemGroup BLOOD_MACIC = new ItemGroup(Nero.MOD_ID + "_blood_magic") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.APPRENTICE_BLOOD_ORB.get());
		}
	};

}
