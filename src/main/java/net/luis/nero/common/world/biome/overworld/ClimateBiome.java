package net.luis.nero.common.world.biome.overworld;

import net.luis.nero.api.common.world.biome.OverworldBiome;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ClimateBiome extends OverworldBiome {
	
	protected final float temperature;
	
	public ClimateBiome(float temperature, int grassColor) {
		super(-1, -1, -1, grassColor, -1);
		this.temperature = temperature;
	}

	@Override
	public Precipitation getPrecipitation() {
		return Precipitation.NONE;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	protected void getBiomeGenerationOverwrite(BiomeGenerationBuilder generationBuilder) {
		generationBuilder.removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION.ordinal(), Features.SPRING_WATER);
		generationBuilder.removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION.ordinal(), Features.SPRING_LAVA);
		generationBuilder.removeFeature(GenerationStep.Decoration.LAKES.ordinal(), Features.LAKE_WATER);
		generationBuilder.removeFeature(GenerationStep.Decoration.LAKES.ordinal(), Features.LAKE_LAVA);
		generationBuilder.removeCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
		generationBuilder.removeCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
	}

}
