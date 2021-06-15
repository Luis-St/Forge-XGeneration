package net.luis.nero.init.world.gen.feature;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.feature.FlatBedrockFeature;
import net.luis.nero.common.world.gen.feature.ModDungeonsFeature;
import net.luis.nero.common.world.gen.feature.ModLakesFeature;
import net.luis.nero.common.world.gen.feature.ModOreFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Nero.MOD_ID);
	
	public static final RegistryObject<ModDungeonsFeature> MONSTER_ROOM = FEATURES.register("monster_room", ModDungeonsFeature::new);
	public static final RegistryObject<ModLakesFeature> LAKE = FEATURES.register("lake", ModLakesFeature::new);
	public static final RegistryObject<ModOreFeature> ORE = FEATURES.register("ore", ModOreFeature::new);
	public static final RegistryObject<FlatBedrockFeature> FLAT_BEDROCK = FEATURES.register("flat_bedrock", FlatBedrockFeature::new);

}

