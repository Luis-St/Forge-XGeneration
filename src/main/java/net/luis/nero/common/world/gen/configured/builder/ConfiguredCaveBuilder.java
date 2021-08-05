package net.luis.nero.common.world.gen.configured.builder;

import net.luis.nero.api.util.Builder;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ConfiguredCaveBuilder<C extends CaveCarverConfiguration> implements Builder<ConfiguredWorldCarver<C>> {
	
	protected final WorldCarver<C> carver;
	protected float probability;
	protected HeightProvider y;
	protected FloatProvider yScale;
	protected VerticalAnchor lavaLevel;
	protected boolean aquifersEnabled;
	protected boolean debugMode = false;
	protected CarverDebugSettings debugSettings;
	protected FloatProvider horizontalMultiplier;
	protected FloatProvider verticalMultiplier;
	protected FloatProvider floorLevel;
	
	protected ConfiguredCaveBuilder(WorldCarver<C> carver) {
		this.carver = carver;
	}
	
	public static <C extends CaveCarverConfiguration> ConfiguredCaveBuilder<C> of(WorldCarver<C> carver) {
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
	
	public ConfiguredCaveBuilder<C> yScale(float yScale) {
		this.yScale = ConstantFloat.of(yScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> yScale(float minYScale, float maxYScale) {
		this.yScale = UniformFloat.of(minYScale, maxYScale);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> lavaLevel(int lavaLevel) {
		this.lavaLevel = VerticalAnchor.absolute(lavaLevel);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> lavaLevel() {
		this.lavaLevel = VerticalAnchor.absolute(14);
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
	
	public ConfiguredCaveBuilder<C> enableDebugMode() {
		this.debugMode = true;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> disableDebugMode() {
		this.debugMode = false;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> debugSettings() {
		this.debugSettings = CarverDebugSettings.DEFAULT;
		return this;
	}
	
	public ConfiguredCaveBuilder<C> debugSettings(BlockState air, BlockState block, BlockState fluid, BlockState barrier) {
		this.debugSettings = CarverDebugSettings.of(this.debugMode, air, block, fluid, barrier);
		return this;
	}
	
	public ConfiguredCaveBuilder<C> debugSettings(boolean debugMode, BlockState air, BlockState block, BlockState fluid, BlockState barrier) {
		this.debugSettings = CarverDebugSettings.of(debugMode, air, block, fluid, barrier);
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
		return this.carver.configured((C) new CaveCarverConfiguration(this.probability, this.y, this.yScale, this.lavaLevel, this.aquifersEnabled, this.debugSettings, this.verticalMultiplier, this.horizontalMultiplier, this.floorLevel));
	}
	
}
