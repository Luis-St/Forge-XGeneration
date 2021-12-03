package net.luis.nero.common.world.levelgen.carver.builder;

import net.luis.nero.common.util.Builder;
import net.luis.nero.common.world.levelgen.carver.config.ModCanyonCarverConfiguration;
import net.luis.nero.common.world.levelgen.carver.config.ModCanyonCarverConfiguration.ModCanyonShapeConfiguration;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

// TODO: fix
public class ConfiguredCanyonBuilder<C extends ModCanyonCarverConfiguration> implements Builder<ConfiguredWorldCarver<C>> {
	
	protected final WorldCarver<C> carver;
	protected float probability;
	protected HeightProvider y;
	protected FloatProvider yScale;
	protected VerticalAnchor fluidLevel;
	protected FluidState fluid;
	protected int range;
	protected FloatProvider verticalRotation;
	protected ModCanyonShapeConfiguration shape;
	
	protected ConfiguredCanyonBuilder(WorldCarver<C> carver) {
		this.carver = carver;
	}
	
	public static <C extends ModCanyonCarverConfiguration> ConfiguredCanyonBuilder<C> of(WorldCarver<C> carver) {
		return new ConfiguredCanyonBuilder<>(carver);
	}
	
	public ConfiguredCanyonBuilder<C> probability(float probability) {
		this.probability = probability;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> y(int y) {
		this.y = ConstantHeight.of(VerticalAnchor.absolute(y));
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> y(int yMin, int yMax) {
		this.y = UniformHeight.of(VerticalAnchor.absolute(yMin), VerticalAnchor.absolute(yMax));
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> yScale(float yScale) {
		this.yScale = ConstantFloat.of(yScale);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> yScale(float minYScale, float maxYScale) {
		this.yScale = UniformFloat.of(minYScale, maxYScale);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> fluidLevel(int fluidLevel) {
		this.fluidLevel = VerticalAnchor.absolute(fluidLevel);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> fluidLevel() {
		this.fluidLevel = VerticalAnchor.absolute(14);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> fluid(FluidState fluid) {
		this.fluid = fluid;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> fluid(Fluid fluid) {
		this.fluid = fluid.defaultFluidState();
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> range(int range) {
		this.range = range;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> verticalRotation(float verticalRotation) {
		this.verticalRotation = ConstantFloat.of(verticalRotation);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> verticalRotation(float minVerticalRotation, float maxVerticalRotation) {
		this.verticalRotation = UniformFloat.of(minVerticalRotation, maxVerticalRotation);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> shape(ConfiguredCanyonBuilder.ShapeBuilder shapeBuilder) {
		this.shape = shapeBuilder.build();
		return this;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ConfiguredWorldCarver<C> build() {
		return this.carver.configured((C) new ModCanyonCarverConfiguration(this.probability, this.y, this.yScale, this.fluidLevel, this.fluid, this.range, this.verticalRotation, this.shape));
	}
	
	public static class ShapeBuilder {
		
		protected FloatProvider distanceFactor;
		protected FloatProvider thickness;
		protected int widthSmoothness;
		protected FloatProvider horizontalRadiusFactor;
		protected float verticalRadiusDefaultFactor;
		protected float verticalRadiusCenterFactor;
		
		protected ShapeBuilder() {
			
		}
		
		public static ShapeBuilder of() {
			return new ShapeBuilder();
		}
		
		public ShapeBuilder distanceFactor(float distanceFactor) {
			this.distanceFactor = ConstantFloat.of(distanceFactor);
			return this;
		}
		
		public ShapeBuilder distanceFactor(float minDistanceFactor, float maxDistanceFactor) {
			this.distanceFactor = UniformFloat.of(minDistanceFactor, maxDistanceFactor);
			return this;
		}
		
		public ShapeBuilder thickness(float thickness) {
			this.thickness = ConstantFloat.of(thickness);
			return this;
		}
		
		public ShapeBuilder thickness(float minThickness, float maxThickness) {
			this.thickness = UniformFloat.of(minThickness, maxThickness);
			return this;
		}
		
		public ShapeBuilder thickness(float minThickness, float maxThickness, float thickness) {
			this.thickness = TrapezoidFloat.of(minThickness, maxThickness, thickness);
			return this;
		}
		
		public ShapeBuilder widthSmoothness(int widthSmoothness) {
			this.widthSmoothness = widthSmoothness;
			return this;
		}
		
		public ShapeBuilder horizontalFactor(float horizontalFactor) {
			this.horizontalRadiusFactor = ConstantFloat.of(horizontalFactor);
			return this;
		}
		
		public ShapeBuilder horizontalFactor(float minHorizontalFactor, float maxHorizontalFactor) {
			this.horizontalRadiusFactor = UniformFloat.of(minHorizontalFactor, maxHorizontalFactor);
			return this;
		}
		
		public ShapeBuilder verticalDefaultFactor(float verticalDefaultFactor) {
			this.verticalRadiusDefaultFactor = verticalDefaultFactor;
			return this;
		}
		
		public ShapeBuilder verticalCenterFactor(float verticalDefaultFactor) {
			this.verticalRadiusCenterFactor = verticalDefaultFactor;
			return this;
		}
		
		protected ModCanyonShapeConfiguration build() {
			return new ModCanyonShapeConfiguration(this.distanceFactor, this.thickness, this.widthSmoothness, this.horizontalRadiusFactor, this.verticalRadiusDefaultFactor, this.verticalRadiusCenterFactor);
		}
		
	}

}
