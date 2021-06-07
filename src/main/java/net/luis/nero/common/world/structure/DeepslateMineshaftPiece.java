package net.luis.nero.common.world.structure;

import java.util.Random;

import net.luis.nero.Nero;
import net.luis.nero.init.world.structure.ModStructureTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DeepslateMineshaftPiece extends StructurePiece {
	
	protected Random rng;
	protected int x;
	protected int z;

	public DeepslateMineshaftPiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructureTypes.DEEPSLATE_MINESHAFT, nbt);
	}
	
	public DeepslateMineshaftPiece(Random rng, int x, int z) {
		super(ModStructureTypes.DEEPSLATE_MINESHAFT, rng.nextInt());
		this.rng = rng;
		this.x = x;
		this.z = z;
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT nbt) {
		
	}

	@Override
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rng, MutableBoundingBox boundingBox, 
			ChunkPos chunkPos, BlockPos pos) {
		this.generateAirBox(seedReader, boundingBox, -10, -10, -10, 10, 10, 10);
		Nero.LOGGER.debug("generate structure at {}", boundingBox.getCenter());
		return true;
	}

}
