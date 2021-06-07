package net.luis.nero.common.world.structure;

import com.mojang.serialization.Codec;

import net.luis.nero.Nero;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslateMineshaftStructure extends Structure<NoFeatureConfig> {

	public DeepslateMineshaftStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
	}
	
	@Override
	public Decoration step() {
		return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
	}
	
	@Override
	public String getFeatureName() {
		return new ResourceLocation(Nero.MOD_ID, "deepslate_mineshaft").toString();
	}
	
	@Override
	protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeProvider, long seed, SharedSeedRandom rng, int x, int z, Biome biome, 
			ChunkPos pos, NoFeatureConfig config) {
		rng.setLargeFeatureSeed(seed, x, z);
		Nero.LOGGER.debug("isFeatureChunk");
		return /*rng.nextInt(10) == 0*/ true;
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
			Nero.LOGGER.debug("generatePieces");
			DeepslateMineshaftPiece mineshaftPiece = new DeepslateMineshaftPiece(this.random, chunkX * 16, chunkZ * 16);
			this.pieces.add(mineshaftPiece);
			this.calculateBoundingBox();
			this.moveBelowSeaLevel(256, this.random, 10);
		}
		
	}
	
}
