package net.luis.nero.api.common.world.gen.feature.structure;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

public abstract class ModStructurePiece extends ScatteredStructurePiece {
	
	protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
	protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
	protected static final BlockState DEEPSLATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	
	protected ModStructurePiece(IStructurePieceType pieceType, TemplateManager templateManager, CompoundNBT nbt) {
		super(pieceType, nbt);
	}
	
	protected ModStructurePiece(IStructurePieceType pieceType, Random rng, int x, int y, int z) {
		super(pieceType, rng, x, y, z, 0, 0, 0);
	}
	
	@Override
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rng, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
		return true;
	}
	
	protected void generateCube(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin,int xMax, int yMax, int zMax, 
			BlockState blockState) {
		for (int x = xMin; x <= xMax; x++) {
			for (int y = yMin; y <= yMax; y++) {
				for (int z = zMin; z <= zMax; z++) {
					this.placeBlock(seedReader, blockState, x, y, z, boundingBox);
				}
			}
		}
	}
	
	protected void generateCube(ISeedReader seedReader, MutableBoundingBox boundingBox, BlockPos minPos, BlockPos maxPos, BlockState blockState) {
		for (int x = minPos.getX(); x <= maxPos.getX(); x++) {
			for (int y = minPos.getY(); y <= maxPos.getY(); y++) {
				for (int z = minPos.getZ(); z <= maxPos.getZ(); z++) {
					this.placeBlock(seedReader, blockState, x, y, z, boundingBox);
				}
			}
		}
	}

	protected void generateAirCube(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax) {
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, CAVE_AIR);
	}

	protected void generateStoneCube(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax) {
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, STONE);
	}

	protected void generateDeepslateCube(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax) {
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, DEEPSLATE);
	}
	
	protected void generateRoom(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin,int xMax, int yMax, int zMax, 
			BlockState boundaryBlockState, BlockState insideBlockState) {
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, boundaryBlockState);
		this.generateCube(seedReader, boundingBox, xMin +1 , yMin + 1, zMin + 1, xMax - 1, yMax - 1, zMax - 1, insideBlockState);
	}
	
	protected void generateAirRoom(ISeedReader seedReader, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin,int xMax, int yMax, int zMax, 
			BlockState boundaryBlockState) {
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, boundaryBlockState);
		this.generateAirCube(seedReader, boundingBox, xMin +1 , yMin + 1, zMin + 1, xMax - 1, yMax - 1, zMax - 1);
	}
	
}
