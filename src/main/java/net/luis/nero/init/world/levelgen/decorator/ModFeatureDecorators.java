package net.luis.nero.init.world.levelgen.decorator;

import net.luis.nero.Nero;
import net.luis.nero.common.world.levelgen.decorator.DepthAverageDecorator;
import net.luis.nero.common.world.levelgen.decorator.config.DepthAverageDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatureDecorators {
	
	public static final DeferredRegister<FeatureDecorator<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, Nero.MOD_ID);
	
	public static final RegistryObject<DepthAverageDecorator> DEPTH_AVERAGE = DECORATORS.register("depth_average", () -> new DepthAverageDecorator(DepthAverageDecoratorConfiguration.CODEC));

}
