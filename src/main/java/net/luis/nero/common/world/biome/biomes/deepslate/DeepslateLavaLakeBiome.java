package net.luis.nero.common.world.biome.biomes.deepslate;

import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class DeepslateLavaLakeBiome extends DeepslateBiome {
	
	public DeepslateLavaLakeBiome(BiomeEffects biomeEffects) {
		super(biomeEffects);
	}

	@Override
	public float getTemperature() {
		return 2.0F;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeSpecialEffects() {
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
