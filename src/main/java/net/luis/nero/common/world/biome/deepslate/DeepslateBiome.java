package net.luis.nero.common.world.biome.deepslate;

import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.luis.nero.common.world.levelgen.feature.DefaultModFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

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
	
}
