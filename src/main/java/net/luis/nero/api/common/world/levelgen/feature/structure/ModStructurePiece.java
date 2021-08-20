package net.luis.nero.api.common.world.levelgen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

// TODO: fix boundingBox in constructor
// TODO: test move boundingBox xyz-, test move pos in get world pos + -> after fix Orientation bug
public abstract class ModStructurePiece extends StructurePiece {

	protected final int width;
	protected final int height;
	protected final int depth;

	protected ModStructurePiece(StructurePieceType pieceType, Random rng, int x, int y, int z, int width, int height, int depth) {
		super(pieceType, 0, null);
		this.width = width;
		this.height = height;
		this.depth = depth;
//		this.setOrientation(Direction.NORTH); // Don't work
		this.setOrientation(Direction.Plane.HORIZONTAL.getRandomDirection(rng)); // Work
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new BoundingBox(x, y, z, x + (width * 2) - 1, y + (height * 2) - 1, z + (depth * 2) - 1);
		} else {
			this.boundingBox = new BoundingBox(x, y, z, x + (depth * 2) - 1, y + (height * 2) - 1, z + (width * 2) - 1);
		}
	} 
	
	protected ModStructurePiece(StructurePieceType pieceType, CompoundTag nbt) {
		super(pieceType, nbt);
		this.width = nbt.getInt("Width");
		this.height = nbt.getInt("Height");
		this.depth = nbt.getInt("Depth");
	}
	 
	@Override
	protected void addAdditionalSaveData(ServerLevel serverWorld, CompoundTag nbt) {
		nbt.putInt("Width", this.width);
		nbt.putInt("Height", this.height);
		nbt.putInt("Depth", this.depth);
	}
	
	protected int getX(int x) {
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			return x + this.width;
		} else {
			return x + this.depth;
		}
	}
	
	protected int getY(int y) {
		return y + this.height;
	}
	
	protected int getZ(int z) {
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			return z + this.depth;
		} else {
			return z + this.width;
		}
	}
	
}
