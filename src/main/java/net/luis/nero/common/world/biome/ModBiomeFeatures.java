package net.luis.nero.common.world.biome;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

public class ModBiomeFeatures {
	
	protected Optional<Supplier<ConfiguredSurfaceBuilder<?>>> modSurfaceBuilder;
	protected final Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures;
	protected final Map<Carving, List<Supplier<ConfiguredWorldCarver<?>>>> modWorldCarvers;
	protected final List<Supplier<ConfiguredStructureFeature<?, ?>>> modStructures;
	
	public ModBiomeFeatures() {
		this.modSurfaceBuilder = Optional.empty();
		this.modFeatures = Util.make(Maps.newHashMap(), map -> {
			for (Decoration decoration : Decoration.values()) {
				map.put(decoration, Lists.newArrayList());
			}
		});
		this.modWorldCarvers = Util.make(Maps.newHashMap(), map -> {
			for (Carving carving : Carving.values()) {
				map.put(carving, Lists.newArrayList());
			}
		});
		this.modStructures = Lists.newArrayList();
	}
	
	public void setModSurfaceBuilder(Supplier<ConfiguredSurfaceBuilder<?>> modSurfaceBuilder) {
		this.modSurfaceBuilder = Optional.of(modSurfaceBuilder);
	}
	
	public Optional<Supplier<ConfiguredSurfaceBuilder<?>>> getModSurfaceBuilder() {
		return this.modSurfaceBuilder;
	}
	
	public void addModFeature(Decoration decoration, Supplier<ConfiguredFeature<?, ?>> modFeature) {
		this.modFeatures.get(decoration).add(modFeature);
	}
	
	public Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> getModFeatures() {
		return this.modFeatures;
	}
	
	public void addModWorldCarvers(Carving carving, Supplier<ConfiguredWorldCarver<?>> modWorldCarver) {
		this.modWorldCarvers.get(carving).add(modWorldCarver);
	}
	
	public Map<Carving, List<Supplier<ConfiguredWorldCarver<?>>>> getModWorldCarvers() {
		return this.modWorldCarvers;
	}
	
	public void addModStructures(Supplier<ConfiguredStructureFeature<?, ?>> modStructure) {
		this.modStructures.add(modStructure);
	}
	
	public List<Supplier<ConfiguredStructureFeature<?, ?>>> getModStructures() {
		return this.modStructures;
	}
	
	public void addAllFeatures(BiomeGenerationSettingsBuilder generationBuilder) {
		this.modSurfaceBuilder.ifPresent(surfaceBuilder -> {
			generationBuilder.surfaceBuilder(surfaceBuilder);
		});
		this.modFeatures.forEach((decoration, features) -> {
			features.forEach(feature -> {
				generationBuilder.addFeature(decoration.ordinal(), feature);
			});
		});
		
		this.modWorldCarvers.forEach((carving, worldCarvers) -> {
			worldCarvers.forEach(worldCarver -> {
				generationBuilder.addCarver(carving, worldCarver.get());
			});
		});
		
		this.modStructures.forEach(structure -> {
			generationBuilder.addStructureStart(structure.get());
		});
	}
	
}
