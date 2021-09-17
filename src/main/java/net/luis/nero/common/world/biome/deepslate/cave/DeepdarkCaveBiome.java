package net.luis.nero.common.world.biome.deepslate.cave;

import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepdarkCaveBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 0.5F;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4400);
		specialEffectsBuilder.waterFogColor(30);
		specialEffectsBuilder.fogColor(9800);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(213328);
		specialEffectsBuilder.foliageColorOverride(5153);
		return specialEffectsBuilder.build();
	}

}
