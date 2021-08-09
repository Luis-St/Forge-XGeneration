package net.luis.nero.common.world.gen.feature.structure.start;

import net.luis.nero.common.world.gen.feature.structure.DeepslateMineshaftStructurePiece;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

public class DeepslateMineshaftStructureStart extends StructureStart<NoneFeatureConfiguration> {
	
	public DeepslateMineshaftStructureStart(StructureFeature<NoneFeatureConfiguration> structure, ChunkPos chunkPos, int reference, long seed) {
		super(structure, chunkPos, reference, seed);
	}

	@Override
	public void generatePieces(RegistryAccess registry, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, 
			NoneFeatureConfiguration config, LevelHeightAccessor levelAccessor) {
		DeepslateMineshaftStructurePiece structurePiece = new DeepslateMineshaftStructurePiece(random, (chunkPos.x << 4) + 7, 128, (chunkPos.z << 4) + 7);
		this.pieces.add(structurePiece);
		this.moveInsideHeights(random, 128, 128);
//		Nero.LOGGER.debug("Generate deepslate mineshaft structure at {}, {}, {}", (chunkPos.x << 4) + 7, 128, (chunkPos.z << 4) + 7);
	}
	
}
