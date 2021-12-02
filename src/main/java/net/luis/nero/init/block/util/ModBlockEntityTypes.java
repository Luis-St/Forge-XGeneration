package net.luis.nero.init.block.util;

import net.luis.nero.Nero;
import net.luis.nero.common.block.entity.BloodAltarBlockEntity;
import net.luis.nero.common.block.entity.BridgeBlockEntity;
import net.luis.nero.init.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntityTypes {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Nero.MOD_ID);
	
	
//	public static final RegistryObject<TileEntityType<MilestoneTileEntity>> MILESTONE = BLOCK_ENTITIES.register("milestone", 
//			() -> TileEntityType.Builder.of(MilestoneTileEntity::new, ModBlocks.MILESTONE.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<BloodAltarBlockEntity>> BLOOD_ALTAR = BLOCK_ENTITIES.register("blood_altar", 
			() -> BlockEntityType.Builder.of(BloodAltarBlockEntity::new, ModBlocks.BLOOD_ALTAR.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<BridgeBlockEntity>> BRIDGE = BLOCK_ENTITIES.register("bridge", 
			() -> BlockEntityType.Builder.of(BridgeBlockEntity::new, ModBlocks.BRIDGE_BLOCK.get()).build(null));

}
