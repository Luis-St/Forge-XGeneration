package net.luis.nero.common.world.gen.feature.structure;

import java.util.Random;

import net.luis.nero.Nero;
import net.luis.nero.api.common.world.gen.feature.structure.ModStructurePiece;
import net.luis.nero.init.world.gen.feature.structure.ModStructurePieceTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

// random direction in ScatteredStructurePiece line 22
public class DeepslateMineshaftStructurePiece extends /*ScatteredStructurePiece*/ModStructurePiece {
	
	/*
[1.16.5][Bug?] Structure generation broken

okay, a little explanation to make the whole problem clearer:
I am currently trying to create a custom mineshaft that should generate in my custom dimension,
it works as far, but if the structure goes beyond the size of a chunks, it no longer generates,
I have tested a lot and can't find the problem. even simple structures (a room of air) does not generate.
	 */
	
	protected final Random rng;
	
	public DeepslateMineshaftStructurePiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, /*templateManager,*/ nbt);
		this.rng = new SharedSeedRandom();
	}

	public DeepslateMineshaftStructurePiece(Random rng, int x, int y, int z) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, rng, x, 0, z, 256, 256, 256);
		this.rng = rng;
	}
	
	@Override
	// TODO: better mineshaft gen -> less code/methods (use count)
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rng, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
		Nero.LOGGER.debug("MutableBoundingBox: minX {}, minY {}, minZ {}, maxX {}, maxY {}, maxZ {} and spanX {}, spanY {}, spanZ {}", 
				this.boundingBox.x0, this.boundingBox.y0, this.boundingBox.z0, this.boundingBox.x1, 
				this.boundingBox.y1, this.boundingBox.z1, this.boundingBox.getXSpan(), this.boundingBox.getYSpan(), this.boundingBox.getZSpan());

		this.generateAirBox(seedReader, boundingBox, 16, 16, 16, 32, 32, 32); // -> issu with generating

		
//		this.updateBoundingBox(seedReader, boundingBox);
		return true;
	}

//	protected void updateBoundingBox(ISeedReader seedReader, MutableBoundingBox boundingBox) {
//		for (int x = boundingBox.x0; x <= boundingBox.x1; x++) {
//			for (int y = boundingBox.y0; y <= boundingBox.y1; y++) {
//				for (int z = boundingBox.z0; z <= boundingBox.z1; z++) {
//					BlockPos pos = new BlockPos(x, y, z);
//					seedReader.getChunk(pos).markPosForPostprocessing(pos);
//				}
//			}
//		}
//	}
	
}
