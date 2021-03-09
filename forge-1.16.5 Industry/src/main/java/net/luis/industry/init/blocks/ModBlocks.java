package net.luis.industry.init.blocks;

import net.luis.industry.Industry;
import net.luis.industry.api.blocks.PipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Industry.MOD_ID);
	
	
	public static RegistryObject<Block> FLUID_PIPE = BLOCKS.register("fluid_pipe", 
			() -> new PipeBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).harvestLevel(1)
					.hardnessAndResistance(4.0F, 10.0F).setRequiresTool()));
	
}
