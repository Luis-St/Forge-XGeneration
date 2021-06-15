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

public class DeepslatePortalStructure extends Structure<NoFeatureConfig> {

	public DeepslatePortalStructure() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return DeepslatePortalStructure.Start::new;
	}
	
	@Override
	public Decoration step() {
		return Decoration.UNDERGROUND_STRUCTURES;
	}
	
	@Override
	protected boolean isFeatureChunk(ChunkGenerator generator, BiomeProvider biomeProvider, long seed, SharedSeedRandom rng, int chunkX, int chunkZ, 
			Biome biome, ChunkPos chunkPos, NoFeatureConfig config) {
		return true;
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {

		public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ,MutableBoundingBox boundingBox, int reference, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, reference, seed);
		}

		@Override
		public void generatePieces(DynamicRegistries registries, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, 
				Biome biome, NoFeatureConfig config) {
			DeepslatePortalStructurePiece portalStructurePiece = new DeepslatePortalStructurePiece(random, (chunkX << 4) + 7, 5, (chunkZ << 4) + 7);
			this.pieces.add(portalStructurePiece);
			this.calculateBoundingBox();
		}
		
	}

}
