package net.luis.industry.init.block;

import net.luis.industry.Industry;
import net.luis.industry.common.block.fluid.PipeBlock;
import net.luis.industry.common.block.mechanical.MilestoneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Industry.MOD_ID);
	
	
	public static RegistryObject<PipeBlock> FLUID_PIPE = BLOCKS.register("fluid_pipe", 
			() -> new PipeBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).harvestLevel(2)
					.strength(4.0F, 10.0F).requiresCorrectToolForDrops()));
	
	public static RegistryObject<MilestoneBlock> MILESTONE = BLOCKS.register("milestone",
			() -> new MilestoneBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).harvestLevel(2)
					.strength(3.5F, 6.0F).requiresCorrectToolForDrops()));
	
}
