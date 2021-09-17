package net.luis.nero.common.world.biome.deepslate;

import net.luis.nero.api.common.world.biome.IBiome;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.luis.nero.common.world.biome.features.DefaultVanillaBiomeSpawns;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DeepslateBiome implements IBiome {
	
	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public BiomeCategory getCategory() {
		return BiomeCategory.UNDERGROUND;
	}
	
	@Override
	public float getDepth() {
		return 0.0F;
	}
	
	@Override
	public float getScale() {
		return 0.0F;
	}
	
	@Override
	public float getTemperature() {
		return 0.0F;
	}
	
	@Override
	public float getDownfall() {
		return 0.0F;
	}
	
	@Override
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4159204);
		specialEffectsBuilder.waterFogColor(329011);
		specialEffectsBuilder.fogColor(12638463);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(7979098);
		specialEffectsBuilder.foliageColorOverride(5877296);
		return specialEffectsBuilder.build();
	}

	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		mobBuilder.removeSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
		return mobBuilder.build();
	}

	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> ConfiguredModSurfaceBuilders.DEEPSLATE);
		return generationBuilder.build();
	}

	@Override
	public ModBiomeFeatures getModFeatures() {
		return new ModBiomeFeatures();
	}
	
}
