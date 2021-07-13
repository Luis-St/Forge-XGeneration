package net.luis.nero.common.world.gen.feature.structure;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

// TODO: finish

public class DeepslateMineshaftStructure extends Structure<NoFeatureConfig> {

	public DeepslateMineshaftStructure() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return DeepslateMineshaftStructure.Start::new;
	}
	
	@Override
	public Decoration step() {
		return Decoration.UNDERGROUND_STRUCTURES;
	}
	
	@Override
	protected boolean isFeatureChunk(ChunkGenerator generator, BiomeProvider biomeProvider, long seed, SharedSeedRandom seedRng, int chunkX, int chunkZ, 
			Biome biome, ChunkPos chunkPos, NoFeatureConfig config) {
//		double d = seedRng.nextDouble();
//		Nero.LOGGER.debug("isFeatureChunk: " + (d < 0.05));
//		Nero.LOGGER.debug("isFeatureChunk: " + d);
		return /*d < 0.05*/true;
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {

		public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ,MutableBoundingBox boundingBox, int reference, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, reference, seed);
		}

		@Override
		public void generatePieces(DynamicRegistries registries, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, 
				Biome biome, NoFeatureConfig config) {
			DeepslateMineshaftStructurePiece structurePiece = new DeepslateMineshaftStructurePiece(random, (chunkX << 4) + 7, 128, (chunkZ << 4) + 7);
			this.pieces.add(structurePiece);
			this.calculateBoundingBox();
//			this.moveInsideHeights(random, 128, 128);
//			Nero.LOGGER.debug("Generate deepslate mineshaft structure at {}, {}, {}", (chunkX << 4) + 7, 128, (chunkZ << 4) + 7);
		}
		
	}

}
