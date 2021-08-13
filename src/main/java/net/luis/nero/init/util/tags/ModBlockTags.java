package net.luis.nero.init.util.tags;

import net.luis.nero.Nero;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	
	public static final Tag.Named<Block> FLUID_SYSTEM = BlockTags.createOptional(new ResourceLocation(Nero.MOD_ID, "fluid_system"));
	
}