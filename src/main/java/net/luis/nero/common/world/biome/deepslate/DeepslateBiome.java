package net.luis.nero.common.world.biome.deepslate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.luis.nero.common.world.levelgen.feature.DefaultModFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public class DeepslateBiome implements IBiome {
	
	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public BiomeCategory getCategory() {
		return BiomeCategory.UNDERGROUND;
	}
	
	@Override
	public float getDepth() {
		return 0.0F;
	}
	
	@Override
	public float getScale() {
		return 0.0F;
	}
	
	@Override
	public float getTemperature() {
		return 0.0F;
	}
	
	@Override
	public float getDownfall() {
		return 0.0F;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4159204);
		specialEffectsBuilder.waterFogColor(329011);
		specialEffectsBuilder.fogColor(12638463);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(7979098);
		specialEffectsBuilder.foliageColorOverride(5877296);
		return specialEffectsBuilder.build();
	}

	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		MobSpawnSettings.Builder modBuilder = new MobSpawnSettings.Builder();
		DefaultModFeatures.addCommonMonsterSpawns(modBuilder);
		return modBuilder.build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder();
		generationBuilder.surfaceBuilder(() -> ConfiguredModSurfaceBuilders.DEEPSLATE);
		return generationBuilder.build();
	}

	@Override
	public Optional<Supplier<ConfiguredSurfaceBuilder<?>>> getModSurfaceBuilder() {
		return Optional.empty();
	}

	@Override
	public Map<Decoration, Supplier<ConfiguredFeature<?, ?>>> getModFeatures() {
		return Maps.newEnumMap(Decoration.class);
	}

	@Override
	public Map<Carving, Supplier<ConfiguredWorldCarver<?>>> getModWorldCarvers() {
		return Maps.newEnumMap(Carving.class);
	}

	@Override
	public List<Supplier<ConfiguredStructureFeature<?, ?>>> getModStructures() {
		return Lists.newArrayList();
	}
	
}
