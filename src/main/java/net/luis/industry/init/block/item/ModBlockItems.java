package net.luis.industry.init.block.item;

import net.luis.industry.Industry;
import net.luis.industry.init.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Industry.MOD_ID);
	
	
	public static final RegistryObject<Item> FLUID_PIPE_ITEM = ITEMS.register("fluid_pipe", 
			() -> new BlockItem(ModBlocks.FLUID_PIPE.get(), new Item.Properties().group(Industry.INDUSTRY)));
	
	public static final RegistryObject<Item> MILESTONE_ITEM = ITEMS.register("milestone", 
			() -> new BlockItem(ModBlocks.MILESTONE.get(), new Item.Properties().group(Industry.INDUSTRY)));

}
