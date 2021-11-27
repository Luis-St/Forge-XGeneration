package net.luis.nero.common.world.biome;

import java.util.Optional;

import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeSpecialEffects.GrassColorModifier;

@Deprecated(forRemoval = true)
public abstract class ModBiome implements IBiome {
	
	protected final BiomeEffects biomeEffects;
	
	protected ModBiome(BiomeEffects biomeEffects) {
		this.biomeEffects = biomeEffects;
	}
	
	public BiomeEffects getBiomeEffects() {
		return this.biomeEffects;
	}
	
	@Override
	public BiomeCategory getCategory() {
		return BiomeCategory.NONE;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeSpecialEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(this.biomeEffects.getWaterColor());
		specialEffectsBuilder.waterFogColor(this.biomeEffects.getWaterFogColor());
		specialEffectsBuilder.fogColor(this.biomeEffects.getFogColor());
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(this.biomeEffects.getGrassColor());
		specialEffectsBuilder.foliageColorOverride(this.biomeEffects.getFoliageColor());
		Optional<GrassColorModifier> grassModifier = this.getGrassColorModifier();
		specialEffectsBuilder.grassColorModifier(grassModifier.isPresent() ? grassModifier.get() : GrassColorModifier.NONE);
		return specialEffectsBuilder.build();
	}
	
	protected Optional<GrassColorModifier> getGrassColorModifier() {
		return Optional.empty();
	}
	
	@Override
	public ModBiomeFeatures getModFeatures() {
		return new ModBiomeFeatures();
	}
	
}
