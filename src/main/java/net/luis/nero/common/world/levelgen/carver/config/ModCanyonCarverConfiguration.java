package net.luis.nero.common.world.levelgen.carver.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.material.FluidState;

public class ModCanyonCarverConfiguration extends ModCarverConfiguration {
	
	public static final Codec<ModCanyonCarverConfiguration> CODEC = RecordCodecBuilder.create((p_158984_) -> {
		return p_158984_.group(ModCarverConfiguration.CODEC.forGetter((p_158990_) -> {
			return p_158990_;
		}), FloatProvider.CODEC.fieldOf("vertical_rotation").forGetter((p_158988_) -> {
			return p_158988_.verticalRotation;
		}), ModCanyonCarverConfiguration.ModCanyonShapeConfiguration.CODEC.fieldOf("shape").forGetter((p_158986_) -> {
			return p_158986_.shape;
		})).apply(p_158984_, ModCanyonCarverConfiguration::new);
	});
	
	public final FloatProvider verticalRotation;
	public final ModCanyonCarverConfiguration.ModCanyonShapeConfiguration shape;
	
	protected ModCanyonCarverConfiguration(ModCarverConfiguration config, FloatProvider verticalRotation, ModCanyonCarverConfiguration.ModCanyonShapeConfiguration shape) {
		this(config.probability, config.y, config.yScale, config.fluidLevel, config.fluid, config.range, verticalRotation, shape);
	}
	
	public ModCanyonCarverConfiguration(float probability, HeightProvider y, FloatProvider yScale, VerticalAnchor fluidLevel, FluidState fluid, int range, FloatProvider verticalRotation, ModCanyonCarverConfiguration.ModCanyonShapeConfiguration shape) {
		super(probability, y, yScale, fluidLevel, fluid, range);
		this.verticalRotation = verticalRotation;
		this.shape = shape;
	}
	
	public static class ModCanyonShapeConfiguration {
		
		public static final Codec<ModCanyonShapeConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
			return instance.group(FloatProvider.CODEC.fieldOf("distance_factor").forGetter((shapeConfig) -> {
				return shapeConfig.distanceFactor;
			}), FloatProvider.CODEC.fieldOf("thickness").forGetter((shapeConfig) -> {
				return shapeConfig.thickness;
			}), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("width_smoothness").forGetter((shapeConfig) -> {
				return shapeConfig.widthSmoothness;
			}), FloatProvider.CODEC.fieldOf("horizontal_factor").forGetter((shapeConfig) -> {
				return shapeConfig.horizontalFactor;
			}), Codec.FLOAT.fieldOf("vertical_default_factor").forGetter((shapeConfig) -> {
				return shapeConfig.verticalDefaultFactor;
			}), Codec.FLOAT.fieldOf("vertical_center_factor").forGetter((shapeConfig) -> {
				return shapeConfig.verticalCenterFactor;
			})).apply(instance, ModCanyonShapeConfiguration::new);
		});
		
		public final FloatProvider distanceFactor;
		public final FloatProvider thickness;
		public final int widthSmoothness;
		public final FloatProvider horizontalFactor;
		public final float verticalDefaultFactor;
		public final float verticalCenterFactor;
		
		public ModCanyonShapeConfiguration(FloatProvider distanceFactor, FloatProvider thickness, int widthSmoothness, FloatProvider horizontalFactor, float verticalDefaultFactor, float verticalCenterFactor) {
			this.distanceFactor = distanceFactor;
			this.thickness = thickness;
			this.widthSmoothness = widthSmoothness;
			this.horizontalFactor = horizontalFactor;
			this.verticalDefaultFactor = verticalDefaultFactor;
			this.verticalCenterFactor = verticalCenterFactor;
		}
		
	}
	
}
