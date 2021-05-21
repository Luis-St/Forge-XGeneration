package net.luis.industry.common.world.biome;

import net.luis.industry.common.world.feature.DefaultModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;

public class DeepslateBiome implements IBiome {
	
	@Override
	public Biome createBiome() {
		Biome.Builder biomeBuilder = new Biome.Builder();
		biomeBuilder.precipitation(this.getRainType());
		biomeBuilder.biomeCategory(this.getCategory());
		biomeBuilder.depth(this.getDepth());
		biomeBuilder.scale(this.getScale());
		biomeBuilder.temperature(this.getTemperature());
		biomeBuilder.downfall(this.getDownfall());
		biomeBuilder.specialEffects(this.getBiomeAmbience());
		biomeBuilder.mobSpawnSettings(this.getMobSpawnSettings());
		biomeBuilder.generationSettings(this.getBiomeGenerationSettings());
		return biomeBuilder.build();
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
	
}
