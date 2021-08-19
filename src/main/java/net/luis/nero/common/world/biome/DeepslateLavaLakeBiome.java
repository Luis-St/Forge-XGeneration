package net.luis.nero.common.world.biome;

import net.luis.nero.api.util.annotation.NotTested;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepslateLavaLakeBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 2.0F;
	}
	
//	@Override
//	public BiomeSpecialEffects getBiomeEffects() {
//		BiomeSpecialEffects.Builder ambienceBuilder = new BiomeSpecialEffects.Builder();
//		ambienceBuilder.waterColor(4010530);
//		ambienceBuilder.waterFogColor(1053449);
//		ambienceBuilder.fogColor(9074550);
//		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
//		ambienceBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
//		ambienceBuilder.grassColorOverride(10187605);
//		ambienceBuilder.foliageColorOverride(8478784);
//		return ambienceBuilder.build();
//	}
	
	@Override
	@NotTested
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder ambienceBuilder = new BiomeSpecialEffects.Builder();
		ambienceBuilder.waterColor(4159204);
		ambienceBuilder.waterFogColor(329011);
		ambienceBuilder.fogColor(12638463);
		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
		ambienceBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		ambienceBuilder.grassColorOverride(16711680);
		ambienceBuilder.foliageColorOverride(5877296);
		return ambienceBuilder.build();
	}
	
}
