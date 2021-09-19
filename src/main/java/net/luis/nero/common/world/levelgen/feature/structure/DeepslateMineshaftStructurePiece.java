package net.luis.nero.common.world.levelgen.feature.structure;

import java.util.Random;

import net.luis.nero.api.common.world.levelgen.feature.structure.ModStructurePiece;
import net.luis.nero.init.world.levelgen.feature.structure.ModStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

// random direction in ScatteredStructurePiece line 22
public class DeepslateMineshaftStructurePiece extends /*ScatteredStructurePiece*/ModStructurePiece {
	
	protected final Random rng;
	
	public DeepslateMineshaftStructurePiece(ServerLevel serverLevel, CompoundTag tag) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, tag);
		this.rng = new WorldgenRandom();
	}

	public DeepslateMineshaftStructurePiece(Random rng, int x, int y, int z) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, rng, x, 0, z, 256, 256, 256);
		this.rng = rng;
	}
	
	@Override
	public boolean postProcess(WorldGenLevel worldLevel, StructureFeatureManager structureManager, ChunkGenerator chunkGenerator, Random rng, BoundingBox boundingBox, 
			ChunkPos chunkPos, BlockPos blockPos) {
		this.generateAirBox(worldLevel, boundingBox, this.getX(-8), this.getY(-8), this.getZ(-8), this.getX(8), this.getY(8), this.getZ(8)); // -> issu with generating
//		this.updateBoundingBox(worldLevel, boundingBox);
		return true;
	}

//	protected void updateBoundingBox(WorldGenLevel worldLevel, BoundingBox boundingBox) {
//		for (int x = boundingBox.x0; x <= boundingBox.x1; x++) {
//			for (int y = boundingBox.y0; y <= boundingBox.y1; y++) {
//				for (int z = boundingBox.z0; z <= boundingBox.z1; z++) {
//					BlockPos pos = new BlockPos(x, y, z);
//					worldLevel.getChunk(pos).markPosForPostprocessing(pos);
//				}
//			}
//		}
//	}
	
}
