package net.luis.nero.common.world.biome.deepslate;

import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.enums.BiomeEffects;
import net.luis.nero.common.world.levelgen.feature.biome.DefaultVanillaBiomeSpawns;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DeepslateOceanBiome extends DeepslateBiome {
	
	public DeepslateOceanBiome(BiomeEffects biomeEffects) {
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
		specialEffectsBuilder.grassColorOverride(255);
		specialEffectsBuilder.foliageColorOverride(5877296);
		return specialEffectsBuilder.build();
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultVanillaBiomeSpawns.addCommonMonsterSpawns(mobBuilder);
		return mobBuilder.build();
	}
	
}
