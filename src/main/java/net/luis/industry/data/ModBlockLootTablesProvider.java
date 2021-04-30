package net.luis.industry.data;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import net.luis.industry.Industry;
import net.luis.industry.init.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockLootTablesProvider extends BlockLootTables {
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return StreamSupport.stream(ForgeRegistries.BLOCKS.spliterator(), false)
				.filter(block -> block.getRegistryName() != null && block.getRegistryName().getNamespace().equals(Industry.MOD_ID))
				.collect(Collectors.toSet());
	}
	
	@Override
	protected void addTables() {
		super.addTables();
		this.dropSelf(ModBlocks.FLUID_PIPE.get());
		this.dropSelf(ModBlocks.MILESTONE.get());
	}
	
}
