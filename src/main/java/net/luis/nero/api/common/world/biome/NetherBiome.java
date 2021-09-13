package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.levelgen.feature.DefaultModFeatures;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public abstract class NetherBiome extends ModBiome {
	
	public NetherBiome(int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor) {
		super(waterColor, waterFogColor, fogColor, grassColor, foliageColor);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}

	@Override
	public final MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		DefaultModFeatures.addNetherSpawns(mobBuilder);
		this.getMobSpawnOverwrite(mobBuilder);
		return mobBuilder.build();
	}
	
	protected void getMobSpawnOverwrite(MobSpawnBuilder modBuilder) {
		
	}

	@Override
	public final BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> this.getSurfaceBuilder());
		DefaultModFeatures.addNetherFeatures(generationBuilder);
		this.getBiomeGenerationOverwrite(generationBuilder);
		return generationBuilder.build();
	}
	
	protected ConfiguredSurfaceBuilder<?> getSurfaceBuilder() {
		return SurfaceBuilders.NETHER;
	}
	
	protected void getBiomeGenerationOverwrite(BiomeGenerationBuilder generationBuilder) {
		
	}
	
}
