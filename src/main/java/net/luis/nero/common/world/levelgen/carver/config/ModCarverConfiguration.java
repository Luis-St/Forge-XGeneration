package net.luis.nero.common.world.levelgen.carver.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.material.FluidState;

public class ModCarverConfiguration extends CarverConfiguration {
	
	public static final MapCodec<ModCarverConfiguration> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
		return instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((carverConfig) -> {
			return carverConfig.probability;
		}), HeightProvider.CODEC.fieldOf("y").forGetter((carverConfig) -> {
			return carverConfig.y;
		}), FloatProvider.CODEC.fieldOf("y_scale").forGetter((carverConfig) -> {
			return carverConfig.yScale;
		}), VerticalAnchor.CODEC.fieldOf("fluid_level").forGetter((carverConfig) -> {
			return carverConfig.fluidLevel;
		}), FluidState.CODEC.fieldOf("fluid").forGetter((carverConfig) -> {
			return carverConfig.fluid;
		}), Codec.INT.fieldOf("range").forGetter((carverConfig) -> {
			return carverConfig.range;
		})).apply(instance, ModCarverConfiguration::new);
	});
	
	public final FluidState fluid;
	public final VerticalAnchor fluidLevel;
	public final int range;
	
	public ModCarverConfiguration(float probability, HeightProvider y, FloatProvider yScale, VerticalAnchor fluidLevel, FluidState fluid, int range) {
		super(probability, y, yScale, VerticalAnchor.absolute(0), CarverDebugSettings.DEFAULT);
		this.fluidLevel = fluidLevel;
		this.fluid = fluid;
		this.range = range;
	}

}
