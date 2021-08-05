package net.luis.nero.common.world.gen.configured.builder;

import net.luis.nero.api.util.Builder;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration.CanyonShapeConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ConfiguredCanyonBuilder<C extends CanyonCarverConfiguration> implements Builder<ConfiguredWorldCarver<C>> {
	
	protected final WorldCarver<C> carver;
	protected float probability;
	protected HeightProvider y;
	protected FloatProvider yScale;
	protected VerticalAnchor lavaLevel;
	protected boolean aquifersEnabled;
	protected boolean debugMode = false;
	protected CarverDebugSettings debugSettings;
	protected FloatProvider verticalRotation;
	protected CanyonCarverConfiguration.CanyonShapeConfiguration shape;
	
	protected ConfiguredCanyonBuilder(WorldCarver<C> carver) {
		this.carver = carver;
	}
	
	public static <C extends CanyonCarverConfiguration> ConfiguredCanyonBuilder<C> of(WorldCarver<C> carver) {
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
	
	public ConfiguredCanyonBuilder<C> lavaLevel(int lavaLevel) {
		this.lavaLevel = VerticalAnchor.absolute(lavaLevel);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> lavaLevel() {
		this.lavaLevel = VerticalAnchor.absolute(14);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> enableAquifers() {
		this.aquifersEnabled = true;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> disableAquifers() {
		this.aquifersEnabled = false;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> enableDebugMode() {
		this.debugMode = true;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> disableDebugMode() {
		this.debugMode = false;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> debugSettings() {
		this.debugSettings = CarverDebugSettings.DEFAULT;
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> debugSettings(BlockState air, BlockState block, BlockState fluid, BlockState barrier) {
		this.debugSettings = CarverDebugSettings.of(this.debugMode, air, block, fluid, barrier);
		return this;
	}
	
	public ConfiguredCanyonBuilder<C> debugSettings(boolean debugMode, BlockState air, BlockState block, BlockState fluid, BlockState barrier) {
		this.debugSettings = CarverDebugSettings.of(debugMode, air, block, fluid, barrier);
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
		return this.carver.configured((C) new CanyonCarverConfiguration(this.probability, this.y, this.yScale, this.lavaLevel, this.aquifersEnabled, this.debugSettings, this.verticalRotation, this.shape));
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
		
		protected CanyonShapeConfiguration build() {
			return new CanyonCarverConfiguration.CanyonShapeConfiguration(this.distanceFactor, this.thickness, this.widthSmoothness, this.horizontalRadiusFactor, this.verticalRadiusDefaultFactor, this.verticalRadiusCenterFactor);
		}
		
	}

}
