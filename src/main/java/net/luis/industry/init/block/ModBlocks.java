package net.luis.industry.init.block;

import static net.luis.industry.Industry.MOD_ID;

import net.luis.industry.common.block.fluid.PipeBlock;
import net.luis.industry.common.block.mechanical.MilestoneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
	
	
	public static final RegistryObject<PipeBlock> FLUID_PIPE = BLOCKS.register("fluid_pipe", 
			() -> new PipeBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).harvestLevel(2)
					.strength(4.0F, 10.0F).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<MilestoneBlock> MILESTONE = BLOCKS.register("milestone",
			() -> new MilestoneBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).harvestLevel(2)
					.strength(3.5F, 6.0F).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> DEEPSLATE = BLOCKS.register("deepslate", 
			() -> new Block(Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops()
					.strength(2.0F, 6.5F)));
	
	public static final RegistryObject<Block> COBBLED_DEEPSLATE = BLOCKS.register("cobbled_deepslate", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> POLISHED_DEEPSLATE = BLOCKS.register("polished_deepslate", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> DEEPSLATE_BRICKS = BLOCKS.register("deepslate_bricks", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS = BLOCKS.register("cracked_deepslate_bricks", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> DEEPSLATE_TILES = BLOCKS.register("deepslate_tiles", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES = BLOCKS.register("cracked_deepslate_tiles", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<Block> CHISELED_DEEPSLATE = BLOCKS.register("chiseled_deepslate", 
			() -> new Block(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<WallBlock> COBBLED_DEEPSLATE_WALL = BLOCKS.register("cobbled_deepslate_wall", 
			() -> new WallBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<WallBlock> DEEPSLATE_WALL = BLOCKS.register("deepslate_wall", 
			() -> new WallBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<WallBlock> POLISHED_DEEPSLATE_WALL = BLOCKS.register("polished_deepslate_wall", 
			() -> new WallBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<WallBlock> DEEPSLATE_BRICK_WALL = BLOCKS.register("deepslate_brick_wall", 
			() -> new WallBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<WallBlock> DEEPSLATE_TILE_WALL = BLOCKS.register("deepslate_tile_wall", 
			() -> new WallBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<StairsBlock> COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("cobbled_deepslate_stairs", 
			() -> new StairsBlock(COBBLED_DEEPSLATE.get()::defaultBlockState, Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<StairsBlock> DEEPSLATE_STAIRS = BLOCKS.register("deepslate_stairs", 
			() -> new StairsBlock(DEEPSLATE.get()::defaultBlockState, Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<StairsBlock> POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("polished_deepslate_stairs", 
			() -> new StairsBlock(POLISHED_DEEPSLATE.get()::defaultBlockState, Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<StairsBlock> DEEPSLATE_BRICK_STAIRS = BLOCKS.register("deepslate_brick_stairs", 
			() -> new StairsBlock(DEEPSLATE_BRICKS.get()::defaultBlockState, Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<StairsBlock> DEEPSLATE_TILE_STAIRS = BLOCKS.register("deepslate_tile_stairs", 
			() -> new StairsBlock(DEEPSLATE_TILES.get()::defaultBlockState, Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<SlabBlock> COBBLED_DEEPSLATE_SLAB = BLOCKS.register("cobbled_deepslate_slab", 
			() -> new SlabBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<SlabBlock> DEEPSLATE_SLAB = BLOCKS.register("deepslate_slab", 
			() -> new SlabBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<SlabBlock> POLISHED_DEEPSLATE_SLAB = BLOCKS.register("polished_deepslate_slab", 
			() -> new SlabBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<SlabBlock> DEEPSLATE_BRICK_SLAB = BLOCKS.register("deepslate_brick_slab", 
			() -> new SlabBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	public static final RegistryObject<SlabBlock> DEEPSLATE_TILE_SLAB = BLOCKS.register("deepslate_tile_slab", 
			() -> new SlabBlock(Block.Properties.copy(ModBlocks.DEEPSLATE.get())));
	
	
}
