package net.luis.nero.common.world.biome.biomes.deepslate;

import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.biome.BiomeGenerationBuilder;
import net.luis.nero.common.world.biome.MobSpawnBuilder;
import net.luis.nero.common.world.biome.ModBiome;
import net.luis.nero.common.world.biome.feature.DefaultVanillaBiomeSpawns;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModSurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DeepslateBiome extends ModBiome {

	public DeepslateBiome(BiomeEffects biomeEffects) {
		super(biomeEffects);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public float getTemperature() {
		return 0.5F;
	}

	@Override
	public float getDownfall() {
		return 0.0F;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return IBiomeNoise.NULL;
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
