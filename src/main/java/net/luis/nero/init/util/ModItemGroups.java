package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {
	
	public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab(Nero.MOD_ID + "_building_blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlockItems.DEEPSLATE.get());
		}
	};
	public static final CreativeModeTab DECORATIONS = new CreativeModeTab(Nero.MOD_ID + "_decorations") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.PEONY);
		}
	};
	public static final CreativeModeTab REDSTONE = new CreativeModeTab(Nero.MOD_ID + "_redstone") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.REDSTONE);
		}
	};
	public static final CreativeModeTab TRANSPORTATION = new CreativeModeTab(Nero.MOD_ID + "_transportation") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.POWERED_RAIL);
		}
	};
	public static final CreativeModeTab MISC = new CreativeModeTab(Nero.MOD_ID + "_miscellaneous") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.LAVA_BUCKET);
		}
	};
	public static final CreativeModeTab FOOD = new CreativeModeTab(Nero.MOD_ID + "_food") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.APPLE);
		}
	};
	public static final CreativeModeTab TOOLS = new CreativeModeTab(Nero.MOD_ID + "_tools") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.IRON_AXE);
		}
	};
	public static final CreativeModeTab COMBAT = new CreativeModeTab(Nero.MOD_ID + "_combat") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.GOLDEN_SWORD);
		}
	};
	public static final CreativeModeTab BREWING = new CreativeModeTab(Nero.MOD_ID + "_brewing") {
		@Override
		public ItemStack makeIcon() {
			return Items.POTION.getDefaultInstance();
		}
	};
	public static final CreativeModeTab BLOOD_MACIC = new CreativeModeTab(Nero.MOD_ID + "_blood_magic") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.APPRENTICE_BLOOD_ORB.get());
		}
	};

}
