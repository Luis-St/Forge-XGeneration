package net.luis.nero.common.world.gen.feature.structure;

import net.luis.nero.common.world.gen.feature.structure.start.DeepslateMineshaftStructureStart;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeepslateMineshaftStructure extends StructureFeature<NoneFeatureConfiguration> {

	public DeepslateMineshaftStructure() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
		return DeepslateMineshaftStructureStart::new;
	}
	
	@Override
	public Decoration step() {
		return Decoration.UNDERGROUND_STRUCTURES;
	}
	
	@Override
	protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed, WorldgenRandom worldRandom, ChunkPos chunkPos, Biome biome, 
			ChunkPos potentialChunkPos, NoneFeatureConfiguration config, LevelHeightAccessor levelAccessor) {
//		double d = worldRandom.nextDouble();
//		Nero.LOGGER.debug("isFeatureChunk: " + (d < 0.05));
//		Nero.LOGGER.debug("isFeatureChunk: " + d);
		return /*d < 0.05*/true;
	}

}
