package net.luis.industry.init.blocks.util;

import net.luis.industry.Industry;
import net.luis.industry.common.tileentities.MilestoneTileEntity;
import net.luis.industry.init.blocks.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Industry.MOD_ID);
	
	
	public static final RegistryObject<TileEntityType<MilestoneTileEntity>> MILESTONE = TILE_ENTITIES.register("milestone", 
			() -> TileEntityType.Builder.create(MilestoneTileEntity::new, ModBlocks.MILESTONE.get()).build(null));

}
