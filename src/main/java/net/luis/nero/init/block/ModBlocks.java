package net.luis.nero.init.block;

import net.luis.nero.Nero;
import net.luis.nero.common.block.BloodAltarBlock;
import net.luis.nero.common.block.BridgeBlock;
import net.luis.nero.common.block.DriftSandBlock;
import net.luis.nero.common.block.MilestoneBlock;
import net.luis.nero.common.block.PipeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nero.MOD_ID);
	
	
	public static final RegistryObject<PipeBlock> FLUID_PIPE = BLOCKS.register("fluid_pipe", 
			() -> new PipeBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(4.0F, 10.0F)
					.requiresCorrectToolForDrops()));
	public static final RegistryObject<MilestoneBlock> MILESTONE = BLOCKS.register("milestone",
			() -> new MilestoneBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.5F, 6.0F)
					.requiresCorrectToolForDrops()));
	public static final RegistryObject<WallBlock> DEEPSLATE_WALL = BLOCKS.register("deepslate_wall", 
			() -> new WallBlock(Block.Properties.copy(Blocks.DEEPSLATE)));
	public static final RegistryObject<StairBlock> DEEPSLATE_STAIRS = BLOCKS.register("deepslate_stairs", 
			() -> new StairBlock(Blocks.DEEPSLATE::defaultBlockState, Block.Properties.copy(Blocks.DEEPSLATE)));
	public static final RegistryObject<SlabBlock> DEEPSLATE_SLAB = BLOCKS.register("deepslate_slab", 
			() -> new SlabBlock(Block.Properties.copy(Blocks.DEEPSLATE)));
	public static final RegistryObject<Block> BLOOD_ALTAR = BLOCKS.register("blood_altar", 
			() -> new BloodAltarBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F, 8.0F)
					.noOcclusion().requiresCorrectToolForDrops()));
	public static final RegistryObject<BridgeBlock> BRIDGE_BLOCK = BLOCKS.register("bridge_block", 
			() -> new BridgeBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLACK).noDrops().instabreak()
					.noOcclusion().sound(SoundType.GLASS)));
	public static final RegistryObject<DriftSandBlock> DRIFT_SAND = BLOCKS.register("drift_sand", 
			() -> new DriftSandBlock(14728571, Block.Properties.copy(Blocks.SAND).strength(0.6F).dynamicShape()));
	public static final RegistryObject<SandBlock> SCORCHED_SAND = BLOCKS.register("scorched_sand", 
			() -> new SandBlock(0, Block.Properties.copy(Blocks.SAND)));
	public static final RegistryObject<RotatedPillarBlock> TERMITE_MOUND = BLOCKS.register("termite_mound", 
			() -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_LOG)));
	
}
