package net.luis.industry.common.world.biome;

import net.luis.industry.common.world.feature.DefaultModFeatures;
import net.luis.industry.common.world.surfacebuilder.ConfiguredModSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;

public class DeepslateBiome implements IBiome {
	
	@Override
	public Biome.RainType getRainType() {
		return RainType.NONE;
	}
	
	@Override
	public Category getCategory() {
		return Category.NONE;
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
		return 1.0F;
	}
	
	@Override
	public float getDownfall() {
		return 0.0F;
	}
	
	@Override
	public BiomeAmbience getBiomeAmbience() {
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		ambienceBuilder.waterColor(4159204);
		ambienceBuilder.waterFogColor(329011);
		ambienceBuilder.fogColor(12638463);
		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
		ambienceBuilder.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS);
		return ambienceBuilder.build();
	}

	@Override
	public MobSpawnInfo getMobSpawnSettings() {
		MobSpawnInfo.Builder modBuilder = new MobSpawnInfo.Builder();
		DefaultModFeatures.addCommonSpawns(modBuilder);
		return modBuilder.build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder();
		generationBuilder.surfaceBuilder(() -> ConfiguredModSurfaceBuilders.DEEPSLATE);
		return generationBuilder.build();
	}
	
}
