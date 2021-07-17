package net.luis.nero.api.common.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;

// TODO: test move boundingBox xyz-, test move pos in get world pos + -> after fix Orientation bug
public abstract class ModStructurePiece extends StructurePiece {

	protected final int width;
	protected final int height;
	protected final int depth;

	protected ModStructurePiece(IStructurePieceType pieceType, Random rng, int x, int y, int z, int width, int height, int depth) {
		super(pieceType, 0);
		this.width = width;
		this.height = height;
		this.depth = depth;
		// Work
		this.setOrientation(Direction.Plane.HORIZONTAL.getRandomDirection(rng));
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + width - 1, y + height - 1, z + depth - 1);
		} else {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + depth - 1, y + height - 1, z + width - 1);
		}
		
		// Don't work
		this.setOrientation(Direction.NORTH);
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new MutableBoundingBox(x - width + 1, y, z + depth - 1, x + width - 1, y + height - 1, z + depth - 1);
		} else {
			this.boundingBox = new MutableBoundingBox(x - depth + 1, y, z - width + 1, x + depth - 1, y + height - 1, z + width - 1);
		}
	}

	protected ModStructurePiece(IStructurePieceType pieceType, CompoundNBT nbt) {
		super(pieceType, nbt);
		this.width = nbt.getInt("Width");
		this.height = nbt.getInt("Height");
		this.depth = nbt.getInt("Depth");
	}
	
	@Override
	protected void addAdditionalSaveData(CompoundNBT nbt) {
		nbt.putInt("Width", this.width);
		nbt.putInt("Height", this.height);
		nbt.putInt("Depth", this.depth);
	}

}
