package net.luis.nero.init.block.util;

import net.luis.nero.Nero;
import net.luis.nero.common.tileentity.BloodAltarTileEntity;
import net.luis.nero.common.tileentity.BridgeTileEntity;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Nero.MOD_ID);
	
	
//	public static final RegistryObject<TileEntityType<MilestoneTileEntity>> MILESTONE = TILE_ENTITIES.register("milestone", 
//			() -> TileEntityType.Builder.of(MilestoneTileEntity::new, ModBlocks.MILESTONE.get()).build(null));
	
	public static final RegistryObject<TileEntityType<BloodAltarTileEntity>> BLOOD_ALTAR = TILE_ENTITIES.register("blood_altar", 
			() -> TileEntityType.Builder.of(BloodAltarTileEntity::new, ModBlocks.BLOOD_ALTAR.get()).build(null));
	
	public static final RegistryObject<TileEntityType<BridgeTileEntity>> BRIDGE = TILE_ENTITIES.register("bridge", 
			() -> TileEntityType.Builder.of(BridgeTileEntity::new, ModBlocks.BRIDGE_BLOCK.get()).build(null));

}
