package net.luis.nero.common.world.biome.deepslate;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.enums.NoiseType;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeSpawns;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

// TODO: add Biomes (noise caves)
public class DeepslateBiome extends ModBiome {

	public DeepslateBiome(BiomeEffects biomeEffects) {
		super(biomeEffects);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public double getBaseNoise() {
		return 0.0;
	}

	@Override
	public double getNoiseScale() {
		return 0.0;
	}

	@Override
	public INoiseType getNoiseType() {
		return NoiseType.FLAT;
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
	
}
