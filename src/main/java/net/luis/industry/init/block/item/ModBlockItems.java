package net.luis.industry.init.block.item;

import static net.luis.industry.Industry.DECORATIONS;
import static net.luis.industry.Industry.BUILDING_BLOCKS;
import static net.luis.industry.Industry.MOD_ID;

import net.luis.industry.init.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
	
	public static final RegistryObject<BlockItem> FLUID_PIPE = ITEMS.register("fluid_pipe", 
			() -> new BlockItem(ModBlocks.FLUID_PIPE.get(), new Item.Properties().tab(DECORATIONS)));
	
	public static final RegistryObject<BlockItem> MILESTONE = ITEMS.register("milestone", 
			() -> new BlockItem(ModBlocks.MILESTONE.get(), new Item.Properties().tab(DECORATIONS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE = ITEMS.register("deepslate", 
			() -> new BlockItem(ModBlocks.DEEPSLATE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE = ITEMS.register("cobbled_deepslate", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE = ITEMS.register("polished_deepslate", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_BRICKS = ITEMS.register("deepslate_bricks", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICKS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> CRACKED_DEEPSLATE_BRICKS = ITEMS.register("cracked_deepslate_bricks", 
			() -> new BlockItem(ModBlocks.CRACKED_DEEPSLATE_BRICKS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_TILES = ITEMS.register("deepslate_tiles", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILES.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> CRACKED_DEEPSLATE_TILES = ITEMS.register("cracked_deepslate_tiles", 
			() -> new BlockItem(ModBlocks.CRACKED_DEEPSLATE_TILES.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> CHISELED_DEEPSLATE = ITEMS.register("chiseled_deepslate", 
			() -> new BlockItem(ModBlocks.CHISELED_DEEPSLATE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_WALL = ITEMS.register("cobbled_deepslate_wall", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_WALL.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_WALL = ITEMS.register("deepslate_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_WALL.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_WALL = ITEMS.register("polished_deepslate_wall", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_WALL.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_WALL = ITEMS.register("deepslate_brick_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_WALL.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_TILE_WALL = ITEMS.register("deepslate_tile_wall", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_WALL.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_STAIRS = ITEMS.register("cobbled_deepslate_stairs", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_STAIRS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_STAIRS = ITEMS.register("deepslate_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_STAIRS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_STAIRS = ITEMS.register("polished_deepslate_stairs", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_STAIRS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_STAIRS = ITEMS.register("deepslate_brick_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_STAIRS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_TILE_STAIRS = ITEMS.register("deepslate_tile_stairs", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_STAIRS.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_SLAB = ITEMS.register("cobbled_deepslate_slab", 
			() -> new BlockItem(ModBlocks.COBBLED_DEEPSLATE_SLAB.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_SLAB = ITEMS.register("deepslate_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_SLAB.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_SLAB = ITEMS.register("polished_deepslate_slab", 
			() -> new BlockItem(ModBlocks.POLISHED_DEEPSLATE_SLAB.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_SLAB = ITEMS.register("deepslate_brick_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_TILE_SLAB = ITEMS.register("deepslate_tile_slab", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_TILE_SLAB.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> COPPER_ORE = ITEMS.register("copper_ore", 
			() -> new BlockItem(ModBlocks.COPPER_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_COAL_ORE = ITEMS.register("deepslate_coal_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_COAL_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_IRON_ORE = ITEMS.register("deepslate_iron_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_IRON_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_COPPER_ORE = ITEMS.register("deepslate_copper_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_COPPER_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_GOLD_ORE = ITEMS.register("deepslate_gold_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_GOLD_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_LAPIS_ORE = ITEMS.register("deepslate_lapis_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_LAPIS_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_REDSTONE_ORE = ITEMS.register("deepslate_redstone_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_REDSTONE_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_DIAMOND_ORE = ITEMS.register("deepslate_diamond_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_DIAMOND_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DEEPSLATE_EMERALD_ORE = ITEMS.register("deepslate_emerald_ore", 
			() -> new BlockItem(ModBlocks.DEEPSLATE_EMERALD_ORE.get(), new Item.Properties().tab(BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> TUFF = ITEMS.register("tuff", 
			() -> new BlockItem(ModBlocks.TUFF.get(), new Item.Properties().tab(BUILDING_BLOCKS)));

}
