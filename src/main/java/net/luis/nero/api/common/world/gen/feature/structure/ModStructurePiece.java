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
	
}
