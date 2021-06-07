package net.luis.nero.init.world.structure;

import net.luis.nero.Nero;
import net.luis.nero.common.world.structure.DeepslateMineshaftStructure;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModStructures {
	
	public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Nero.MOD_ID);
	
	
	public static final RegistryObject<Structure<NoFeatureConfig>> DEEPSLATE_MINESHAFT = STRUCTURES.register("deepslate_mineshaft", 
			() -> new DeepslateMineshaftStructure(NoFeatureConfig.CODEC));
	
}

