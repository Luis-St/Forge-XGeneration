package net.luis.nero.common.world.biome.deepslate.cave;

import net.luis.nero.api.util.annotation.NotTested;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class LushCaveBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 1.5F;
	}
	
//	@Override
//	public BiomeSpecialEffects getBiomeEffects() {
//		BiomeSpecialEffects.Builder ambienceBuilder = new BiomeSpecialEffects.Builder();
//		ambienceBuilder.waterColor(4169444);
//		ambienceBuilder.waterFogColor(332595);
//		ambienceBuilder.fogColor(9352375);
//		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
//		ambienceBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
//		ambienceBuilder.grassColorOverride(4710195);
//		ambienceBuilder.foliageColorOverride(1756928);
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
		ambienceBuilder.grassColorOverride(65280);
		ambienceBuilder.foliageColorOverride(5877296);
		return ambienceBuilder.build();
	}

}
