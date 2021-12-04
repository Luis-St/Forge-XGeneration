package net.luis.nero.init.block.item;

import net.luis.nero.Nero;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.util.ModItemGroups;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nero.MOD_ID);
	
	
	public static final RegistryObject<BlockItem> DEEPSLATE_WALL = ITEMS.register("deepslate_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_WALL.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> DEEPSLATE_STAIRS = ITEMS.register("deepslate_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_STAIRS.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> DEEPSLATE_SLAB = ITEMS.register("deepslate_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_SLAB.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> DRIFT_SAND = ITEMS.register("drift_sand",
			() -> new BlockItem(ModBlocks.DRIFT_SAND.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> SCORCHED_SAND = ITEMS.register("scorched_sand",
			() -> new BlockItem(ModBlocks.SCORCHED_SAND.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> TERMITE_MOUND = ITEMS.register("termite_mound",
			() -> new BlockItem(ModBlocks.TERMITE_MOUND.get(), new Item.Properties().tab(ModItemGroups.BUILDING_BLOCKS)));

}
