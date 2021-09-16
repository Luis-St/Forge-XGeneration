package net.luis.nero.api.common.world.biome;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.common.collect.Lists;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.BiomeUtil;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public abstract class ModBiome implements IBiome {
	
	protected final int waterColor;
	protected final int waterFogColor;
	protected final int fogColor;
	protected final int grassColor;
	protected final int foliageColor;
	
	protected ModBiome(BiomeEffects biomeEffects) {
		this(biomeEffects.getWaterColor(), biomeEffects.getWaterFogColor(), biomeEffects.getFogColor(), biomeEffects.getGrassColor(), biomeEffects.getFoliageColor());
	}
	
	protected ModBiome(int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor) {
		this.waterColor = waterColor == -1 ? 4159204 : waterColor;
		this.waterFogColor = waterFogColor == -1 ? 329011 : waterFogColor;
		this.fogColor = fogColor == -1 ? 12638463 : fogColor;
		this.grassColor = grassColor == -1 ? 9551193 : grassColor;
		this.foliageColor = foliageColor == -1 ? 7842607 : foliageColor;
	}

	@Override
	public BiomeCategory getCategory() {
		return BiomeCategory.NONE;
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
		specialEffectsBuilder.waterColor(this.waterColor);
		specialEffectsBuilder.waterFogColor(this.waterFogColor);
		specialEffectsBuilder.fogColor(this.fogColor);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(this.grassColor);
		specialEffectsBuilder.foliageColorOverride(this.foliageColor);
		return specialEffectsBuilder.build();
	}
	
	protected abstract ConfiguredSurfaceBuilder<?> getSurfaceBuilder();
	
	protected void getMobSpawnOverwrite(MobSpawnBuilder modBuilder) {
		
	}
	
	protected void getBiomeGenerationOverwrite(BiomeGenerationBuilder generationBuilder) {
		
	}

	@Override
	public Optional<Supplier<ConfiguredSurfaceBuilder<?>>> getModSurfaceBuilder() {
		return Optional.empty();
	}

	@Override
	public Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> getModFeatures() {
		return BiomeUtil.makeModFeaturesMap();
	}

	@Override
	public Map<Carving, List<Supplier<ConfiguredWorldCarver<?>>>> getModWorldCarvers() {
		return BiomeUtil.makeModCarversMap();
	}

	@Override
	public List<Supplier<ConfiguredStructureFeature<?, ?>>> getModStructures() {
		return Lists.newArrayList();
	}

}
