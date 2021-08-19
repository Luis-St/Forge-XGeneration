package net.luis.nero.common.world.biome.cave;

import net.luis.nero.api.util.annotation.NotTested;
import net.luis.nero.common.world.biome.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepdarkCaveBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 0.5F;
	}
	
//	@Override
//	public BiomeSpecialEffects getBiomeEffects() {
//		BiomeSpecialEffects.Builder ambienceBuilder = new BiomeSpecialEffects.Builder();
//		ambienceBuilder.waterColor(4400);
//		ambienceBuilder.waterFogColor(30);
//		ambienceBuilder.fogColor(9800);
//		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
//		ambienceBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
//		ambienceBuilder.grassColorOverride(213328);
//		ambienceBuilder.foliageColorOverride(5153);
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
		ambienceBuilder.grassColorOverride(0);
		ambienceBuilder.foliageColorOverride(5877296);
		return ambienceBuilder.build();
	}


}
