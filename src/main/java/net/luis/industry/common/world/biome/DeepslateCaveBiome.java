package net.luis.industry.common.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class DeepslateCaveBiome implements IBiome {
	
	public DeepslateCaveBiome() {
		
	}
	
	@Override
	public Biome createBiome(Biome.Builder biomeBuilder) {
		biomeBuilder.precipitation(this.getRainType());
		biomeBuilder.biomeCategory(this.getCategory());
		biomeBuilder.depth(this.getDepth());
		biomeBuilder.scale(this.getScale());
		biomeBuilder.temperature(this.getTemperature());
		biomeBuilder.downfall(this.getDownfall());
		biomeBuilder.specialEffects(this.getBiomeAmbience(new BiomeAmbience.Builder()));
		biomeBuilder.mobSpawnSettings(this.getMobSpawnSettings(new MobSpawnInfo.Builder()));
		biomeBuilder.generationSettings(this.getBiomeGenerationSettings(new BiomeGenerationSettings.Builder()));
		return biomeBuilder.build();
	}

	@Override
	public RainType getRainType() {
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
	public BiomeAmbience getBiomeAmbience(BiomeAmbience.Builder ambienceBuilder) {
		ambienceBuilder.waterColor(4159204);
		ambienceBuilder.waterFogColor(329011);
		ambienceBuilder.fogColor(12638463);
		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
		ambienceBuilder.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS);
		return ambienceBuilder.build();
	}

	@Override
	public MobSpawnInfo getMobSpawnSettings(MobSpawnInfo.Builder modBuilder) {
		DefaultBiomeFeatures.commonSpawns(modBuilder);
		return modBuilder.build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings(BiomeGenerationSettings.Builder generationBuilder) {
		generationBuilder.surfaceBuilder(ConfiguredSurfaceBuilders.STONE);
		return generationBuilder.build();
	}
	
}
