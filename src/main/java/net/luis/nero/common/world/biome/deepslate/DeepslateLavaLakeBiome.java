package net.luis.nero.common.world.biome.deepslate;

import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepslateLavaLakeBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 2.0F;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4010530);
		specialEffectsBuilder.waterFogColor(1053449);
		specialEffectsBuilder.fogColor(9074550);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(10187605);
		specialEffectsBuilder.foliageColorOverride(8478784);
		return specialEffectsBuilder.build();
	}
	
}
