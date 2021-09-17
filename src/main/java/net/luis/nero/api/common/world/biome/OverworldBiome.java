package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public abstract class OverworldBiome extends ModBiome {
	
	protected final float temperature;
	
	public OverworldBiome(BiomeEffects biomeEffects, float temperature) {
		super(biomeEffects == null ? BiomeEffects.OVERWORLD : biomeEffects);
		this.temperature = temperature;
	}
	
	@Override
	public Precipitation getPrecipitation() {
		if (this.temperature >= 2.0F) {
			return Precipitation.NONE;
		}
		return this.temperature > 0.05F ? Precipitation.RAIN : Precipitation.SNOW;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public float getDownfall() {
		return this.temperature > 2.0F ? 0.0F : 1.0F;
	}
	
	@Override
	public final MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
//		DefaultModFeatures.addOverworldSpawns(mobBuilder);
		this.getMobSpawnOverwrite(mobBuilder);
		return mobBuilder.build();
	}
	
	@Override
	public final BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> this.getSurfaceBuilder());
//		DefaultModFeatures.addOverworldFeatures(generationBuilder);
		this.getBiomeGenerationOverwrite(generationBuilder);
		return generationBuilder.build();
	}
	
	@Override
	protected ConfiguredSurfaceBuilder<?> getSurfaceBuilder() {
		return SurfaceBuilders.GRASS;
	}
	
}
