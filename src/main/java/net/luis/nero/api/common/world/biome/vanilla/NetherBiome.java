package net.luis.nero.api.common.world.biome.vanilla;

import net.luis.nero.api.common.world.biome.ModBiome;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.enums.BiomeEffects;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public abstract class NetherBiome extends ModBiome {
	
	protected NetherBiome() {
		super(BiomeEffects.NETHER);
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}

	@Override
	public final MobSpawnSettings getMobSpawnSettings() {
		MobSpawnBuilder mobBuilder = new MobSpawnBuilder();
		this.getMobSpawnOverwrite(mobBuilder);
		return mobBuilder.build();
	}

	@Override
	public final BiomeGenerationSettings getBiomeGenerationSettings() {
		BiomeGenerationBuilder generationBuilder = new BiomeGenerationBuilder();
		generationBuilder.surfaceBuilder(() -> SurfaceBuilders.NETHER);
		this.getBiomeGenerationOverwrite(generationBuilder);
		return generationBuilder.build();
	}
	
}
