package net.luis.nero.common.world.biome;

import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public class BiomeGenerationBuilder extends BiomeGenerationSettings.Builder {

	@Override
	public BiomeGenerationBuilder surfaceBuilder(ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder) {
		return this.surfaceBuilder(() -> configuredSurfaceBuilder);
	}

	@Override
	public BiomeGenerationBuilder surfaceBuilder(Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilder) {
		this.surfaceBuilder = Optional.of(configuredSurfaceBuilder);
		return this;
	}
	
	@Override
	public BiomeGenerationBuilder addFeature(GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
		return this.addFeature(decoration.ordinal(), () -> configuredFeature);
	}
	
	public BiomeGenerationBuilder addFeature(GenerationStep.Decoration decoration, Supplier<ConfiguredFeature<?, ?>> configuredFeatur) {
		return this.addFeature(decoration.ordinal(), configuredFeatur);
	}
	
	@Override
	public BiomeGenerationBuilder addFeature(int decoration, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
//		this.addFeatureStepsUpTo(decoration);
//		this.features.get(decoration).add(configuredFeature);
		return this;
	}
	
	public BiomeGenerationBuilder removeFeature(int decoration, ConfiguredFeature<?, ?> configuredFeature) {
//		this.features.get(decoration).removeIf(feature -> feature.get() == configuredFeature);
		return this;
	}
	
	@Override
	public <C extends CarverConfiguration> BiomeGenerationBuilder addCarver(GenerationStep.Carving carving, ConfiguredWorldCarver<C> configuredWorldCarver) {
//		this.carvers.computeIfAbsent(carving, (c) -> {
//			return Lists.newArrayList();
//		}).add(() -> configuredWorldCarver);
		return this;
	}
	
	public <C extends CarverConfiguration> BiomeGenerationBuilder removeCarver(GenerationStep.Carving carving, ConfiguredWorldCarver<C> configuredWorldCarver) {
		this.carvers.get(carving).removeIf(worldCarver -> worldCarver.get() == configuredWorldCarver);
		return this;
	}

	@Override
	public BiomeGenerationBuilder addStructureStart(ConfiguredStructureFeature<?, ?> configuredStructureFeature) {
//		this.structureStarts.add(() -> configuredStructureFeature);
		return this;
	}
	
	public BiomeGenerationBuilder removeStructureStart(ConfiguredStructureFeature<?, ?> configuredStructureFeature) {
		this.structureStarts.removeIf(structureFeature -> structureFeature == configuredStructureFeature);
		return this;
	}

}
