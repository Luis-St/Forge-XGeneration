package net.luis.nero.init.villager;

import net.luis.nero.Nero;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModVillagerProfessions {
	
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Nero.MOD_ID);

}
