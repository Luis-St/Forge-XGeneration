package net.luis.nero.init.world;

import net.luis.nero.Nero;
import net.luis.nero.common.world.NeroWorldType;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldTypes {
	
	public static final DeferredRegister<ForgeWorldType> WORLD_TYPES = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, Nero.MOD_ID);
	
	
	public static final RegistryObject<ForgeWorldType> NERO_OVWERWORLD = WORLD_TYPES.register("nero_overworld", () -> new ForgeWorldType(new NeroWorldType()));
	
}
