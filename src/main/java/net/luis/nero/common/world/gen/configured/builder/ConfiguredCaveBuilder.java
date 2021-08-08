package net.luis.nero.common.world.gen.configured.builder;

import net.luis.nero.api.common.world.gen.carver.config.ModCaveCarverConfiguration;
import net.luis.nero.api.util.Builder;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class ConfiguredCaveBuilder<C extends ModCaveCarverConfiguration> implements Builder<ConfiguredWorldCarver<C>> {
	
	protected final WorldCarver<C> carver;
	protected float probability;
	protected HeightProvider y;
	protected FloatProvider yRoomScale;
	protected FloatProvider yTunnelScale;
	protected VerticalAnchor fluidLevel;
	protected FluidState fluid;
	protected boolean aquifersEnabled;
	protected int range;
	protected int bound;
	protected FloatProvider horizontalMultiplier;
	protected FloatProvider verticalMultiplier;
	protected FloatProvider floorLevel;
	
	protected ConfiguredCaveBuilder(WorldCarver<C> carver) {
		this.carver = carver;
	}
	
	public static <C extends ModCaveCarverConfiguration> ConfiguredCaveBuilder<C> of(WorldCarver<C> carver) {
		return new ConfiguredCaveBuilder<>(carver);
	}
	
	public ConfiguredCaveBuilder<C> probability(float probability) {
		this.probability = probability;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> y(int y) {
		this.y = ConstantHeight.of(VerticalAnchor.absolute(y));
		return this;
	}
	
	public ConfiguredCaveBuilder<C> y(int yMin, int yMax) {
		this.y = UniformHeight.of(VerticalAnchor.absolute(yMin), VerticalAnchor.absolute(yMax));
		return this;
	}
	
	public ConfiguredCaveBuilder<C> yRoomScale(float yRoomScale) {
		this.yRoomScale = ConstantFloat.of(yRoomScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> yRoomScale(float minScale, float maxScale) {
		this.yRoomScale = UniformFloat.of(minScale, maxScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> yTunnelScale(float yTunnelScale) {
		this.yTunnelScale = ConstantFloat.of(yTunnelScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> yTunnelScale(float minScale, float maxScale) {
		this.yTunnelScale = UniformFloat.of(minScale, maxScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> fluidLevel(int fluidLevel) {
		this.fluidLevel = VerticalAnchor.absolute(fluidLevel);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> fluidLevel() {
		this.fluidLevel = VerticalAnchor.absolute(14);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> fluid(FluidState fluid) {
		this.fluid = fluid;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> fluid(Fluid fluid) {
		this.fluid = fluid.defaultFluidState();
		return this;
	}
	
	public ConfiguredCaveBuilder<C> enableAquifers() {
		this.aquifersEnabled = true;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> disableAquifers() {
		this.aquifersEnabled = false;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> range(int range) {
		this.range = range;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> bound(int bound) {
		this.bound = bound;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> horizontalMultiplier(float multiplier) {
		this.horizontalMultiplier = ConstantFloat.of(multiplier);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> horizontalMultiplier(float minMultiplier, float maxMultiplier) {
		this.horizontalMultiplier = UniformFloat.of(minMultiplier, maxMultiplier);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> verticalMultiplier(float multiplier) {
		this.verticalMultiplier = ConstantFloat.of(multiplier);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> verticalMultiplier(float minMultiplier, float maxMultiplier) {
		this.verticalMultiplier = UniformFloat.of(minMultiplier, maxMultiplier);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> floorLevel(float floorLevel) {
		this.floorLevel = ConstantFloat.of(floorLevel);
		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ConfiguredWorldCarver<C> build() {
		return this.carver.configured((C) new ModCaveCarverConfiguration(this.probability, this.y, this.yRoomScale, this.yTunnelScale, this.fluidLevel, this.fluid, this.aquifersEnabled, this.range, this.bound, 
				this.horizontalMultiplier, this.verticalMultiplier, this.floorLevel));
	}
	
}
