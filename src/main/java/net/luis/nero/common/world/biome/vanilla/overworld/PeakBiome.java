package net.luis.nero.common.world.biome.vanilla.overworld;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.luis.nero.api.common.world.biome.vanilla.OverworldBiome;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.vanilla.overworld.type.PeakBiomeType;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModFeatures;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class PeakBiome extends OverworldBiome {
	
	protected final IBiomeType biomeType;
	
	public PeakBiome(BiomeEffects biomeEffects, IBiomeType biomeType) {
		super(biomeEffects, biomeType.getTemperature(), biomeType.getBiomeNoise());
		this.biomeType = biomeType;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.biomeType.getMobSpawnSettings();
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.biomeType.getBiomeGenerationSettings();
	}
	
	@Override
	public ModBiomeFeatures getModFeatures() {
		ModBiomeFeatures modBiomeFeatures = super.getModFeatures();
		if (this.biomeType == PeakBiomeType.MEADOW) {
			modBiomeFeatures.addModFeature(Decoration.VEGETAL_DECORATION, () -> ConfiguredModFeatures.MEADOW_BIRCH_TREE);
			modBiomeFeatures.addModFeature(Decoration.VEGETAL_DECORATION, () -> ConfiguredModFeatures.MEADOW_FLOWERS);
		} else if (this.biomeType == PeakBiomeType.SNOWY_GROVE) {
			modBiomeFeatures.setModSurfaceBuilder(() -> ConfiguredModSurfaceBuilders.SNOWY_GROVE);
			modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.POWDER_SNOW);
		} else if (this.biomeType == PeakBiomeType.SNOWY_SLOPES) {
			modBiomeFeatures.setModSurfaceBuilder(() -> ConfiguredModSurfaceBuilders.SNOWY_SLOPES);
			modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.POWDER_SNOW);
		} else if (this.biomeType == PeakBiomeType.JAGGED_PEAKS) {
			modBiomeFeatures.setModSurfaceBuilder(() -> ConfiguredModSurfaceBuilders.JAGGED_PEAKS);
		} else if (this.biomeType == PeakBiomeType.FROZEN_PEAKS) {
			modBiomeFeatures.setModSurfaceBuilder(() -> ConfiguredModSurfaceBuilders.FROZEN_PEAKS);
			modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.POWDER_SNOW);
		}
		return modBiomeFeatures;
	}
	
	@Override
	public boolean isUnderground() {
		return false;
	}
	
	@Override
	public boolean isOcean() {
		return this.biomeType.isOcean();
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isIsland() {
		return this.biomeType.isIsland();
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.biomeType.isHilly();
	}
	
	@Override
	public boolean isWindswept() {
		return this.biomeType.isWindswept();
	}
	
}
