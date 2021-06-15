package net.luis.nero.common.world.gen.feature.structure;

import java.util.Random;

import net.luis.nero.init.world.structure.ModStructurePieceTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslatePortalStructurePiece extends ScatteredStructurePiece {
	
	public DeepslatePortalStructurePiece(Random rng, int x, int y, int z) {
		super(ModStructurePieceTypes.DEEPSLATE_PORTAL, rng, x, y, z, 10, 10, 10);
	}

	public DeepslatePortalStructurePiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructurePieceTypes.DEEPSLATE_PORTAL, nbt);
	}

	@Override
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rng, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos pos) {
		this.generateBox(seedReader, boundingBox, -2, -2, -2, 2, 2, 2, Blocks.STONE.defaultBlockState(), CAVE_AIR, false);
		return true;
	}
	
}
