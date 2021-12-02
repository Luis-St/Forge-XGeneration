package net.luis.nero.init.world;

import net.luis.nero.Nero;
import net.luis.nero.common.world.NeroWorldType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.world.ForgeWorldPreset;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldTypes {
	
	public static final DeferredRegister<ForgeWorldPreset> WORLD_TYPES = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, Nero.MOD_ID);
	
	
	public static final RegistryObject<ForgeWorldPreset> NERO_OVWERWORLD = WORLD_TYPES.register("nero_overworld", () -> new ForgeWorldPreset(new NeroWorldType()));
	
}
