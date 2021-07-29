package net.luis.nero.init.world.gen.feature.structure;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.feature.structure.DeepslateMineshaftStructure;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModStructures {
	
	public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Nero.MOD_ID);
	
	
	public static final RegistryObject<StructureFeature<NoneFeatureConfiguration>> DEEPSLATE_MINESHAFT = STRUCTURES.register("deepslate_mineshaft", DeepslateMineshaftStructure::new);
	
}

