package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.luis.nero.init.block.item.ModBlockItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {
	
	public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab(Nero.MOD_ID + "_building_blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlockItems.DRIFT_SAND.get());
		}
	};
	public static final CreativeModeTab DECORATIONS = new CreativeModeTab(Nero.MOD_ID + "_decorations") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.PEONY);
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

}
