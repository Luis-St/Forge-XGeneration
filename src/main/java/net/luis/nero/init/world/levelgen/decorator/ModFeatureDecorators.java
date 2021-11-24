package net.luis.nero.init.world.levelgen.decorator;

import net.luis.nero.Nero;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatureDecorators {
	
	public static final DeferredRegister<FeatureDecorator<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, Nero.MOD_ID);

}
