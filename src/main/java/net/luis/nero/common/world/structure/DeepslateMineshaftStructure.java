package net.luis.nero.common.world.structure;

import java.util.Random;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslateMineshaftStructure extends Structure<NoFeatureConfig> {

	public DeepslateMineshaftStructure() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return DeepslateMineshaftStructure.Start::new;
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {

		public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int references, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, references, seed);
		}

		@Override
		public void generatePieces(DynamicRegistries registries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, 
				NoFeatureConfig config) {
			DeepslateMineshaftPiece mineshaftPiece = new DeepslateMineshaftPiece(this.random, chunkX * 16, chunkZ * 16);
			this.pieces.add(mineshaftPiece);
			this.calculateBoundingBox();
			this.moveRandom(random, chunkX, chunkZ);
		}
		
		protected void moveRandom(Random rng, int yMin, int yMax) {
			int yOffset = 256 / 16; // TODO: if config ready set field world height -> use for gen of deepslate dim
			this.moveInsideHeights(rng, yMin + yOffset, yMax - yOffset);
		}
		
	}
	
}
