package net.luis.nero.common.world.structure;

import java.util.Random;

import net.luis.nero.init.world.structure.ModStructureTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslateMineshaftPiece extends ScatteredStructurePiece {

	public DeepslateMineshaftPiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructureTypes.DEEPSLATE_MINESHAFT, nbt);
	}

	public DeepslateMineshaftPiece(Random rng, int x, int z) {
		super(ModStructureTypes.DEEPSLATE_MINESHAFT, rng, x, 128, z, 0, 0, 0);
	}

	@Override
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rng, MutableBoundingBox boundingBox, 
			ChunkPos chunkPos, BlockPos pos) {
		this.generateAirBox(seedReader, boundingBox, -10, -10, -10, 10, 10, 10);
		return true;
	}

}
