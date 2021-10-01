package net.luis.nero.common.world.biome.deepslate.cave;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepslateDripstoneCaveBiome extends DeepslateBiome {
	
	public DeepslateDripstoneCaveBiome(BiomeEffects biomeEffects) {
		super(biomeEffects);
	}

	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4159204);
		specialEffectsBuilder.waterFogColor(329011);
		specialEffectsBuilder.fogColor(12638463);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(5059871);
		specialEffectsBuilder.foliageColorOverride(5877296);
		return specialEffectsBuilder.build();
	}
	
}
