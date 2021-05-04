package net.luis.industry.init.block.item;

import static net.luis.industry.Industry.INDUSTRY_BLOCKS;
import static net.luis.industry.Industry.INDUSTRY_DEEPSLATE;
import static net.luis.industry.Industry.MOD_ID;

import net.luis.industry.init.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
	
	public static final RegistryObject<Item> FLUID_PIPE = ITEMS.register("fluid_pipe", 
			() -> new BlockItem(ModBlocks.FLUID_PIPE.get(), new Item.Properties().tab(INDUSTRY_BLOCKS)));
	
	public static final RegistryObject<Item> MILESTONE = ITEMS.register("milestone", 
			() -> new BlockItem(ModBlocks.MILESTONE.get(), new Item.Properties().tab(INDUSTRY_BLOCKS)));
	
	public static final RegistryObject<Item> DEEPSLATE = ITEMS.register("deepslate", 
			() -> new BlockItem(ModBlocks.DEEPSLATE.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> COBBLED_DEEPSLATE = ITEMS.register("cobbled_deepslate", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> POLISHED_DEEPSLATE = ITEMS.register("polished_deepslate", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_BRICKS = ITEMS.register("deepslate_bricks", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICKS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> CRACKED_DEEPSLATE_BRICKS = ITEMS.register("cracked_deepslate_bricks", 
			() -> new BlockItem(ModBlocks.CRACKED_DEEPSLATE_BRICKS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_TILES = ITEMS.register("deepslate_tiles", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILES.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> CRACKED_DEEPSLATE_TILES = ITEMS.register("cracked_deepslate_tiles", 
			() -> new BlockItem(ModBlocks.CRACKED_DEEPSLATE_TILES.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> CHISELED_DEEPSLATE = ITEMS.register("chiseled_deepslate", 
			() -> new BlockItem(ModBlocks.CHISELED_DEEPSLATE.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> COBBLED_DEEPSLATE_WALL = ITEMS.register("cobbled_deepslate_wall", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_WALL.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_WALL = ITEMS.register("deepslate_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_WALL.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> POLISHED_DEEPSLATE_WALL = ITEMS.register("polished_deepslate_wall", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_WALL.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_BRICK_WALL = ITEMS.register("deepslate_brick_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_WALL.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_TILE_WALL = ITEMS.register("deepslate_tile_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_WALL.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> COBBLED_DEEPSLATE_STAIRS = ITEMS.register("cobbled_deepslate_stairs", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_STAIRS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_STAIRS = ITEMS.register("deepslate_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_STAIRS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> POLISHED_DEEPSLATE_STAIRS = ITEMS.register("polished_deepslate_stairs", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_STAIRS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_BRICK_STAIRS = ITEMS.register("deepslate_brick_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_STAIRS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_TILE_STAIRS = ITEMS.register("deepslate_tile_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_STAIRS.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> COBBLED_DEEPSLATE_SLAB = ITEMS.register("cobbled_deepslate_slab", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_SLAB.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_SLAB = ITEMS.register("deepslate_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_SLAB.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> POLISHED_DEEPSLATE_SLAB = ITEMS.register("polished_deepslate_slab", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_SLAB.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_BRICK_SLAB = ITEMS.register("deepslate_brick_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));
	
	public static final RegistryObject<Item> DEEPSLATE_TILE_SLAB = ITEMS.register("deepslate_tile_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_SLAB.get(), new Item.Properties().tab(INDUSTRY_DEEPSLATE)));

}
