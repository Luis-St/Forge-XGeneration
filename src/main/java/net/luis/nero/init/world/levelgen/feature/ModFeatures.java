package net.luis.nero.init.world.levelgen.feature;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.feature.ModDungeonsFeature;
import net.luis.nero.common.world.levelgen.feature.ModOreFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Nero.MOD_ID);
	
	public static final RegistryObject<ModDungeonsFeature> MONSTER_ROOM = FEATURES.register("monster_room", ModDungeonsFeature::new);
	public static final RegistryObject<ModOreFeature> ORE = FEATURES.register("ore", ModOreFeature::new);
	
}

