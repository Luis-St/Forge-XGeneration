package net.luis.nero.init.villager;

import net.luis.nero.Nero;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPointOfInterestTypes {
	
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Nero.MOD_ID);

}
