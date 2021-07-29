package net.luis.nero.init.block.util;

import net.luis.nero.Nero;
import net.luis.nero.common.tileentity.BloodAltarTileEntity;
import net.luis.nero.common.tileentity.BridgeTileEntity;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Nero.MOD_ID);
	
	
//	public static final RegistryObject<TileEntityType<MilestoneTileEntity>> MILESTONE = TILE_ENTITIES.register("milestone", 
//			() -> TileEntityType.Builder.of(MilestoneTileEntity::new, ModBlocks.MILESTONE.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<BloodAltarTileEntity>> BLOOD_ALTAR = TILE_ENTITIES.register("blood_altar", 
			() -> BlockEntityType.Builder.of(BloodAltarTileEntity::new, ModBlocks.BLOOD_ALTAR.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<BridgeTileEntity>> BRIDGE = TILE_ENTITIES.register("bridge", 
			() -> BlockEntityType.Builder.of(BridgeTileEntity::new, ModBlocks.BRIDGE_BLOCK.get()).build(null));

}
