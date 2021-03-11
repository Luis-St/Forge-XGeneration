package net.luis.industry.init.villager;

import net.luis.industry.Industry;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModVillagerProfessions {
	
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Industry.MOD_ID);

}
