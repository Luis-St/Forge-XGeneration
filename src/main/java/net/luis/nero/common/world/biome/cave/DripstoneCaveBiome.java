package net.luis.nero.common.world.biome.cave;

import net.luis.nero.common.world.biome.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DripstoneCaveBiome extends DeepslateBiome {
	
	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder ambienceBuilder = new BiomeSpecialEffects.Builder();
		ambienceBuilder.waterColor(4159204);
		ambienceBuilder.waterFogColor(329011);
		ambienceBuilder.fogColor(12638463);
		ambienceBuilder.skyColor(this.calculateSkyColor(0.8F));
		ambienceBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		ambienceBuilder.grassColorOverride(5059871);
		ambienceBuilder.foliageColorOverride(5877296);
		return ambienceBuilder.build();
	}
	
}
