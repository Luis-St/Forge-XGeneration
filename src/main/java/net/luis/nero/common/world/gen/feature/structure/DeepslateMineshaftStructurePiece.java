package net.luis.nero.common.world.gen.feature.structure;

import java.util.Random;

import net.luis.nero.api.common.world.gen.feature.structure.ModStructurePiece;
import net.luis.nero.init.world.gen.feature.structure.ModStructurePieceTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslateMineshaftStructurePiece extends ModStructurePiece {
	
	public DeepslateMineshaftStructurePiece(Random rng, int x, int y, int z) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, rng, x, y, z);
	}

	public DeepslateMineshaftStructurePiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, templateManager, nbt);
	}
	
	@Override
	// TODO: better mineshaft gen -> less code/methods (use count)
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rng, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
		this.generateAirBox(seedReader, boundingBox, -16, -16, -16, 16, 16, 16); // -> World gen BUG

		
		this.updateBoundingBox(seedReader, boundingBox);
		return true;
	}
	
	protected void updateBoundingBox(ISeedReader seedReader, MutableBoundingBox boundingBox) {
		for (int x = boundingBox.x0; x <= boundingBox.x1; x++) {
			for (int y = boundingBox.y0; y <= boundingBox.y1; y++) {
				for (int z = boundingBox.z0; z <= boundingBox.z1; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					seedReader.getChunk(pos).markPosForPostprocessing(pos);
				}
			}
		}
	}
	
}
