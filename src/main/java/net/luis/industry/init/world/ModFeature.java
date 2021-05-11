package net.luis.industry.init.world;

import net.luis.industry.Industry;
import net.luis.industry.common.world.feature.ModDungeonsFeature;
import net.luis.industry.common.world.feature.ModLakesFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeature {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Industry.MOD_ID);
	
	
	public static final RegistryObject<ModDungeonsFeature> MONSTER_ROOM = FEATURES.register("monster_room", ModDungeonsFeature::new);
	public static final RegistryObject<ModLakesFeature> LAKE = FEATURES.register("lake", ModLakesFeature::new);

}

